package Entities;

public class Contract {
    private Consumator consumator;
    private Distribuitor distribuitor;
    public int monthsDone;
    public int monthstoDo;
    public int costConsumator;
    public boolean restanta;
    public Contract(Consumator consumator,  Distribuitor distribuitor){
        this.consumator = consumator;
        this.distribuitor = distribuitor;
        this.costConsumator = distribuitor.getPretfinalContract();
        this.monthsDone = 0;
        this.monthstoDo = distribuitor.getContractLength();
        this.restanta = false;
        distribuitor.addConsumer();
    }
//    aici trebuie sa plateasca banii si sa ii primeasca distribuitorul
    public boolean UpdateContract(){
        int money;
        monthsDone++;
        if(restanta){
            if(monthsDone == monthstoDo - 1){
                money = consumator.PayCost((int) (2.2 * costConsumator));
                distribuitor.getMoney(money);
                System.out.println(consumator.getId()+"s-a platit" + money +" " +monthsDone + " " + monthstoDo);
                if(money == 0){
                    consumator.faliment = true;
                    return true;
                }
                return false;
            }else{
                money = consumator.PayCost((int) (2.2 * costConsumator));
                System.out.println(consumator.getId()+" a platit" + money);
                distribuitor.getMoney(money);
                if(money == 0){
                    consumator.faliment = true;
                    return true;
                }
                return false;
            }
        }
        money = consumator.PayCost((int) (costConsumator));
        distribuitor.getMoney(money);
        System.out.println(consumator.getId()+" a platit" + money);
        System.out.println(consumator.getBudget());
//        aici e posibila o greseala
        if(monthsDone == monthstoDo - 1){
//            fix aici e problema, daca capata restanta on ultima tura...
            if(money == 0){
                restanta = true;
                return false;
            }
            return true;
        }else{
            if(money == 0){
                restanta = true;
            }
            return false;
        }
    }

    public Consumator getConsumator() {
        return consumator;
    }

    public void setConsumator(Consumator consumator) {
        this.consumator = consumator;
    }

    public Distribuitor getDistribuitor() {
        return distribuitor;
    }

    public void setDistribuitor(Distribuitor distribuitor) {
        this.distribuitor = distribuitor;
    }
}
