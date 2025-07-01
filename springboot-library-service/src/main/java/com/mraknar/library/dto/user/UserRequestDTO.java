package com.mraknar.library.dto.user;

import com.mraknar.library.dto.address.AddressRequestDTO;
import com.mraknar.library.dto.contact.ContactRequestDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDTO {

    private String username;

    private String password;

    private String email;

    private AddressRequestDTO address;

    private ContactRequestDTO contactInformation;

}
