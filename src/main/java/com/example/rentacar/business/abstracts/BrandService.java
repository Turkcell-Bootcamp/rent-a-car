package com.example.rentacar.business.abstracts;

import com.example.rentacar.dto.request.add.AddBrandRequestDto;
import com.example.rentacar.dto.request.update.UpdateBrandRequestDto;
import com.example.rentacar.dto.response.BrandResponse;

import java.util.List;

public interface BrandService {

	List<BrandResponse> getAll();

	BrandResponse getById(int id);

	BrandResponse add(AddBrandRequestDto addBrandRequestDto);

	BrandResponse update(int id, UpdateBrandRequestDto updateBrandRequestDto);

	void delete(int id);
}
