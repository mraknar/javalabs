package com.mraknar.library.dto.user;

import com.mraknar.library.dto.address.AddressRequestDTO;
import com.mraknar.library.dto.contact.ContactRequestDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
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
public class UserRequestDTO {

    @NotBlank(message = "username can't be empty")
    @Size(min = 3, max = 20, message = "Username length must be between 3-20")
    private String username;

    @NotBlank(message = "password can't be empty")
    @Size(min = 6, max = 20, message = "Password length must be between 6-20")
    private String password;

    @Email(message = "Enter a valid email address")
    private String email;

    @Valid
    private AddressRequestDTO address;

    @Valid
    private ContactRequestDTO contactInformation;

}
