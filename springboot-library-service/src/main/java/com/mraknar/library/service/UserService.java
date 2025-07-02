package com.mraknar.library.service;

import com.mraknar.library.dto.user.UserRequestDTO;
import com.mraknar.library.dto.user.UserResponseDTO;

import java.util.List;

public interface UserService {

    UserResponseDTO createUser(UserRequestDTO userRequestDTO);

    List<UserResponseDTO> getUsers();

    UserResponseDTO getUserById(Long id);
}
