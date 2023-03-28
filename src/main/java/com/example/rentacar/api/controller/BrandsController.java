package com.example.rentacar.api.controller;

import com.example.rentacar.dto.request.AddBrandRequestDto;
import com.example.rentacar.dto.response.BrandResponse;
import com.example.rentacar.dto.response.GetAllBrandResponse;
import com.example.rentacar.manager.abstracts.BrandService;
import com.example.rentacar.entities.Brand;
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
	public List<GetAllBrandResponse> getAll() {

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
	public BrandResponse update(@PathVariable int id, @RequestBody Brand brand) {

		return brandService.update(id, brand);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable int id) {

		brandService.delete(id);
	}
}