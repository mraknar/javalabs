package com.mraknar.library.mapper;

import com.mraknar.library.dto.contact.ContactRequestDTO;
import com.mraknar.library.dto.contact.ContactResponseDTO;
import com.mraknar.library.entity.ContactInformation;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ContactInformationMapper {

    ContactInformation toEntity(ContactRequestDTO contactRequestDTODTO);

    ContactResponseDTO toDto(ContactInformation contactInformation);

}
