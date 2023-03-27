package com.example.rentacar.api.controller;

import com.example.rentacar.dto.request.AddBrandRequestDto;
import com.example.rentacar.dto.response.BrandResponse;
import com.example.rentacar.dto.response.GetAllBrandResponse;
import com.example.rentacar.manager.abstracts.BrandService;
import com.example.rentacar.entities.Brand;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/brands")
public class BrandsController {
    private final BrandService service;

    @GetMapping
    public List<GetAllBrandResponse> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public BrandResponse getById(@PathVariable int id) {
        return service.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BrandResponse add(@RequestBody AddBrandRequestDto addBrandRequestDto) {
        return service.add(addBrandRequestDto);
    }

    @PutMapping("/{id}")
    public BrandResponse update(@PathVariable int id, @RequestBody Brand brand) {
        return service.update(id, brand);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        service.delete(id);
    }
}