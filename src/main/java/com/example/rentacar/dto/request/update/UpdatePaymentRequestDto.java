package com.example.rentacar.dto.request.update;

/*
 *   Created by emrah.yilm4z on 4/10/2023
 */

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UpdatePaymentRequestDto {
	@NotNull
	@Min(value = 1)
	private double balance;
}
