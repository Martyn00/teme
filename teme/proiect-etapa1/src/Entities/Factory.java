package Entities;

import Input.Consumer;
import Input.Distributor;

public class Factory {
    public Consumator createConsumator(Consumer cons){
        return new Consumator(cons.getId(), cons.getInitialBudget(), cons.getMonthlyIncome());
    }
    public Distribuitor createDistribuitor(Distributor dist){
        return new Distribuitor(dist.getId(), dist.getContractLength(), dist.getInitialBudget(),
                dist.getInitialInfrastructureCost(), dist.getInitialProductionCost());
    }
//    public Object create(Object obj){
//        switch(obj.getClass().){
//            case Consumer:
//
//        }
//    }

}
