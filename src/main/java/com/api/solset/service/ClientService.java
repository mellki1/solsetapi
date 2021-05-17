package com.api.solset.service;

import com.api.solset.dto.ClientRequestDTO;
import com.api.solset.dto.ClientResponseDTO;
import com.api.solset.mapper.ClientMapper;
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
    private InstallationService installationService;

    public List<Client> listAll(){
        return clientRepository.findAll();
    }

    public List<ClientResponseDTO> listAllWithRelationship(){
        List<ClientResponseDTO> clientResponseDTOList = new ArrayList<>();
        for (Client client : clientRepository.findAll()){
            ClientResponseDTO clientResponseDTO = ClientMapper.INSTANCE.toClientResponseDTO(client);
            clientResponseDTO.setInstallations(installationService.findByClientId(clientResponseDTO.getId()));
            clientResponseDTOList.add(clientResponseDTO);
        }
        return clientResponseDTOList;
    }

    public Client findByIdOrElseThrow(Long id){
        return clientRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Client not found"));
    }


    public ClientResponseDTO findByIdOrElseThrowDto(Long id){
        Client client = clientRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Client not found"));
        ClientResponseDTO clientResponseDTO = ClientMapper.INSTANCE.toClientResponseDTO(client);
        clientResponseDTO.setInstallations(installationService.findByClientId(client.getId()));
        return clientResponseDTO;
    }

    public ClientResponseDTO findByIdOrElseThrowWithRelationship(Long id){
        Client client = clientRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Client not found"));
        ClientResponseDTO clientRequestDTO = ClientMapper.INSTANCE.toClientResponseDTO(client);
        clientRequestDTO.setInstallations(installationService.findByClientId(clientRequestDTO.getId()));
        return clientRequestDTO;
    }

    public List<ClientResponseDTO> findByUserId(Long userId){
        List<ClientResponseDTO> clientResponseDTOList = new ArrayList<>();
        for (Client client : clientRepository.findByUserId(userId)){
            ClientResponseDTO clientResponseDTO = ClientMapper.INSTANCE.toClientResponseDTO(client);
            clientResponseDTO.setInstallations(installationService.findByClientId(clientResponseDTO.getId()));
            clientResponseDTOList.add(clientResponseDTO);
        }
        return clientResponseDTOList;
    }

    public Client save(ClientRequestDTO clientRequestDTO){
        return clientRepository.save(
                ClientMapper.INSTANCE.toClient(clientRequestDTO)
        );
    }

    public void update(ClientRequestDTO clientRequestDTO){
        Client clientSaved = findByIdOrElseThrow(clientRequestDTO.getId());
        Client newClient = ClientMapper.INSTANCE.toClient(clientRequestDTO);
        newClient.setId(clientSaved.getId());
        clientRepository.save(newClient);
    }

    public void delete(Long id){
        clientRepository.deleteById(id);
    }
}
