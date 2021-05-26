package com.api.solset.mapper;

import com.api.solset.dto.ClientRequestDTO;
import com.api.solset.dto.ClientResponseDTO;
import com.api.solset.model.Client;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class ClientMapper {
    public static final ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);
    public Client toClient(ClientRequestDTO clientRequestDTO){
        return Client.builder()
                .cnpj(clientRequestDTO.getCnpj())
                .cpf(clientRequestDTO.getCpf())
                .email(clientRequestDTO.getEmail())
                .firstPhoneNumber(clientRequestDTO.getFirstPhoneNumber())
                .secondPhoneNumber(clientRequestDTO.getSecondPhoneNumber())
                .id(clientRequestDTO.getId())
                .name(clientRequestDTO.getName())
                .personType(clientRequestDTO.getPersonType())
                .requestToken(clientRequestDTO.getRequestToken())
                .build();
    }
    public ClientResponseDTO toClientResponseDTO(Client client){
        return ClientResponseDTO.builder()
                .cnpj(client.getCnpj())
                .cpf(client.getCpf())
                .email(client.getEmail())
                .firstPhoneNumber(client.getFirstPhoneNumber())
                .secondPhoneNumber(client.getSecondPhoneNumber())
                .id(client.getId())
                .name(client.getName())
                .personType(client.getPersonType())
                .requestToken(client.getRequestToken())
                .build();
    }
}
