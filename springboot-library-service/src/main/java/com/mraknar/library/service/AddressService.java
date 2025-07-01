package com.mraknar.library.service;

import com.mraknar.library.dto.address.AddressRequestDTO;
import com.mraknar.library.dto.address.AddressResponseDTO;
import org.springframework.web.bind.annotation.PathVariable;

public interface AddressService {

    public AddressResponseDTO getAddress(String username);

    public AddressResponseDTO updateAddress(String username, AddressRequestDTO dto);
}
