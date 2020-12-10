package Entities;

import Input.Consumer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Consumatori {
    List<Consumator> cons= new ArrayList<>();
    Map<Integer, Consumator> mapCons = new HashMap<Integer, Consumator>();

    Factory fac;
    public Consumatori(List<Consumer> consumers){
        fac = new Factory();
        for(Consumer x : consumers) {
            Consumator c = new Consumator(x.getId(), x.getInitialBudget(), x.getMonthlyIncome());
            cons.add(c);
            mapCons.put(x.getId(), c);
        }
    }
    public Consumator getById(Integer x){
        return mapCons.get(x);
    }
    public List<Consumator> retList(){
        return cons;
    }

    public void updateBudget(){
        for(Consumator consumator : cons){
            consumator.increaseBudget();
        }
    }
    public void printConsumatoriStatus(){
        for(Consumator con : cons){
            System.out.println(con.getId() + " " + con.getBudget() + " " + con.faliment);
        }
    }
    public void addConsumatori(List<Consumer> consumers){
        for(Consumer x : consumers) {
            Consumator c = new Consumator(x.getId(), x.getInitialBudget(), x.getMonthlyIncome());
            cons.add(c);
            mapCons.put(x.getId(), c);
        }
    }
}
