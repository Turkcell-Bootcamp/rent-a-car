package com.example.rentacar.dto.request.add;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddMaintanenceRequestDto {

	private int carId;

	String information;
}
