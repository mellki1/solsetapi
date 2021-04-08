package com.api.solset.service;

import com.api.solset.dto.InstallationDTO;
import com.api.solset.model.Installation;
import com.api.solset.repository.InstallationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InstallationService {

    @Autowired
    private InstallationRepository installationRepository;

    @Autowired
    private BudgetService budgetService;

    public List<Installation> findAll(){
        return installationRepository.findAll();
    }

    public List<InstallationDTO> findByClientId(Integer clientId){
        List<InstallationDTO> installationDTOList = new ArrayList<>();
        for (Installation installation : installationRepository.findByClientId(clientId)){
            InstallationDTO installationDTO = new InstallationDTO(installation, budgetService.findByInstallationId(installation.getId()));
            installationDTOList.add(installationDTO);
        }
        return installationDTOList;
    }

    public Installation save(Installation installation){
        return installationRepository.save(installation);
    }

    public Installation update(Installation installation){
        this.delete(installation.getId());
        return installationRepository.save(installation);
    }

    public void delete(Integer id){
        installationRepository.deleteById(id);
    }
}
