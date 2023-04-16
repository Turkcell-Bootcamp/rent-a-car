package com.example.rentacar.business.concretes;

/*
 *   Created by emrah.yilm4z on 4/16/2023
 */

import com.example.rentacar.business.abstracts.InvoiceService;
import com.example.rentacar.business.rules.InvoiceBusinessRules;
import com.example.rentacar.dto.request.add.AddInvoiceRequest;
import com.example.rentacar.dto.request.update.UpdateInvoiceRequest;
import com.example.rentacar.dto.response.InvoiceResponse;
import com.example.rentacar.entities.Invoice;
import com.example.rentacar.repository.InvoiceRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class InvoiceManager implements InvoiceService {

	private final InvoiceRepository repository;

	private final ModelMapper mapper;

	private final InvoiceBusinessRules rules;

	@Override
	public List<InvoiceResponse> getAll() {

		List<Invoice> invoices = repository.findAll();
		return invoices.stream().map(invoice -> mapper.map(invoice, InvoiceResponse.class)).toList();
	}

	@Override
	public InvoiceResponse getById(int id) {

		rules.checkIfInvoiceExists(id);
		Invoice invoice = repository.findById(id).orElseThrow();
		return mapper.map(invoice, InvoiceResponse.class);
	}

	@Override
	public InvoiceResponse add(AddInvoiceRequest request) {

		Invoice invoice = mapper.map(request, Invoice.class);
		invoice.setId(0);
		invoice.setTotalPrice(getTotalPrice(invoice));
		repository.save(invoice);

		return mapper.map(invoice, InvoiceResponse.class);
	}

	@Override
	public InvoiceResponse update(int id, UpdateInvoiceRequest request) {

		rules.checkIfInvoiceExists(id);
		Invoice invoice = mapper.map(request, Invoice.class);
		invoice.setId(id);
		invoice.setTotalPrice(getTotalPrice(invoice));
		repository.save(invoice);

		return mapper.map(invoice, InvoiceResponse.class);
	}

	@Override
	public void delete(int id) {

		rules.checkIfInvoiceExists(id);
		repository.deleteById(id);
	}

	private double getTotalPrice(Invoice invoice) {

		return invoice.getDailyPrice() * invoice.getRentedForDays();
	}
}
