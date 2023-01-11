package com.example.sklepinternetowysysweb.persistance;

import com.example.sklepinternetowysysweb.data.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SupplierRepository extends JpaRepository<Supplier, Integer> {

    List<Supplier> findAll();
}