package com.example.sklepinternetowysysweb.service;

import com.example.sklepinternetowysysweb.data.model.Address;
import com.example.sklepinternetowysysweb.persistance.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
public class AddressService {

    private final AddressRepository addressRepository;

    public void save(Address address) {
        addressRepository.save(address);
    }

}
