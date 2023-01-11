package com.example.sklepinternetowysysweb.service;

import com.example.sklepinternetowysysweb.data.model.Supplier;
import com.example.sklepinternetowysysweb.persistance.SupplierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Transactional
public class SupplierService {

    private final SupplierRepository supplierRepository;

    public void save(Supplier supplier) {
        supplierRepository.save(supplier);
    }

    public List<Supplier> getAll(){return supplierRepository.findAll();}

}
