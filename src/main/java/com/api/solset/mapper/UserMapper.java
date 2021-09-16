package com.api.solset.mapper;

import com.api.solset.dto.UserRequestDTO;
import com.api.solset.dto.UserResponseDTO;
import com.api.solset.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class UserMapper {
    public static final UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    public User toUser(UserRequestDTO userRequestDTO){
        return User.builder()
                .cpf(userRequestDTO.getCpf())
                .email(userRequestDTO.getEmail())
                .firstPhoneNumber(userRequestDTO.getFirstPhoneNumber())
                .secondPhoneNumber(userRequestDTO.getSecondPhoneNumber())
                .id(userRequestDTO.getId())
                .name(userRequestDTO.getName())
                .password(userRequestDTO.getPassword())
                .requestToken(userRequestDTO.getRequestToken())
                .userType(userRequestDTO.getUserType())
                .masterName(userRequestDTO.getMasterName())
                .build();
    }
    public UserResponseDTO toUserResponseDTO(User user){
        return UserResponseDTO.builder()
                .cpf(user.getCpf())
                .email(user.getEmail())
                .firstPhoneNumber(user.getFirstPhoneNumber())
                .secondPhoneNumber(user.getSecondPhoneNumber())
                .id(user.getId())
                .name(user.getName())
                .password(user.getPassword())
                .requestToken(user.getRequestToken())
                .userType(user.getUserType())
                .masterName(user.getMasterName())
                .build();
    }
}
