package com.mraknar.library.service;

import com.mraknar.library.dto.contact.ContactRequestDTO;
import com.mraknar.library.dto.contact.ContactResponseDTO;

public interface ContactInformationService {

    public ContactResponseDTO getContactInformation(String username);

    public ContactResponseDTO updateContactInformation(String username, ContactRequestDTO dto);
}
