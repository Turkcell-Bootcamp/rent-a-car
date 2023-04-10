package com.example.rentacar.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
 *   Created by emrah.yilm4z on 4/10/2023
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentResponse {

	private int id;

	private String cardNumber;

	private String cardHolder;

	private int cardExpirationYear;

	private int cardExpirationMonth;

	private String cardCvv;

	private double balance;
}
