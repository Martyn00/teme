package Input;

public class Consumer {
    private int initialBudget;
    private int monthlyIncome;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;
    public int getInitialBudget() {
        return initialBudget;
    }

    public void setInitialBudget(int initialBudget) {
        this.initialBudget = initialBudget;
    }

    public int getMonthlyIncome() {
        return monthlyIncome;
    }

    public void setMonthlyBudget(int monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    public Consumer() {
        this.initialBudget = 0;
        this.monthlyIncome = 0;
        this.id = 0;
    }
    public Consumer(int id, int initialBudget, int monthlyBudget) {
        this.initialBudget = initialBudget;
        this.monthlyIncome = monthlyBudget;
        this.id = id;
    }
}
