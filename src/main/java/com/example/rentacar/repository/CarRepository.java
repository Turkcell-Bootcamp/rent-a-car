package com.example.rentacar.repository;

import com.example.rentacar.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Integer> {
	boolean existsByPlateIgnoreCase(String plate);
	Car findByPlate(String plate);
}
