package Output;

import Entities.Consumator;

public class ConsumersOutput {
    private int id;
    private boolean isBankrupt;
    private int budget;

    ConsumersOutput(Consumator consumator) {
        this.id = consumator.getId();
        this.isBankrupt = consumator.faliment;
        this.budget = consumator.getBudget();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean getisBankrupt() {
        return isBankrupt;
    }

    public void setisBankrupt(boolean bankrupt) {
        isBankrupt = bankrupt;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }
}
