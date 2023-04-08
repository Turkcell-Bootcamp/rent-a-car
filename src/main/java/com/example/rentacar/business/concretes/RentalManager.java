package com.example.rentacar.business.concretes;

import com.example.rentacar.business.abstracts.RentalService;
import com.example.rentacar.dto.request.add.RentalRequest;
import com.example.rentacar.dto.response.CarResponse;
import com.example.rentacar.dto.response.RentalResponse;
import com.example.rentacar.entities.Rental;
import com.example.rentacar.entities.enums.State;
import com.example.rentacar.repository.RentalRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/*
    Created by Emrah on 4/8/2023
*/
@Service
@AllArgsConstructor
public class RentalManager implements RentalService {

	private RentalRepository rentalRepository;

	private CarManager carManager;

	private ModelMapper modelMapper;

	@Override
	public RentalResponse add(RentalRequest renatalRequest) {

		CarResponse carResponse = carManager.findById(renatalRequest.getCarId());
		checkIfCarStateNotAvailable(carResponse);
		Rental rental = modelMapper.map(renatalRequest, Rental.class);
		rental.setDailyPrice(carResponse.getDailyPrice());
		rental.setStartDate(LocalDateTime.now());
		checkDiscount(rental);
		carManager.changeState(renatalRequest.getCarId(), State.RENTED);
		rental.setId(0);
		rentalRepository.save(rental);
		return modelMapper.map(rental, RentalResponse.class);
	}

	@Override
	public List<RentalResponse> getAll() {

		return rentalRepository.findAll().stream().map(rental -> modelMapper.map(rental, RentalResponse.class)).toList();
	}

	@Override
	public void delete(int id) {

		Rental rental = rentalRepository.findById(id).orElseThrow(() -> new RuntimeException("Kiralama id bulunamadı"));
		carManager.changeState(rental.getCarId(), State.AVAILABLE);
		rentalRepository.delete(rental);
	}

	private void checkIfCarStateNotAvailable(CarResponse carResponse) {

		if (!carResponse.getState().equals(State.AVAILABLE)) {
			throw new RuntimeException("Araç şuan kiralanamaz.");
		}
	}

	private void checkDiscount(Rental rental) {

		if (rental.getRentedForDays() > 6) {
			int freeDay = rental.getRentedForDays() / 7;
			rental.setTotalPrice(rental.getDailyPrice() * (rental.getRentedForDays() - freeDay));
		}
		else if (rental.getRentedForDays() > 0) {
			rental.setTotalPrice(rental.getDailyPrice() * rental.getRentedForDays());
		}
		else {
			throw new RuntimeException("Hatalı gün sayısı girdiniz");
		}
	}
}
