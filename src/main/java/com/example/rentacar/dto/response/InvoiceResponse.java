package com.example.rentacar.dto.response;

/*
 *   Created by emrah.yilm4z on 4/16/2023
 */

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class InvoiceResponse {

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
