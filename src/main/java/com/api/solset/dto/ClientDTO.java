package com.api.solset.dto;

import com.api.solset.model.Client;
import java.util.List;

public class ClientDTO {
    Client client;
    List<InstallationDTO> installations;

    public ClientDTO(Client client, List<InstallationDTO> installations) {
        this.client = client;
        this.installations = installations;
    }
}
