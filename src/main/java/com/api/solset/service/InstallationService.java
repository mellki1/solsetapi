package com.api.solset.service;

import com.api.solset.dto.ClientResponseDTO;
import com.api.solset.dto.InstallationRequestDTO;
import com.api.solset.dto.InstallationResponseDTO;
import com.api.solset.mapper.InstallationMapper;
import com.api.solset.model.Client;
import com.api.solset.model.Installation;
import com.api.solset.model.User;
import com.api.solset.repository.InstallationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.ArrayList;
import java.util.List;

@Service
public class InstallationService {

    @Autowired
    private InstallationRepository installationRepository;

    @Autowired
    private BudgetService budgetService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private UserService userService;

    public List<Installation> findAll(){
        return installationRepository.findAll();
    }

    public List<InstallationResponseDTO> findAllWithRelationship(){
        List<InstallationResponseDTO> installationResponseDTOList = new ArrayList<>();
        for (Installation installation : installationRepository.findAll()){
            InstallationResponseDTO installationResponseDTO = InstallationMapper.INSTANCE.toInstallationResponseDTO(installation);
            installationResponseDTO.setClient(clientService.findByIdOrElseThrowDto(installation.getClientId()));
            installationResponseDTO.setBudgets(budgetService.findByInstallationId(installation.getId()));
            installationResponseDTOList.add(installationResponseDTO);
        }
        return installationResponseDTOList;
    }

    public List<InstallationResponseDTO> findByUserRequestToken(String requestToken){
        List<InstallationResponseDTO> installationResponseDTOList = new ArrayList<>();
        for (Installation installation : installationRepository.findByRequestToken(requestToken)){
            InstallationResponseDTO installationResponseDTO = InstallationMapper.INSTANCE.toInstallationResponseDTO(installation);
            installationResponseDTO.setClient(clientService.findByIdOrElseThrowDto(installation.getClientId()));
            installationResponseDTO.setBudgets(budgetService.findByInstallationId(installation.getId()));
            installationResponseDTOList.add(installationResponseDTO);
        }
        return installationResponseDTOList;
    }

    public Installation findByIdOrElseThrow(Long id){
        return installationRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Installation not found"));
    }

    public List<InstallationResponseDTO> findByClientId(Long clientId){
        List<InstallationResponseDTO> installationResponseDTOList = new ArrayList<>();
        for (Installation installation : installationRepository.findByClientId(clientId)){
            InstallationResponseDTO installationResponseDTO = InstallationMapper.INSTANCE.toInstallationResponseDTO(installation);
            installationResponseDTO.setBudgets(budgetService.findByInstallationId(installation.getId()));
            installationResponseDTOList.add(installationResponseDTO);
        }
        return installationResponseDTOList;
    }

    public Installation save(Installation installation){
        return installationRepository.save(installation);
    }

    public void update(Long id, InstallationRequestDTO installationRequestDTO){
        Installation installationSaved = findByIdOrElseThrow(id);
        Installation newInstallation = InstallationMapper.INSTANCE.toInstallation(installationRequestDTO);
        newInstallation.setId(installationSaved.getId());
        installationRepository.save(newInstallation);
    }

    public void delete(Long id){
        installationRepository.deleteById(id);
    }
}
