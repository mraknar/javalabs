package com.mraknar.library.service;

import com.mraknar.library.dto.contact.ContactRequestDTO;
import com.mraknar.library.dto.contact.ContactResponseDTO;

public interface ContactInformationService {

    ContactResponseDTO getContactInformation(String username);

    ContactResponseDTO updateContactInformation(String username, ContactRequestDTO dto);
}
