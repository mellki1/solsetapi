package com.api.solset.repository;

import com.api.solset.model.Installation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstallationRepository extends JpaRepository<Installation, Integer> {
}
