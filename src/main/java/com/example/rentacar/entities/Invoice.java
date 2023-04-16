package com.example.rentacar.entities;

/*
 *   Created by emrah.yilm4z on 4/16/2023
 */

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "invoices")
public class Invoice {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String cardHolder;

	private String modelName;

	private String brandName;

	private String plate;

	private int modelYear;

	private double dailyPrice;

	private double totalPrice;

	private int rentedForDays;

	private LocalDateTime rentedAt;
}
