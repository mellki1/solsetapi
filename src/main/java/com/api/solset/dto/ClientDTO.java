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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<InstallationDTO> getInstallations() {
        return installations;
    }

    public void setInstallations(List<InstallationDTO> installations) {
        this.installations = installations;
    }
}
