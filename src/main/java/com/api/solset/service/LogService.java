package com.api.solset.service;

import com.api.solset.model.Log;
import com.api.solset.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class LogService {
    
    @Autowired
    LogRepository logRepository;
    
    public List<Log> listAll(){
        return logRepository.findAll();
    }

    public Log findByIdOrElseThrow(Long id){
        return logRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Log not found"));
    }

    public List<Log> findByClientIdOrElseThrow(Long clientId){
        return logRepository.findByClientId(clientId);
    }

    public List<Log> findByRequestToken(String requestToken){
        return logRepository.findByRequestToken(requestToken);
    }

    public Log save(Log log){
        return logRepository.save(log);
    }

    public void update(Log log){
        findByIdOrElseThrow(log.getId());
        delete(log.getId());
        logRepository.save(log);
    }

    public void delete(Long id){
        logRepository.deleteById(id);
    }
}
