package com.api.solset.repository;

import com.api.solset.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Integer> {
        List<Client> findByUserId(Integer id);
}
