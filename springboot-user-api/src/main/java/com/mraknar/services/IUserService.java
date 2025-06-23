package com.mraknar.services;

import com.mraknar.dto.UserDto;
import com.mraknar.dto.UserDtoIU;
import com.mraknar.entities.User;

import java.util.List;

public interface IUserService {

    public UserDto createUser(UserDtoIU user);

    public List<UserDto> getAllUsers();

    public UserDto getUserById(Integer id);

    public void deleteUserById(Integer id);

    public UserDto updateUser(Integer id, UserDtoIU updatedUser);
}
