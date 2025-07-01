package com.mraknar.library.controller;

import com.mraknar.library.dto.address.AddressRequestDTO;
import com.mraknar.library.dto.address.AddressResponseDTO;
import com.mraknar.library.service.AddressService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/api/address")
public class AddressController {

    private final AddressService addressService;
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/{username}")
    public ResponseEntity<AddressResponseDTO> getAddress(@PathVariable String username){
        return ResponseEntity.ok(addressService.getAddress(username));
    }

    @PutMapping("/update/{username}")
    public ResponseEntity<AddressResponseDTO> updateAddress(@PathVariable String username, @RequestBody AddressRequestDTO dto){
        return ResponseEntity.ok(addressService.updateAddress(username, dto));
    }
}
