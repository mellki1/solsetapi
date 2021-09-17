package com.api.solset.repository;

import com.api.solset.model.Log;
import com.api.solset.model.Proposal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LogRepository extends JpaRepository<Log, Long> {
    List<Log> findByRequestToken(String requestToken);
    List<Log> findByClientId(Long clientId);
    List<Log> findByMasterName(String masterName);
    void deleteByClientId(Long clientId);
}
