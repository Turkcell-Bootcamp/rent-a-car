package com.example.rentacar.dto.request.update;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCarRequestDto {

	private int modelYear;

	private String plate;

	private int state;

	private double dailyPrice;

	private int modelId;
}
