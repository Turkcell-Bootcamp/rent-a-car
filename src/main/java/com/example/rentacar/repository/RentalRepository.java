package com.example.rentacar.repository;

import com.example.rentacar.entities.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

/*
    Created by Emrah on 4/8/2023
*/
public interface RentalRepository extends JpaRepository<Rental, Integer> {

}
