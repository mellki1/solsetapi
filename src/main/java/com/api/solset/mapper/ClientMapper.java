package com.api.solset.mapper;

import com.api.solset.dto.ClientRequestDTO;
import com.api.solset.dto.ClientResponseDTO;
import com.api.solset.model.Client;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class ClientMapper {
    public static final ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);
    public abstract Client toClient(ClientRequestDTO clientRequestDTO);
    public abstract ClientResponseDTO toClientResponseDTO(Client client);
}
