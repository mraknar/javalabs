package com.mraknar.library.dto.contact;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContactRequestDTO {

    @NotBlank(message = "Phone Number can't be empty")
    @Size(min = 10, max = 10, message = "Phone number length must be 10")
    private String phoneNumber;

    @Email(message = "Enter a valid email address")
    private String secondaryEmail;
}
