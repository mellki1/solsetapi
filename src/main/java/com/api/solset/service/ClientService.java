package com.api.solset.service;

import com.api.solset.model.Client;
import com.api.solset.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    public List<Client> findAll(){
        return clientRepository.findAll();
    }

    public List<Client> findByUserId(Integer userId){
        return clientRepository.findByUserId(userId);
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
