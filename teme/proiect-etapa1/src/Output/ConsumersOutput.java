package Output;

public class ConsumersOutput {
    private int id;
    private boolean isBankrupt;
    private int budget;
    ConsumersOutput(int id, boolean faliment, int budget){
        this.id = id;
        this.isBankrupt = faliment;
        this.budget = budget;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isBankrupt() {
        return isBankrupt;
    }

    public void setBankrupt(boolean bankrupt) {
        isBankrupt = bankrupt;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }
}
