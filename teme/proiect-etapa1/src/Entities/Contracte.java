package Entities;

import java.util.ArrayList;
import java.util.List;

public class Contracte {
    List<Contract> contracte = new ArrayList<>();
    public void addContract(Consumator consumator, Distribuitor distribuitor){
        Contract x = new Contract(consumator, distribuitor);
            contracte.add(x);
            distribuitor.addContract(x);

    }
  public void  MonthlyUpdate(){
        for(Contract contract : contracte){
            contract.UpdateContract();
        }
  }
}
