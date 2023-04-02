package com.example.rentacar.api.controller;

import com.example.rentacar.business.abstracts.MaintenanceService;
import com.example.rentacar.dto.response.MaintenanceResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/maintenances")
public class MaintenanceController {

	private final MaintenanceService maintenanceService;

	@PostMapping("/{plate}")
	@ResponseStatus(HttpStatus.CREATED)
	public MaintenanceResponse add(@PathVariable String plate) {

		return maintenanceService.add(plate);
	}

	@DeleteMapping("/{plate}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable String plate) {

		maintenanceService.finish(plate);
	}
}
