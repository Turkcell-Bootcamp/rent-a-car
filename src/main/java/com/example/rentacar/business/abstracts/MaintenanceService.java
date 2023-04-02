package com.example.rentacar.business.abstracts;

import com.example.rentacar.dto.response.MaintenanceResponse;

public interface MaintenanceService {
	MaintenanceResponse add(String plate);
	void finish(String plate);
}
