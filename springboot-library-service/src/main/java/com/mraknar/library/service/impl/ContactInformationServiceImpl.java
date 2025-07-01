package com.mraknar.library.service.impl;

import com.mraknar.library.dto.contact.ContactRequestDTO;
import com.mraknar.library.dto.contact.ContactResponseDTO;
import com.mraknar.library.entity.ContactInformation;
import com.mraknar.library.entity.User;
import com.mraknar.library.exception.ContactInformationNotFoundException;
import com.mraknar.library.exception.UserNotFoundException;
import com.mraknar.library.mapper.ContactInformationMapper;
import com.mraknar.library.repository.ContactInformationRepository;
import com.mraknar.library.repository.UserRepository;
import com.mraknar.library.service.ContactInformationService;
import org.springframework.stereotype.Service;

@Service
public class ContactInformationServiceImpl implements ContactInformationService {

    private final ContactInformationRepository contactInformationRepository;
    private final UserRepository userRepository;
    private final ContactInformationMapper contactInformationMapper;

    public ContactInformationServiceImpl(ContactInformationRepository contactInformationRepository,  UserRepository userRepository,  ContactInformationMapper contactInformationMapper) {
        this.contactInformationRepository = contactInformationRepository;
        this.userRepository = userRepository;
        this.contactInformationMapper = contactInformationMapper;
    }

    @Override
    public ContactResponseDTO getContactInformation(String username){
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException(username));

        ContactInformation contactInformation = user.getContactInformation();
        if (contactInformation == null) {
            throw new ContactInformationNotFoundException();
        }

        return contactInformationMapper.toDto(contactInformation);
    }

    @Override
    public ContactResponseDTO updateContactInformation(String username,  ContactRequestDTO dto){
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException(username));

        ContactInformation contactInformation = user.getContactInformation();
        if (contactInformation == null) {
            throw new ContactInformationNotFoundException();
        }

        contactInformation.setPhoneNumber( dto.getPhoneNumber() );
        contactInformation.setSecondaryEmail( dto.getSecondaryEmail() );

        contactInformationRepository.save(contactInformation);
        return contactInformationMapper.toDto(contactInformation);
    }
}
