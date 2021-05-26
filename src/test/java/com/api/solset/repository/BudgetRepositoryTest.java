package com.api.solset.repository;

import com.api.solset.model.Budget;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.util.Date;

@DataJpaTest
@DisplayName("Tests for Budget Repository")
class BudgetRepositoryTest {

    @Autowired
    private BudgetRepository budgetRepository;

    @Test
    @DisplayName("Save creates budget when Successful")
    public void save_PersistBudget_WhenSuccessful(){
        Budget budgetToBeSaved = createBudget();
        budgetToBeSaved.setId(1L);
        Budget budgetSaved = this.budgetRepository.save(budgetToBeSaved);

        //verify notNull
        Assertions.assertThat(budgetSaved).isNotNull();
        Assertions.assertThat(budgetSaved.getId()).isNotNull();
        Assertions.assertThat(budgetSaved.getInstallationId()).isNotNull();
        Assertions.assertThat(budgetSaved.getLaborValue()).isNotNull();
        Assertions.assertThat(budgetSaved.getProposalNumber()).isNotNull();
        Assertions.assertThat(budgetSaved.getSituation()).isNotNull();
        //Assertions.assertThat(budgetSaved.getUpdatingDate()).isNotNull();
        Assertions.assertThat(budgetSaved.getValue()).isNotNull();

        //verify equal toBeSaved
        Assertions.assertThat(budgetSaved.getInstallationId()).isEqualTo(budgetToBeSaved.getInstallationId());
        Assertions.assertThat(budgetSaved.getLaborValue()).isEqualTo(budgetToBeSaved.getLaborValue());
        Assertions.assertThat(budgetSaved.getProposalNumber()).isEqualTo(budgetToBeSaved.getProposalNumber());
        Assertions.assertThat(budgetSaved.getSituation()).isEqualTo(budgetToBeSaved.getSituation());
        //Assertions.assertThat(budgetSaved.getUpdatingDate()).isEqualTo(budgetToBeSaved.getUpdatingDate());
        Assertions.assertThat(budgetSaved.getValue()).isEqualTo(budgetToBeSaved.getValue());
    }


    private Budget createBudget(){
        return Budget.builder()
                .installationId(1L)
                .laborValue(2)
                .proposalNumber(123)
                .situation("top")
                //.updatingDate("2020-20-20")
                .value(50)
                .build();
    }

}