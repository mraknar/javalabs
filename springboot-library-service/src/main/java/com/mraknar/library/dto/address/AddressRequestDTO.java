package com.mraknar.library.dto.address;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddressRequestDTO {

    @NotBlank(message = "Street can't be empty")
    @Size(min = 3, max = 20, message = "Street length must be between 3-20")
    private String street;

    @NotBlank(message = "City can't be empty")
    @Size(min = 3, max = 20, message = "City length must be between 3-20")
    private String city;

    @NotBlank(message = "District can't be empty")
    @Size(min = 3, max = 20, message = "District length must be between 3-20")
    private String district;

    @NotBlank(message = "Country can't be empty")
    @Size(min = 3, max = 20, message = "Country length must be between 3-20")
    private String country;

    @Size(max = 10, message = "Zipcod length must be maximum 10")
    private String zipcode;
}
