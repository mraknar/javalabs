package com.mraknar.library.dto.address;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddressRequestDTO {

    private String street;

    private String city;

    private String district;

    private String country;

    private String zipcode;
}
