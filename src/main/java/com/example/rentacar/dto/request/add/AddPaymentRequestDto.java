package com.example.rentacar.dto.request.add;
/*
 *   Created by emrah.yilm4z on 4/10/2023
 */

import com.example.rentacar.dto.request.PaymentRequestDto;
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
public class AddPaymentRequestDto extends PaymentRequestDto {

	@NotNull
	@Min(value = 1)
	private double balance;
}
