package com.mraknar.services;

import com.mraknar.dto.user.UserDto;
import com.mraknar.dto.user.UserDtoIU;

import java.util.List;

public interface IUserService {

    public UserDto createUser(UserDtoIU user);

    public List<UserDto> createUsers(List<UserDtoIU> users);

    public List<UserDto> getAllUsers();

    public UserDto getUserById(Integer id);

    public void deleteUserById(Integer id);

    public UserDto updateUser(Integer id, UserDtoIU updatedUser);
}
