package Output;

import Entities.Contract;
import Entities.Distribuitor;

import java.util.ArrayList;
import java.util.List;

public class DistsributersOutput {
    private int id;
    private int budget;
    private boolean isBankrupt;
    private List<ContractOutput> contracts = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public boolean isBankrupt() {
        return isBankrupt;
    }

    public void setBankrupt(boolean bankrupt) {
        isBankrupt = bankrupt;
    }

    public List<ContractOutput> getContracts() {
        return contracts;
    }

    public void setContracts(List<ContractOutput> contracts) {
        this.contracts = contracts;
    }

    public DistsributersOutput(Distribuitor distribuitor) {
        this.id = distribuitor.getId();
        this.budget = distribuitor.getBudget();
        this.isBankrupt = distribuitor.faliment;
        for(Contract contract : distribuitor.getContracts()){
            this.contracts.add(new ContractOutput(contract));
        }
    }
}
