package com.mraknar.library.mapper;

import com.mraknar.library.dto.user.UserRequestDTO;
import com.mraknar.library.dto.user.UserResponseDTO;
import com.mraknar.library.entity.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = { AddressMapper.class, ContactInformationMapper.class })
public interface UserMapper {

    UserResponseDTO toDto(User user);

    List<UserResponseDTO> toDto(List<User> user);

    User toEntity(UserRequestDTO userRequestDTO);

}
