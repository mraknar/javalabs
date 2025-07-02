package com.mraknar.library.controller;

import com.mraknar.library.dto.contact.ContactRequestDTO;
import com.mraknar.library.dto.contact.ContactResponseDTO;
import com.mraknar.library.service.ContactInformationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/api/contact")
public class ContactInformationController {

    private final ContactInformationService contactInformationService;

    @Autowired
    public ContactInformationController(ContactInformationService contactInformationService) {
        this.contactInformationService = contactInformationService;
    }

    @GetMapping("/{username}")
    public ResponseEntity<ContactResponseDTO> getContactInformation(@PathVariable String username){
        return ResponseEntity.ok(contactInformationService.getContactInformation(username));
    }

    @PutMapping("/update/{username}")
    public ResponseEntity<ContactResponseDTO> updateContactInformation(@PathVariable String username, @RequestBody @Valid ContactRequestDTO dto){
        return ResponseEntity.ok(contactInformationService.updateContactInformation(username, dto));
    }
}
