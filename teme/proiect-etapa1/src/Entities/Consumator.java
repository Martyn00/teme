package Entities;

import java.util.ArrayList;
import java.util.List;

public class Consumator {
    private int Budget;
    private int monthlyIncome;
    private int id;
    public boolean faliment;
    public boolean freeOfContract;
    public List<Contract> contracte  = new ArrayList<>();
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBudget() {
        return Budget;
    }

    public void setBudget(int budget) {
        Budget = budget;
    }

    public int getMonthlyIncome() {
        return monthlyIncome;
    }

    public void setMonthlyIncome(int monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    public Consumator(int id, int budget, int monthlyIncome) {
        Budget = budget;
        this.monthlyIncome = monthlyIncome;
        this.id = id;
        this.faliment = false;
        this.freeOfContract = true;
    }
    public void increaseBudget(){
        if(!faliment) {
            Budget += monthlyIncome;
        }
    }

    public boolean canPay(int val){
        return Budget - val >= 0;
    }

    public int PayCost(int val){
        if(canPay(val)){
            Budget -= val;
            return val;
        }else{
            return 0;
        }
    }

}
