package com.api.solset.dto;

import com.api.solset.model.Budget;
import com.api.solset.model.Installation;
import java.util.List;

public class InstallationDTO {
    Installation installation;
    List<Budget> budgets;

    public InstallationDTO(Installation installation, List<Budget> budgets) {
        this.installation = installation;
        this.budgets = budgets;
    }

    public Installation getInstallation() {
        return installation;
    }

    public void setInstallation(Installation installation) {
        this.installation = installation;
    }

    public List<Budget> getBudgets() {
        return budgets;
    }

    public void setBudgets(List<Budget> budgets) {
        this.budgets = budgets;
    }
}