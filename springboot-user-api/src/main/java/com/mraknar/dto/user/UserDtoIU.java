package com.mraknar.dto.user;

import jakarta.validation.constraints.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDtoIU {

    @NotEmpty(message = "First name field can't be empty")
    @Size(min = 3, max = 50, message = "First name must be between 3 and 50 characters")
    private String firstName;

    @NotEmpty(message = "Last name field can't be empty")
    @Size(min = 3, max = 50, message = "Last name must be between 3 and 50 characters")
    private String lastName;

    private Date dateOfBirth;

    @Email(message = "Enter a valid email address")
    private String email;

    private String password;
}
