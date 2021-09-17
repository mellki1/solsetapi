package com.api.solset.repository;

import com.api.solset.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {
        List<Client> findByRequestToken(String requestToken);
        List<Client> findByMasterName(String masterName);
}
