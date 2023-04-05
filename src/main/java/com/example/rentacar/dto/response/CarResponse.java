package com.example.rentacar.dto.response;

import com.example.rentacar.entities.enums.State;
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

	private State state;

	private String plate;

	private double dailyPrice;

}
