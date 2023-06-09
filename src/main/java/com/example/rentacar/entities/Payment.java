package com.example.rentacar.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
    Created by Emrah on 4/10/2023
*/
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "payments")
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String cardNumber;

	private String cardHolder;

	private int cardExpirationYear;

	private int cardExpirationMonth;

	private String cardCvv;

	private double balance;
}