package com.api.solset.service;

import com.api.solset.dto.ClientRequestDTO;
import com.api.solset.dto.ClientResponseDTO;
import com.api.solset.mapper.ClientMapper;
import com.api.solset.model.Budget;
import com.api.solset.model.Client;
import com.api.solset.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private BudgetService budgetService;

    @Autowired
    private UserService userService;

    @Autowired
    private LogService logService;

    public List<Client> listAll(){
        return clientRepository.findAll();
    }

    public List<ClientResponseDTO> listAllWithRelationship(String masterName){
        List<ClientResponseDTO> clientResponseDTOList = new ArrayList<>();
        List<Client> clientList = null;
        if (masterName.equals("ALL")) {
            clientList = clientRepository.findAll();
        }else{
            clientList = clientRepository.findByMasterName(masterName);
        }
        for (Client client : clientList){
            ClientResponseDTO clientResponseDTO = ClientMapper.INSTANCE.toClientResponseDTO(client);
            clientResponseDTO.setBudgetResponseDTOList(budgetService.findByClientId(clientResponseDTO.getId()));
            clientResponseDTO.setLogResponseDTOList(logService.findByClientIdOrElseThrow(client.getId()));
            clientResponseDTOList.add(clientResponseDTO);
        }
        return clientResponseDTOList;
    }

    public List<ClientResponseDTO> listAllWithRelationshipByToken(String requestToken){
        List<ClientResponseDTO> clientResponseDTOList = new ArrayList<>();
        for (Client client : clientRepository.findByRequestToken(requestToken)) {
            ClientResponseDTO clientResponseDTO = ClientMapper.INSTANCE.toClientResponseDTO(client);
            clientResponseDTO.setBudgetResponseDTOList(budgetService.findByClientId(clientResponseDTO.getId()));
            clientResponseDTO.setLogResponseDTOList(logService.findByClientIdOrElseThrow(client.getId()));
            clientResponseDTOList.add(clientResponseDTO);
        }
        return clientResponseDTOList;
    }

    public Client findByIdOrElseThrow(Long id){
        return clientRepository.findById(id).orElse(new Client());
    }


    public ClientResponseDTO findByIdOrElseThrowDto(Long id){
        if (id != null){
            Client client = clientRepository.findById(id).orElse(new Client());
            return ClientMapper.INSTANCE.toClientResponseDTO(client);
        }
        return new ClientResponseDTO();
    }

    public ClientResponseDTO findByIdOrElseThrowWithRelationship(Long id){
        Client client = clientRepository.findById(id).orElse(new Client());
        ClientResponseDTO clientResponseDTO = ClientMapper.INSTANCE.toClientResponseDTO(client);
        clientResponseDTO.setBudgetResponseDTOList(budgetService.findByClientId(clientResponseDTO.getId()));
        clientResponseDTO.setLogResponseDTOList(logService.findByClientIdOrElseThrow(client.getId()));
        return clientResponseDTO;
    }

    public List<ClientResponseDTO> findByUserRequestToken(String requestToken){
        List<ClientResponseDTO> clientResponseDTOList = new ArrayList<>();
        for (Client client : clientRepository.findByRequestToken(requestToken)){
            ClientResponseDTO clientResponseDTO = ClientMapper.INSTANCE.toClientResponseDTO(client);
            clientResponseDTO.setBudgetResponseDTOList(budgetService.findByClientId(clientResponseDTO.getId()));
            clientResponseDTO.setLogResponseDTOList(logService.findByClientIdOrElseThrow(client.getId()));
            clientResponseDTOList.add(clientResponseDTO);
        }
        return clientResponseDTOList;
    }

    public Client save(ClientRequestDTO clientRequestDTO){
        return clientRepository.save(
                ClientMapper.INSTANCE.toClient(clientRequestDTO)
        );
    }

    public void update(Long id, ClientRequestDTO clientRequestDTO){
        Client clientSaved = findByIdOrElseThrow(clientRequestDTO.getId());
        Client newClient = ClientMapper.INSTANCE.toClient(clientRequestDTO);
        newClient.setId(clientSaved.getId());
        clientRepository.save(newClient);
    }

    public void delete(Long id){
        budgetService.deleteByClientId(id);
        logService.deleteByClientId(id);
        clientRepository.deleteById(id);
    }
}
