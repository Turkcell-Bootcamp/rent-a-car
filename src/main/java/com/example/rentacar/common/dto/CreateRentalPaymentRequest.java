package com.example.rentacar.common.dto;

/*
 *   Created by emrah.yilm4z on 4/10/2023
 */

import com.example.rentacar.dto.request.PaymentRequestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateRentalPaymentRequest extends PaymentRequestDto {

	private double price;
}