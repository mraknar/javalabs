package com.mraknar.mapper;

import com.mraknar.dto.UserDto;
import com.mraknar.dto.UserDtoIU;
import com.mraknar.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDto toDto(User user);

    User toEntity(UserDtoIU userDtoIU);

    User toEntity(UserDto userDto);

    List<UserDto> toDto(List<User> users);

}
