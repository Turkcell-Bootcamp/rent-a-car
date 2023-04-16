package com.example.rentacar.api.controller;

/*
 *   Created by emrah.yilm4z on 4/16/2023
 */

import com.example.rentacar.business.abstracts.InvoiceService;
import com.example.rentacar.dto.request.add.AddInvoiceRequest;
import com.example.rentacar.dto.request.update.UpdateInvoiceRequest;
import com.example.rentacar.dto.response.InvoiceResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/invoices")
public class InvoicesController {

	private final InvoiceService service;

	@GetMapping
	public List<InvoiceResponse> getAll() {

		return service.getAll();
	}

	@GetMapping("/{id}")
	public InvoiceResponse getById(@PathVariable int id) {

		return service.getById(id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public InvoiceResponse add(@RequestBody AddInvoiceRequest request) {

		return service.add(request);
	}

	@PutMapping("/{id}")
	public InvoiceResponse update(@PathVariable int id, @RequestBody UpdateInvoiceRequest request) {

		return service.update(id, request);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable int id) {

		service.delete(id);
	}
}
