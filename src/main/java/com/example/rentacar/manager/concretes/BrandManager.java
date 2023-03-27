package com.example.rentacar.manager.concretes;

import com.example.rentacar.dto.response.BrandResponse;
import com.example.rentacar.dto.response.GetAllBrandResponse;
import com.example.rentacar.manager.abstracts.BrandService;
import com.example.rentacar.entities.Brand;
import com.example.rentacar.repository.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BrandManager implements BrandService {
    private final BrandRepository brandRepository;

    @Override
    public List<GetAllBrandResponse> getAll() {
        List<Brand> brands = brandRepository.findAll();
        return brands.stream().map(item -> new GetAllBrandResponse(item.getName())).toList();
    }

    @Override
    public BrandResponse getById(int id) {
        checkIfBrandExists(id);
        Brand brand = brandRepository.findById(id).orElseThrow();
        BrandResponse brandResponse = new BrandResponse(brand.getName());
        return brandResponse;
    }

    @Override
    public Brand add(Brand brand) {
        return brandRepository.save(brand);
    }

    @Override
    public Brand update(int id, Brand brand) {
        checkIfBrandExists(id);
        brand.setId(id);
        return brandRepository.save(brand);
    }

    @Override
    public void delete(int id) {
        checkIfBrandExists(id);
        brandRepository.deleteById(id);
    }

    // Business rules

    private void checkIfBrandExists(int id) {
        if (!brandRepository.existsById(id)) throw new RuntimeException("Böyle bir marka mevcut değil.");
    }
}