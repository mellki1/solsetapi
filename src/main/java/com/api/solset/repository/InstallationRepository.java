package com.api.solset.repository;

import com.api.solset.model.Installation;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface InstallationRepository extends JpaRepository<Installation, Integer> {
    List<Installation> findByClientId(Integer clientId);
}
