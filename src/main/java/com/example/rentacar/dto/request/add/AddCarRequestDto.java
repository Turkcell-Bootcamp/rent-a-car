package com.example.rentacar.dto.request.add;

import com.example.rentacar.entities.enums.State;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddCarRequestDto {

	private int modelYear;

	private String plate;

	private State state;

	private double dailyPrice;

	private int modelId;

}
