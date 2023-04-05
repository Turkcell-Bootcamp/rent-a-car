package com.example.rentacar.business.abstracts;

import com.example.rentacar.dto.request.add.AddMaintanenceRequestDto;
import com.example.rentacar.dto.request.update.UpdateMaintenanceRequestDto;
import com.example.rentacar.dto.response.MaintenanceResponse;

import java.util.List;

public interface MaintenanceService {

	MaintenanceResponse add(AddMaintanenceRequestDto request);

	MaintenanceResponse returnCarFromMaintenance(int carId);

	List<MaintenanceResponse> getAll();

	MaintenanceResponse getById(int id);

	MaintenanceResponse update(int id, UpdateMaintenanceRequestDto request);

	void delete(int id);
}
