package com.example.rentacar.dto.request;
/*
 *   Created by emrah.yilm4z on 4/10/2023
 */

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentRequestDto {

	@NotBlank(message = "Kart numarası boş bırakılamaz.")
	private String cardNumber;

	@NotBlank
	private String cardHolder;

	@NotNull
	private int cardExpirationYear;

	@NotNull
	@Max(value = 12)
	@Min(value = 1)
	private int cardExpirationMonth;

	@NotBlank
	private String cardCvv;
}
