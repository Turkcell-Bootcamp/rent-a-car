package com.example.rentacar.business.abstracts;

import com.example.rentacar.dto.request.add.AddCarRequestDto;
import com.example.rentacar.dto.request.update.UpdateCarRequestDto;
import com.example.rentacar.dto.response.CarResponse;

import java.util.List;

public interface CarService {

	List<CarResponse> getAll();

	CarResponse getById(int id);

	CarResponse add(AddCarRequestDto addCarRequestDto);

	CarResponse update(int id, UpdateCarRequestDto updateCarRequestDto);

	void delete(int id);
}
