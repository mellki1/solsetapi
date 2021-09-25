package com.api.solset.repository;

import com.api.solset.model.Proposal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProposalRepository extends JpaRepository<Proposal, Long> {
    List<Proposal> findByBudgetId(Long budgetId);

    List<Proposal> findByRequestToken(String requestToken);

    List<Proposal> findByMasterName(String masterName);
}
