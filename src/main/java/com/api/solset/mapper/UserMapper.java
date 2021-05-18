package com.api.solset.mapper;

import com.api.solset.dto.UserRequestDTO;
import com.api.solset.dto.UserResponseDTO;
import com.api.solset.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class UserMapper {
    public static final UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    public abstract User toUser(UserRequestDTO userRequestDTO);
    public abstract UserResponseDTO toUserResponseDTO(User user);
}
