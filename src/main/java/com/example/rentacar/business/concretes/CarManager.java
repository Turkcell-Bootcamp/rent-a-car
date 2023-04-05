package com.example.rentacar.business.concretes;

import com.example.rentacar.dto.request.add.AddCarRequestDto;
import com.example.rentacar.dto.request.update.UpdateCarRequestDto;
import com.example.rentacar.dto.response.CarResponse;
import com.example.rentacar.dto.response.ModelResponse;
import com.example.rentacar.entities.Car;
import com.example.rentacar.business.abstracts.CarService;
import com.example.rentacar.entities.Model;
import com.example.rentacar.entities.enums.State;
import com.example.rentacar.repository.CarRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CarManager implements CarService {

	private CarRepository carRepository;

	private ModelMapper modelMapper;

	private ModelManager modelManager;

	@Override
	public List<CarResponse> getAll() {

		return carRepository.findAll().stream().map(item -> modelMapper.map(item, CarResponse.class)).toList();
	}

	@Override
	public CarResponse findById(int id) {

		return carRepository
				.findById(id)
				.map(item -> modelMapper.map(item, CarResponse.class))
				.orElseThrow(() -> new RuntimeException("Araba id bulunamadı"));
	}

	@Override
	public CarResponse add(AddCarRequestDto addCarRequestDto) {

		existsByPlateIgnoreCase(addCarRequestDto.getPlate());
		Car car = modelMapper.map(addCarRequestDto, Car.class);
		ModelResponse modelResponse = modelManager.getById(addCarRequestDto.getModelId());
		Model model = modelMapper.map(modelResponse, Model.class);
		car.setModel(model);
		carRepository.save(car);
		return modelMapper.map(car, CarResponse.class);
	}

	@Override
	public CarResponse update(int id, UpdateCarRequestDto updateCarRequestDto) {

		checkIfCarExistsById(id);
		Car car = modelMapper.map(updateCarRequestDto, Car.class);
		car.setId(id);
		carRepository.save(car);
		return modelMapper.map(car, CarResponse.class);
	}

	@Override
	public void delete(int id) {

		checkIfCarExistsById(id);
		carRepository.deleteById(id);
	}

	@Override
	public void changeState(int carId, State state) {

		Car car = carRepository.findById(carId).orElseThrow();
		car.setState(state);
		carRepository.save(car);
	}

	private void existsByPlateIgnoreCase(String plate) {

		if (carRepository.existsByPlateIgnoreCase(plate)) {
			throw new RuntimeException("Aynı plakadan iki farklı araç olamaz");
		}
	}

	private void checkIfCarExistsById(int id) {

		if (!carRepository.existsById(id)) {
			throw new RuntimeException("Araba id bulunamadı");
		}
	}
}
