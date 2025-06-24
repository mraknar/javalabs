package com.mraknar.controller;

import com.mraknar.dto.user.UserDto;
import com.mraknar.dto.user.UserDtoIU;
import jakarta.validation.Valid;

import java.util.List;

public interface IUserController {
    public UserDto createUser(@Valid UserDtoIU user);

    public List<UserDto> createUsers(List<@Valid UserDtoIU> users);

    public List<UserDto> getAllUsers();

    public UserDto getUserById(Integer id);

    public void deleteUserById(Integer id);

    public UserDto updateUser(Integer id, UserDtoIU updatedUser);
}
