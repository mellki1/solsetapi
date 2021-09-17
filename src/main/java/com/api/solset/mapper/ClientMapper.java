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
                .fantasyName(clientRequestDTO.getFantasyName())
                .personType(clientRequestDTO.getPersonType())
                .requestToken(clientRequestDTO.getRequestToken())
                .postalCode(clientRequestDTO.getPostalCode())
                .address1(clientRequestDTO.getAddress1())
                .address2(clientRequestDTO.getAddress2())
                .city(clientRequestDTO.getCity())
                .state(clientRequestDTO.getState())
                .complement(clientRequestDTO.getComplement())
                .contactName(clientRequestDTO.getContactName())
                .masterName(clientRequestDTO.getMasterName())
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
                .fantasyName(client.getFantasyName())
                .personType(client.getPersonType())
                .postalCode(client.getPostalCode())
                .address1(client.getAddress1())
                .address2(client.getAddress2())
                .city(client.getCity())
                .state(client.getState())
                .complement(client.getComplement())
                .requestToken(client.getRequestToken())
                .contactName(client.getContactName())
                .masterName(client.getMasterName())
                .build();
    }
}
