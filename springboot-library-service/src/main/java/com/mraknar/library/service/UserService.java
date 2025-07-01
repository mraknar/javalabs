package com.mraknar.library.service;

import com.mraknar.library.dto.user.UserRequestDTO;
import com.mraknar.library.dto.user.UserResponseDTO;

import java.util.List;

public interface UserService {

    public UserResponseDTO createUser(UserRequestDTO userRequestDTO);

    public List<UserResponseDTO> getUsers();

    public UserResponseDTO getUserById(Long id);
}
