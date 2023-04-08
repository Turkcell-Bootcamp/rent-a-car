package com.example.rentacar.dto.response;

import lombok.*;

import java.time.LocalDateTime;

/*
    Created by Emrah on 4/8/2023
*/
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RentalResponse {

	int id;

	int carId;

	double dailyPrice;

	int rentedForDays;

	double totalPrice;

	LocalDateTime startDate;
}
