package com.example.rentacar.business.concretes;

import com.example.rentacar.business.abstracts.PaymentService;
import com.example.rentacar.business.abstracts.PosService;
import com.example.rentacar.common.dto.CreateRentalPaymentRequest;
import com.example.rentacar.dto.request.add.AddPaymentRequestDto;
import com.example.rentacar.dto.request.update.UpdatePaymentRequestDto;
import com.example.rentacar.dto.response.PaymentResponse;
import com.example.rentacar.entities.Payment;
import com.example.rentacar.repository.PaymentRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 *   Created by emrah.yilm4z on 4/10/2023
 */

@Service
@AllArgsConstructor
public class PaymentManager implements PaymentService {

	private final PaymentRepository repository;

	private final ModelMapper mapper;

	private final PosService posService;

	@Override
	public List<PaymentResponse> getAll() {

		List<Payment> payments = repository.findAll();

		return payments.stream().map(payment -> mapper.map(payment, PaymentResponse.class)).toList();
	}

	@Override
	public PaymentResponse getById(int id) {

		checkIfPaymentExists(id);
		Payment payment = repository.findById(id).orElseThrow();

		return mapper.map(payment, PaymentResponse.class);
	}

	@Override
	public PaymentResponse add(AddPaymentRequestDto request) {

		checkIfCardExists(request.getCardNumber());
		Payment payment = mapper.map(request, Payment.class);
		payment.setId(0);
		repository.save(payment);

		return mapper.map(payment, PaymentResponse.class);
	}

	@Override
	public PaymentResponse update(int id, UpdatePaymentRequestDto request) {

		checkIfPaymentExists(id);
		Payment payment = mapper.map(request, Payment.class);
		payment.setId(id);
		repository.save(payment);

		return mapper.map(payment, PaymentResponse.class);
	}

	@Override
	public void delete(int id) {

		checkIfPaymentExists(id);
		repository.deleteById(id);
	}

	@Override
	public void processRentalPayment(CreateRentalPaymentRequest request) {

		checkIfPaymentIsValid(request);
		Payment payment = repository.findByCardNumber(request.getCardNumber());
		checkIfBalanceIdEnough(payment.getBalance(), request.getPrice());
		posService.pay(); // fake pos service
		payment.setBalance(payment.getBalance() - request.getPrice());
		repository.save(payment);
	}

	private void checkIfPaymentExists(int id) {

		if (!repository.existsById(id)) {
			throw new RuntimeException("Ödeme bilgisi bulunamadı.");
		}
	}

	private void checkIfBalanceIdEnough(double balance, double price) {

		if (balance < price) {
			throw new RuntimeException("Yetersiz bakiye.");
		}
	}

	private void checkIfCardExists(String cardNumber) {

		if (repository.existsByCardNumber(cardNumber)) {
			throw new RuntimeException("Kart numarası zaten kayıtlı.");
		}
	}

	private void checkIfPaymentIsValid(CreateRentalPaymentRequest request) {

		if (!repository.existsByCardNumberAndCardHolderAndCardExpirationYearAndCardExpirationMonthAndCardCvv(request.getCardNumber(),
																											 request.getCardHolder(),
																											 request.getCardExpirationYear(),
																											 request.getCardExpirationMonth(),
																											 request.getCardCvv())) {
			throw new RuntimeException("Kart bilgileriniz hatalı.");
		}
	}
}
