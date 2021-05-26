package com.api.solset.mapper;

import com.api.solset.dto.InstallationRequestDTO;
import com.api.solset.dto.InstallationResponseDTO;
import com.api.solset.model.Installation;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class InstallationMapper {
    public static final InstallationMapper INSTANCE = Mappers.getMapper(InstallationMapper.class);
    public Installation toInstallation(InstallationRequestDTO installationRequestDTO){
        return Installation.builder()
                .address1(installationRequestDTO.getAddress1())
                .address2(installationRequestDTO.getAddress2())
                .city(installationRequestDTO.getCity())
                .classes(installationRequestDTO.getClasses())
                .clientId(installationRequestDTO.getClientId())
                .financing(installationRequestDTO.getFinancing())
                .observations(installationRequestDTO.getObservations())
                .technology(installationRequestDTO.getTechnology())
                .postalCode(installationRequestDTO.getPostalCode())
                .state(installationRequestDTO.getState())
                .structure(installationRequestDTO.getStructure())
                .requestToken(installationRequestDTO.getRequestToken())
                .voltage(installationRequestDTO.getVoltage())
                .fileList(installationRequestDTO.getFileList())
                .createdDate(installationRequestDTO.getCreatedDate())
                .id(installationRequestDTO.getId())
                .build();
    }
    public InstallationResponseDTO toInstallationResponseDTO(Installation installation){
        return InstallationResponseDTO.builder()
                .address1(installation.getAddress1())
                .address2(installation.getAddress2())
                .city(installation.getCity())
                .classes(installation.getClasses())
                .financing(installation.getFinancing())
                .observations(installation.getObservations())
                .technology(installation.getTechnology())
                .postalCode(installation.getPostalCode())
                .state(installation.getState())
                .structure(installation.getStructure())
                .requestToken(installation.getRequestToken())
                .voltage(installation.getVoltage())
                .fileList(installation.getFileList())
                .createdDate(installation.getCreatedDate())
                .id(installation.getId())
                .build();
    }
}
