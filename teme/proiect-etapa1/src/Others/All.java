package Others;

import Entities.*;
import Input.Data;
import Input.MonthlyUpdates;
import Output.Output;

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
//        consumatori.printConsumatoriStatus();
//        distribuitori.printDistribuitoriStatus();
        consumatori.updateBudget();
        createNewContracts();
        monthlyUpdate();
        distribuitori.payTaxes();
        distribuitori.loadDistribuitori();
        DestroyContracts();
    }

    public void monthlyUpdate() {
        for (Contract contract : contracte) {
            boolean over = contract.UpdateContract();
        }
    }

    public Output monthlyiteration() {
        for (int i = 0; i < data.getMonthlyUpdates().size(); i++) {
            MonthlyUpdates mon = data.getMonthlyUpdates().get(i);
            update(mon);
            distribuitori.loadDistribuitori();
            consumatori.updateBudget();
            createNewContracts();
            monthlyUpdate();
            distribuitori.payTaxes();
            for (Consumator consumator : consumatori.retList()) {
                if (consumator.faliment) {
                    for (Contract contract : consumator.contracte) {
                        contract.getDistribuitor().deleteContract(contract);
                        contracte.remove(contract);
                        consumator.freeOfContract = true;
                    }
                    consumator.contracte = new ArrayList<>();
                }
            }
            if (i == data.getMonthlyUpdates().size() - 1) {
                return new Output(consumatori.retList(), distribuitori.getDists());
            }
            DestroyContracts();
        }
        return null;
    }

    public void createNewContracts() {
        for (Consumator cons : consumatori.retList()) {
            if (cons.getId() == 55) {
                System.out.println(cons.faliment + "// " + cons.freeOfContract);
            }
            if (!cons.faliment && cons.freeOfContract) {
                Distribuitor distribuitor = distribuitori.findLowestpriceDistributor();
                Contract contract = new Contract(cons, distribuitor);
                contracte.add(contract);
                cons.contracte.add(contract);
                cons.freeOfContract = false;
                distribuitor.addContract(contract);
            }
        }
    }

    public void DestroyContracts() {
        for (Consumator consumator : consumatori.retList()) {
            if (consumator.faliment) {
                for (Contract contract : consumator.contracte) {
                    contract.getDistribuitor().deleteContract(contract);
                    contracte.remove(contract);
                    consumator.freeOfContract = true;
                }
                consumator.contracte = new ArrayList<>();
            }
        }
        for (Distribuitor distribuitor : distribuitori.getDists()) {
            distribuitor.updateConsumers();
        }
        List<Contract> del = new ArrayList<>();
        for (Contract contract : contracte) {
            if (contract.monthstoDo == contract.monthsDone && !contract.restanta) {
                contract.getDistribuitor().deleteContract(contract);
                contract.getConsumator().freeOfContract = true;
                del.add(contract);
            }
        }
        for (Contract contract : del) {
            contracte.remove(contract);
        }
        for (Distribuitor distribuitor : distribuitori.getDists()) {
            if (distribuitor.getBudget() < 0) {
                distribuitor.faliment = true;
                for (Contract contract : distribuitor.getContracts()) {
                    contracte.remove(contract);
                    contract.getConsumator().freeOfContract = true;
                    contract.getConsumator().contracte = new ArrayList<>();
                }
                distribuitor.contracteActive = new ArrayList<>();
            }
        }
    }

    public Output doALl() {
        return monthlyiteration();
    }

    public void update(MonthlyUpdates mon) {
        if (!mon.getNewConsumers().isEmpty()) {
            consumatori.addConsumatori(mon.getNewConsumers());
        }
        if (!mon.getCostsChanges().isEmpty()) {
            distribuitori.UpdateDistribuitori(mon.getCostsChanges());

        }
    }
}
