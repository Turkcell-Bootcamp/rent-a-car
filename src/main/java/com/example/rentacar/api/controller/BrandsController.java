package com.example.rentacar.api.controller;

import com.example.rentacar.business.abstracts.BrandService;
import com.example.rentacar.dto.request.add.AddBrandRequestDto;
import com.example.rentacar.dto.request.update.UpdateBrandRequestDto;
import com.example.rentacar.dto.response.BrandResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/brands")
public class BrandsController {

	private final BrandService brandService;

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<BrandResponse> getAll() {

		return brandService.getAll();
	}

	@GetMapping("/{id}")
	public BrandResponse getById(@PathVariable int id) {

		return brandService.getById(id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public BrandResponse add(@RequestBody AddBrandRequestDto addBrandRequestDto) {

		return brandService.add(addBrandRequestDto);
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public BrandResponse update(@PathVariable int id, @RequestBody UpdateBrandRequestDto updateBrandRequestDto) {

		return brandService.update(id, updateBrandRequestDto);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable int id) {

		brandService.delete(id);
	}
}