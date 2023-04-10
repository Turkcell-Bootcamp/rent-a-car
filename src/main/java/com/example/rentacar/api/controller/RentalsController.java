package com.example.rentacar.api.controller;

/*
    Created by Emrah on 4/8/2023
*/

import com.example.rentacar.business.abstracts.RentalService;
import com.example.rentacar.dto.request.add.AddRentalRequestDto;
import com.example.rentacar.dto.response.RentalResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/rentals")
public class RentalsController {

	private final RentalService rentalService;

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<RentalResponse> getAll() {

		return rentalService.getAll();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public RentalResponse add(@RequestBody AddRentalRequestDto addRentalRequestDto) {

		return rentalService.add(addRentalRequestDto);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable int id) {

		rentalService.delete(id);
	}
}
