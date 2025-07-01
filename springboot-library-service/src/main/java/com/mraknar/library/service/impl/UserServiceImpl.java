package com.mraknar.library.service.impl;

import com.mraknar.library.dto.user.UserRequestDTO;
import com.mraknar.library.dto.user.UserResponseDTO;
import com.mraknar.library.entity.User;
import com.mraknar.library.exception.UserNotFoundException;
import com.mraknar.library.mapper.UserMapper;
import com.mraknar.library.repository.UserRepository;
import com.mraknar.library.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository,  UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserResponseDTO createUser(UserRequestDTO userRequestDTO){
        User user = userMapper.toEntity(userRequestDTO);
        userRepository.save(user);

        return userMapper.toDto(user);
    }

    @Override
    public List<UserResponseDTO> getUsers(){

        return userMapper.toDto(userRepository.findAll());

    }

    @Override
    public UserResponseDTO getUserById(Long id){
        User user = userRepository.findById(id)
                .orElseThrow(()-> new UserNotFoundException(id));
        return userMapper.toDto(user);
    }
}
