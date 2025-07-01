package com.mraknar.library.service.impl;

import com.mraknar.library.dto.address.AddressRequestDTO;
import com.mraknar.library.dto.address.AddressResponseDTO;
import com.mraknar.library.entity.Address;
import com.mraknar.library.entity.User;
import com.mraknar.library.exception.AddressNotFoundException;
import com.mraknar.library.exception.UserNotFoundException;
import com.mraknar.library.mapper.AddressMapper;
import com.mraknar.library.repository.AddressRepository;
import com.mraknar.library.repository.UserRepository;
import com.mraknar.library.service.AddressService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    private final UserRepository userRepository;
    private final AddressMapper addressMapper;

    public AddressServiceImpl(AddressRepository addressRepository,  UserRepository userRepository,  AddressMapper addressMapper) {
        this.addressRepository = addressRepository;
        this.userRepository = userRepository;
        this.addressMapper = addressMapper;
    }

    @Override
    public AddressResponseDTO getAddress(String username){
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException(username));

        Address address = user.getAddress();
        if (address == null){
            throw new AddressNotFoundException();
        }

        return addressMapper.toDto(address);
    }

    @Override
    public AddressResponseDTO updateAddress(String username, AddressRequestDTO dto){
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException(username));

        Address address = user.getAddress();
        if (address == null){
            throw new AddressNotFoundException();
        }

        address.setStreet(dto.getStreet());
        address.setCity(dto.getCity());
        address.setDistrict(dto.getDistrict());
        address.setZipcode(dto.getZipcode());
        address.setCountry(dto.getCountry());

        addressRepository.save(address);
        return addressMapper.toDto(address);
    }
}
