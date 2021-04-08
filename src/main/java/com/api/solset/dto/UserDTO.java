package com.api.solset.dto;

import com.api.solset.model.User;
import java.util.List;

public class UserDTO {
    User user;
    List<ClientDTO> clients;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<ClientDTO> getClients() {
        return clients;
    }

    public void setClients(List<ClientDTO> clients) {
        this.clients = clients;
    }
}
