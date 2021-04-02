package com.api.solset.service;

import com.api.solset.model.Installation;
import com.api.solset.repository.InstallationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstallationService {

    @Autowired
    InstallationRepository installationRepository;

    public List<Installation> findAll(){
        return installationRepository.findAll();
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
