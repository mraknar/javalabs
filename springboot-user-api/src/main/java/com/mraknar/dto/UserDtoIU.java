package com.mraknar.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDtoIU {

    private String firstName;

    private String lastName;

    private Date dateOfBirth;
}
