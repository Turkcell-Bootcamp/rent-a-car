package com.example.rentacar.business.concretes;

import com.example.rentacar.business.abstracts.CarService;
import com.example.rentacar.business.abstracts.MaintenanceService;
import com.example.rentacar.dto.request.update.UpdateCarRequestDto;
import com.example.rentacar.dto.response.MaintenanceResponse;
import com.example.rentacar.entities.Car;
import com.example.rentacar.entities.Maintenance;
import com.example.rentacar.repository.MaintanenceRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class MaintenanceManager implements MaintenanceService {

	private final MaintanenceRepository maintanenceRepository;

	private final CarService carService;

	private final ModelMapper modelMapper;

	@Override
	public MaintenanceResponse add(String plate) {

		final Car car = carService.findByPlate(plate);
		checkCarStatus(car);
		final Maintenance maintenance = new Maintenance();
		maintenance.setDate(LocalDate.now());
		maintenance.setCar(car);
		car.setState(3);
		UpdateCarRequestDto updateCarRequestDto = modelMapper.map(car, UpdateCarRequestDto.class);
		carService.update(car.getId(), updateCarRequestDto);
		maintanenceRepository.save(maintenance);

		return new MaintenanceResponse(plate, car.getState());
	}

	@Override
	public void finish(String plate) {

		final Car car = carService.findByPlate(plate);
		car.setState(1);
		UpdateCarRequestDto updateCarRequestDto = modelMapper.map(car, UpdateCarRequestDto.class);
		carService.update(car.getId(), updateCarRequestDto);
	}

	private static void checkCarStatus(Car car) {

		if (car.getState() != 1) {
			throw new RuntimeException("Araba şuan bakıma alınamaz");
		}
	}
}
