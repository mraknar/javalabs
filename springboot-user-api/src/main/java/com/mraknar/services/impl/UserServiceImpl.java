package com.mraknar.services.impl;

import com.mraknar.dto.UserDto;
import com.mraknar.dto.UserDtoIU;
import com.mraknar.entities.User;
import com.mraknar.mapper.UserMapper;
import com.mraknar.repository.UserRepository;
import com.mraknar.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements IUserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,  UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserDto createUser(UserDtoIU userDtoIU) {
        User user = userMapper.toEntity(userDtoIU);
        User savedUser = userRepository.save(user);
        return  userMapper.toDto(savedUser);
    }

    @Override
    public List<UserDto> createUsers(List<UserDtoIU> users){
        return users.stream()
                .map(this::createUser)
                .collect(Collectors.toList());
    }

    @Override
    public List<UserDto> getAllUsers(){
        return userMapper.toDto(userRepository.findAll());
    }

    @Override
    public UserDto getUserById(Integer id){
        Optional<User> optional = userRepository.findById(id);
        return optional.map(userMapper::toDto).orElse(null);
    }

    @Override
    public void deleteUserById(Integer id) {
        UserDto user = getUserById(id);
        if(user != null){
            userRepository.deleteById(id);
        }
    }

    @Override
    public UserDto updateUser(Integer id, UserDtoIU updatedUser){
        User userDb = userRepository.findById(id).orElse(null);

        if(userDb != null){
            userDb.setFirstName(updatedUser.getFirstName());
            userDb.setLastName(updatedUser.getLastName());
            userDb.setDateOfBirth(updatedUser.getDateOfBirth());
            return userMapper.toDto(userRepository.save(userDb));
        }
        return null;
    }

}
