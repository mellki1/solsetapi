package com.api.solset.service;

import com.api.solset.dto.ClientDTO;
import com.api.solset.model.Client;
import com.api.solset.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private InstallationService installationService;

    public List<Client> findAll(){
        return clientRepository.findAll();
    }

    public List<ClientDTO> findByUserId(Integer userId){
        List<ClientDTO> clientDTOList = new ArrayList<>();
        for (Client client : clientRepository.findByUserId(userId)){
            ClientDTO clientDTO = new ClientDTO(client, installationService.findByClientId(client.getId()));
            clientDTOList.add(clientDTO);
        }
        return clientDTOList;
    }

    public Client save(Client client){
        return clientRepository.save(client);
    }

    public Client update(Client client){
        this.delete(client.getId());
        return clientRepository.save(client);
    }

    public void delete(Integer id){
        clientRepository.deleteById(id);
    }


}
