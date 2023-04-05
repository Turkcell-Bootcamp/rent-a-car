package com.example.rentacar.dto.request.update;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateMaintenanceRequestDto {

	private int carId;

	private String information;

	private boolean isCompleted;

	private LocalDateTime startDate;

	private LocalDateTime endDate;
}
