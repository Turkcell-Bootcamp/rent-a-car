package com.example.rentacar.business.abstracts;

import com.example.rentacar.dto.request.add.RentalRequest;
import com.example.rentacar.dto.response.RentalResponse;

import java.util.List;

/*
    Created by Emrah on 4/8/2023
*/
public interface RentalService {

	RentalResponse add(RentalRequest renatalRequest);
	List<RentalResponse> getAll();
	void delete(int id);
}
