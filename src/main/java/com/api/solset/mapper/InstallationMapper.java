package com.api.solset.mapper;

import com.api.solset.dto.InstallationRequestDTO;
import com.api.solset.dto.InstallationResponseDTO;
import com.api.solset.model.Installation;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class InstallationMapper {
    public static final InstallationMapper INSTANCE = Mappers.getMapper(InstallationMapper.class);
    public abstract Installation toInstallation(InstallationRequestDTO installationRequestDTO);
    public abstract InstallationResponseDTO toInstallationResponseDTO(Installation installation);
}
