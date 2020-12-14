package Entities;

import java.util.ArrayList;
import java.util.List;

public class Distribuitor {
    private int id;
    private int contractLength;
    private int Budget;
    private int InfrastructureCost;
    private int ProductionCost;
    private int currentConsumators;
    private int newArrivals;
    public boolean faliment;
    public boolean payed;
    private int newInfrastructureCost;
    private int newProductionCost;

    private int thisMonthConsummers;
    private int lastMonthConsumers;

    public List<Contract> contracte  = new ArrayList<>();
    public List<Contract> contracteActive;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getContractLength() {
        return contractLength;
    }

    public void setContractLength(int contractLength) {
        this.contractLength = contractLength;
    }

    public int getBudget() {
        return Budget;
    }

    public void setBudget(int budget) {
        Budget = budget;
    }

    public int getInfrastructureCost() {
        return InfrastructureCost;
    }

    public void setInfrastructureCost(int infrastructureCost) {
        InfrastructureCost = infrastructureCost;
    }

    public int getProductionCost() {
        return ProductionCost;
    }

    public void setProductionCost(int productionCost) {
        ProductionCost = productionCost;
    }

    public int getCurrentConsumators() {
        return currentConsumators;
    }

    public void setCurrentConsumators(int currentConsumators) {
        this.currentConsumators = currentConsumators;
    }

    public Distribuitor(int id, int contractLength, int budget, int infrastructureCost, int productionCost) {
        this.id = id;
        this.contractLength = contractLength;
        Budget = budget;
        InfrastructureCost = infrastructureCost;
        ProductionCost = productionCost;
        newInfrastructureCost = infrastructureCost;
        newProductionCost = productionCost;
        this.currentConsumators = 0;
        this.faliment = false;
        this.payed = false;
        thisMonthConsummers = 0;
        lastMonthConsumers = 0;
        contracteActive = new ArrayList<>();
    }
    public void updateChanges(){
        setInfrastructureCost(newInfrastructureCost);
        setProductionCost(newProductionCost);
    }
    int getPretfinalContract() {
        if (lastMonthConsumers == 0) {
            return Math.round(InfrastructureCost + getProductionCost() + getProfit());
        }
        return (int) Math.round(Math.floor(InfrastructureCost / lastMonthConsumers) + getProductionCost() + getProfit());
    }

    public int getCostMonth() {
        return InfrastructureCost + getProductionCost() * currentConsumators;
    }

    public int getProfit() {
        return (int) Math.round(Math.floor(0.2 * ProductionCost));
    }

    public void PayCostMonth() {
        if(!faliment){
//            System.out.println("a scazut" + getCostMonth() + " " +InfrastructureCost + " " + ProductionCost + " " + currentConsumators);
            Budget -= getCostMonth();
        }
    }

    public void addContract(Contract contract) {
        contracteActive.add(contract);
        currentConsumators++;
    }

    public void deleteContract(Contract contract) {

        boolean verify = contracteActive.remove(contract);
        if(verify)
        currentConsumators--;
    }

    public List<Contract> getContracts() {
        return contracteActive;
    }

    public void getPay(int val) {
        Budget += val;
    }
    public void addConsumer(){
        newArrivals++;
    }
    public void loadConsumers(){
        currentConsumators += newArrivals;
        newArrivals = 0;
    }
    public void getMoney(int val){
        Budget += val;
    }
    public void getChanges(int x, int y){
        newInfrastructureCost = x;
        newProductionCost = y;
    }
    public void updateConsumers(){
        lastMonthConsumers = currentConsumators;
    }
}
