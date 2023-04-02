package com.example.rentacar.business.abstracts;

import com.example.rentacar.dto.request.add.AddModelRequestDto;
import com.example.rentacar.dto.request.update.UpdateModelRequestDto;
import com.example.rentacar.dto.response.ModelResponse;

import java.util.List;

public interface ModelService {

	List<ModelResponse> getAll();

	ModelResponse getById(int id);

	ModelResponse add(AddModelRequestDto addModelRequestDto);

	ModelResponse update(int id, UpdateModelRequestDto UpdateModelRequestDto);

	void delete(int id);
}
