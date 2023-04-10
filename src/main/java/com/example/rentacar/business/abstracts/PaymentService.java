package com.example.rentacar.business.abstracts;

import com.example.rentacar.common.dto.CreateRentalPaymentRequest;
import com.example.rentacar.dto.request.add.AddPaymentRequestDto;
import com.example.rentacar.dto.request.update.UpdatePaymentRequestDto;
import com.example.rentacar.dto.response.PaymentResponse;

import java.util.List;

/*
 *   Created by emrah.yilm4z on 4/10/2023
 */
public interface PaymentService {

	List<PaymentResponse> getAll();

	PaymentResponse getById(int id);

	PaymentResponse add(AddPaymentRequestDto request);

	PaymentResponse update(int id, UpdatePaymentRequestDto request);

	void delete(int id);

	void processRentalPayment(CreateRentalPaymentRequest request);
}
