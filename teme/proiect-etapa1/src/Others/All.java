package Others;

import Entities.*;
import Input.Data;
import Input.MonthlyUpdates;

import java.util.ArrayList;
import java.util.List;

public class All {
    Consumatori consumatori;
    Distribuitori distribuitori;
    Data data;
    List<Contract> contracte = new ArrayList<>();

    public All(Data data) {
        this.data = data;
        distribuitori = new Distribuitori(data.getInitialData().getDistributors());
        consumatori = new Consumatori(data.getInitialData().getConsumers());
//
        consumatori.printConsumatoriStatus();
        distribuitori.printDistribuitoriStatus();
        consumatori.updateBudget();
        createNewContracts();
        monthlyUpdate();
        distribuitori.payTaxes();
        distribuitori.loadDistribuitori();
        DestroyContracts();
    }

    public void monthlyUpdate() {
        for(Contract contract : contracte){
           boolean over = contract.UpdateContract();
        }
    }

    public void monthlyiteration() {
        System.out.println();
        for (MonthlyUpdates mon : data.getMonthlyUpdates()) {
            consumatori.printConsumatoriStatus();
            distribuitori.printDistribuitoriStatus();
            update(mon);
            distribuitori.loadDistribuitori();
            consumatori.updateBudget();
            createNewContracts();
//            distribuitori.loadConsumers();
            monthlyUpdate();
            distribuitori.payTaxes();
            DestroyContracts();
            System.out.println();
        }
    }

    public void createNewContracts() {
        for (Consumator cons : consumatori.retList()) {
            if (!cons.faliment && cons.freeOfContract) {
                Distribuitor distribuitor = distribuitori.findLowestpriceDistributor();
                Contract contract = new Contract(cons,distribuitor);
                contracte.add(contract);
                cons.contracte.add(contract);
                cons.freeOfContract = false;
                distribuitor.addContract(contract);
            }
        }
    }

    public void DestroyContracts(){
        for(Consumator consumator : consumatori.retList()){
            if(consumator.faliment){
                for(Contract contract : consumator.contracte){
                    contract.getDistribuitor().deleteContract(contract);
                    contracte.remove(contract);
                    consumator.freeOfContract = true;
                }
                consumator.contracte = new ArrayList<>();
            }
        }
        List<Contract> del = new ArrayList<>();
        for(Contract contract : contracte){
                if(contract.monthstoDo == contract.monthsDone){
                    contract.getDistribuitor().deleteContract(contract);
                    contract.getConsumator().freeOfContract = true;
                    del.add(contract);
                }
        }
        for(Contract contract : del){
            contracte.remove(contract);
        }
        for(Distribuitor distribuitor : distribuitori.getDists()){
            if(distribuitor.getBudget() < 0){
                distribuitor.faliment = true;
                for(Contract contract : distribuitor.getContracts()){
                    contracte.remove(contract);
                    contract.getConsumator().freeOfContract = true;
                    contract.getConsumator().contracte = new ArrayList<>();
                }
                distribuitor.contracteActive = new ArrayList<>();
            }
        }
    }

    public void doALl() {
        monthlyiteration();
        consumatori.printConsumatoriStatus();
        System.out.println();
        distribuitori.printDistribuitoriStatus();
    }

    public void update(MonthlyUpdates mon) {
        if(!mon.getNewConsumers().isEmpty()){
            consumatori.addConsumatori(mon.getNewConsumers());
        }
        if(!mon.getCostsChanges().isEmpty()){
            distribuitori.UpdateDistribuitori(mon.getCostsChanges());

        }
    }
}
