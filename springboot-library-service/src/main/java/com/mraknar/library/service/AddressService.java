package com.mraknar.library.service;

import com.mraknar.library.dto.address.AddressRequestDTO;
import com.mraknar.library.dto.address.AddressResponseDTO;

public interface AddressService {

    AddressResponseDTO getAddress(String username);

    AddressResponseDTO updateAddress(String username, AddressRequestDTO dto);
}
