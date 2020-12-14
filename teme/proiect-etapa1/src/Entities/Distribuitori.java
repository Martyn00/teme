package Entities;

import Input.CostChanges;
import Input.Distributor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Distribuitori {
    List<Distribuitor> dists = new ArrayList<>();
    Map<Integer, Distribuitor> mapDist = new HashMap<Integer, Distribuitor>();
    Factory fac;

    public Distribuitori(List<Distributor> distributors) {
        for (Distributor x : distributors) {
            Distribuitor dist = new Distribuitor(x.getId(), x.getContractLength(), x.getInitialBudget(),
                    x.getInitialInfrastructureCost(), x.getInitialProductionCost());
            dists.add(dist);
            mapDist.put(x.getId(), dist);
        }
    }

    public Distribuitor findLowestpriceDistributor() {
        Distribuitor lower = dists.get(0);
        if (lower.faliment) {
            lower = dists.get(1);

        }
        for (Distribuitor x : dists) {
            if (lower.getPretfinalContract() > x.getPretfinalContract() && !x.faliment) {
                lower = x;
            }
        }
        return lower;
    }

    public Distribuitor getById(Integer x) {
        return mapDist.get(x);
    }

    public void payTaxes() {
        for (Distribuitor dist : dists) {
            dist.PayCostMonth();
        }
    }

    public void printDistribuitoriStatus() {
        for (Distribuitor d : dists) {
            System.out.println(d.getId() + " " + d.getBudget() + " " + d.faliment);
        }
    }

    public void UpdateDistribuitori(List<CostChanges> costChanges) {
        for (CostChanges cc : costChanges) {
            mapDist.get(cc.getId()).getChanges(cc.getInfrastructureCost(), cc.getProductionCost());
        }
    }

    public void loadDistribuitori() {
        for (Distribuitor d : dists) {
            d.updateChanges();
        }
    }

    public void loadConsumers() {
        for (Distribuitor dist : dists) {
            dist.loadConsumers();
        }
    }

    public List<Distribuitor> getDists() {
        return dists;
    }
}
