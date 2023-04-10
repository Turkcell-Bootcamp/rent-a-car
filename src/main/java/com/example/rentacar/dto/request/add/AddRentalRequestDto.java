package com.example.rentacar.dto.request.add;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
    Created by Emrah on 4/8/2023
*/
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddRentalRequestDto {

	int carId;

	int rentedForDays;
}
