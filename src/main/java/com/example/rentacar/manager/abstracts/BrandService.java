package com.example.rentacar.manager.abstracts;

import com.example.rentacar.dto.response.BrandResponse;
import com.example.rentacar.dto.response.GetAllBrandResponse;
import com.example.rentacar.entities.Brand;

import java.util.List;

public interface BrandService {
    List<GetAllBrandResponse> getAll();
    BrandResponse getById(int id);
    Brand add(Brand brand);
    Brand update(int id, Brand brand);
    void delete(int id);
}
