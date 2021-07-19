package com.api.solset.repository;

import com.api.solset.model.Budget;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BudgetRepository extends JpaRepository<Budget, Long> {
    List<Budget> findByClientId(Long clientId);

    List<Budget> findByRequestToken(String requestToken);

    void deleteByClientId(Long clientId);
}
