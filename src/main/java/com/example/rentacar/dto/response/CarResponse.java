package com.example.rentacar.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CarResponse {

	private String modelName;

	private int modelYear;

	private int state;

	private String plate;

	private double dailyPrice;

}
