package com.example.rentacar.repository;

/*
 *   Created by emrah.yilm4z on 4/16/2023
 */

import com.example.rentacar.entities.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {

}
