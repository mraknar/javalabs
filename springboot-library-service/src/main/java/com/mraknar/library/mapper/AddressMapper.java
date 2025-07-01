package com.mraknar.library.mapper;

import com.mraknar.library.dto.address.AddressRequestDTO;
import com.mraknar.library.dto.address.AddressResponseDTO;
import com.mraknar.library.entity.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    Address toEntity(AddressRequestDTO addressRequestDTO);

    AddressResponseDTO toDto(Address address);
}
