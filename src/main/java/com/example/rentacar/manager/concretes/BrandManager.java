package com.example.rentacar.manager.concretes;

import com.example.rentacar.dto.request.AddBrandRequestDto;
import com.example.rentacar.dto.response.BrandResponse;
import com.example.rentacar.dto.response.GetAllBrandResponse;
import com.example.rentacar.manager.abstracts.BrandService;
import com.example.rentacar.entities.Brand;
import com.example.rentacar.repository.BrandRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BrandManager implements BrandService {

	private final BrandRepository brandRepository;

	private final ModelMapper modelMapper;

	@Override
	public List<GetAllBrandResponse> getAll() {

		List<Brand> brands = brandRepository.findAll();
		return brands.stream().map(item -> modelMapper.map(item, GetAllBrandResponse.class)).toList();
	}

	@Override
	public BrandResponse getById(int id) {

		checkIfBrandExists(id);
		Brand brand = brandRepository.findById(id).orElseThrow();
		return modelMapper.map(brand, BrandResponse.class);
	}

	@Override
	public BrandResponse add(AddBrandRequestDto addBrandRequestDto) {

		Brand brand = new Brand();
		brand.setName(addBrandRequestDto.getName());
		brandRepository.save(brand);
		return new BrandResponse(brand.getName());
	}

	@Override
	public BrandResponse update(int id, Brand brand) {

		checkIfBrandExists(id);
		brand.setId(id);
		return new BrandResponse(brand.getName());
	}

	@Override
	public void delete(int id) {

		checkIfBrandExists(id);
		brandRepository.deleteById(id);
	}

	// Business rules

	private void checkIfBrandExists(int id) {

		if (!brandRepository.existsById(id))
			throw new RuntimeException("Böyle bir marka mevcut değil.");
	}
}