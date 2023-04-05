package com.example.rentacar.api.controller;

import com.example.rentacar.business.abstracts.MaintenanceService;
import com.example.rentacar.dto.request.add.AddMaintanenceRequestDto;
import com.example.rentacar.dto.request.update.UpdateMaintenanceRequestDto;
import com.example.rentacar.dto.response.MaintenanceResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/maintenances")
public class MaintenanceController {

	private final MaintenanceService maintenanceService;

	@GetMapping
	public List<MaintenanceResponse> getAll() {
		return maintenanceService.getAll();
	}

	@GetMapping("/{id}")
	public MaintenanceResponse getById(@PathVariable int id) {
		return maintenanceService.getById(id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public MaintenanceResponse add(@RequestBody AddMaintanenceRequestDto request) {
		return maintenanceService.add(request);
	}

	@PutMapping("/return/{carId}")
	public MaintenanceResponse returnCarFromMaintenance(@PathVariable int carId) {
		return maintenanceService.returnCarFromMaintenance(carId);
	}

	@PutMapping("/{id}")
	public MaintenanceResponse update(@PathVariable int id, @RequestBody UpdateMaintenanceRequestDto request) {
		return maintenanceService.update(id, request);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable int id) {
		maintenanceService.delete(id);
	}
}
