package com.example.rentacar.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/*
    Created by Emrah on 4/8/2023
*/
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "rental")
public class Rental {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	int carId;

	double dailyPrice;

	int rentedForDays;

	double totalPrice;

	LocalDateTime startDate;
}
