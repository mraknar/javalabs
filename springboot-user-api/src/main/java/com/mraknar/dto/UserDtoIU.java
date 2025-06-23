package com.mraknar.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDtoIU {

    @NotEmpty(message = "First name field can't be empty")
    @Max(value = 50)
    @Min(value = 3)
    private String firstName;

    @NotEmpty(message = "Last name field can't be empty")
    @Max(value = 50)
    @Min(value = 3)
    private String lastName;

    private Date dateOfBirth;

    @Email
    private String email;

    private String password;
}
