package com.api.solset.repository;

import com.api.solset.model.Budget;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BudgetRepository extends JpaRepository<Budget, Integer> {
    List<Budget> findByInstallationId(Integer installationId);
}
