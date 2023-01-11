package com.example.sklepinternetowysysweb.persistance;

import com.example.sklepinternetowysysweb.data.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}