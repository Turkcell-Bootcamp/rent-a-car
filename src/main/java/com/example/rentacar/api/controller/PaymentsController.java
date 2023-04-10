package com.example.rentacar.api.controller;

/*
 *   Created by emrah.yilm4z on 4/10/2023
 */

import com.example.rentacar.business.abstracts.PaymentService;
import com.example.rentacar.dto.request.add.AddPaymentRequestDto;
import com.example.rentacar.dto.request.update.UpdatePaymentRequestDto;
import com.example.rentacar.dto.response.PaymentResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/payments")
public class PaymentsController {
	private final PaymentService paymentService;

	@GetMapping
	public List<PaymentResponse> getAll() {
		return paymentService.getAll();
	}

	@GetMapping("/{id}")
	public PaymentResponse getById(@PathVariable int id) {
		return paymentService.getById(id);
	}

	@PostMapping
	public PaymentResponse add(@Valid @RequestBody AddPaymentRequestDto request) {
		return paymentService.add(request);
	}

	@PutMapping("/{id}")
	public PaymentResponse update(@PathVariable int id, @Valid @RequestBody UpdatePaymentRequestDto request) {
		return paymentService.update(id, request);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		paymentService.delete(id);
	}
}
