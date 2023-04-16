package com.example.rentacar.business.abstracts;

/*
 *   Created by emrah.yilm4z on 4/16/2023
 */

import com.example.rentacar.dto.request.add.AddInvoiceRequest;
import com.example.rentacar.dto.request.update.UpdateInvoiceRequest;
import com.example.rentacar.dto.response.InvoiceResponse;

import java.util.List;

public interface InvoiceService {

	List<InvoiceResponse> getAll();

	InvoiceResponse getById(int id);

	InvoiceResponse add(AddInvoiceRequest request);

	InvoiceResponse update(int id, UpdateInvoiceRequest request);

	void delete(int id);
}
