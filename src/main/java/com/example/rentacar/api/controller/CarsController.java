package com.example.rentacar.api.controller;

import com.example.rentacar.business.abstracts.CarService;
import com.example.rentacar.dto.request.add.AddCarRequestDto;
import com.example.rentacar.dto.request.update.UpdateCarRequestDto;
import com.example.rentacar.dto.response.CarResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/cars")
public class CarsController {

	private final CarService carService;

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<CarResponse> getAll() {

		return carService.getAll();
	}

	@GetMapping("/{id}")
	public CarResponse getById(@PathVariable int id) {

		return carService.getById(id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public CarResponse add(@RequestBody AddCarRequestDto addCarRequestDto) {

		return carService.add(addCarRequestDto);
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public CarResponse update(@PathVariable int id, @RequestBody UpdateCarRequestDto updateCarRequestDto) {

		return carService.update(id, updateCarRequestDto);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable int id) {

		carService.delete(id);
	}
}
