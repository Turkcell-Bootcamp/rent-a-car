package com.example.rentacar.business.concretes;

import com.example.rentacar.dto.request.add.AddBrandRequestDto;
import com.example.rentacar.dto.request.update.UpdateBrandRequestDto;
import com.example.rentacar.dto.response.BrandResponse;
import com.example.rentacar.entities.Brand;
import com.example.rentacar.business.abstracts.BrandService;
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
	public List<BrandResponse> getAll() {

		List<Brand> brands = brandRepository.findAll();
		return brands.stream().map(item -> modelMapper.map(item, BrandResponse.class)).toList();
	}

	@Override
	public BrandResponse getById(int id) {

		checkIfBrandExistsById(id);
		Brand brand = brandRepository.findById(id).orElseThrow();
		return modelMapper.map(brand, BrandResponse.class);
	}

	@Override
	public BrandResponse add(AddBrandRequestDto addBrandRequestDto) {

		checkIfBrandNameExists(addBrandRequestDto.getName());
		Brand brand = modelMapper.map(addBrandRequestDto, Brand.class);
		brandRepository.save(brand);
		return new BrandResponse(brand.getName());
	}

	@Override
	public BrandResponse update(int id, UpdateBrandRequestDto updateBrandRequestDto) {

		checkIfBrandExistsById(id);
		Brand brand = modelMapper.map(updateBrandRequestDto, Brand.class);
		brand.setId(id);
		brandRepository.save(brand);
		return modelMapper.map(brand, BrandResponse.class);
	}

	@Override
	public void delete(int id) {

		checkIfBrandExistsById(id);
		brandRepository.deleteById(id);
	}

	private void checkIfBrandExistsById(int id) {

		if (!brandRepository.existsById(id))
			throw new RuntimeException("Böyle bir marka id mevcut değil.");
	}

	private void checkIfBrandNameExists(String brandName) {

		if (brandRepository.existsByNameIgnoreCase(brandName))
			throw new RuntimeException("Böyle bir marka ismi mevcut.");
	}
}