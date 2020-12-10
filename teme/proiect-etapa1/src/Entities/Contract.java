package Entities;

public class Contract {
    private Consumator consumator;
    private Distribuitor distribuitor;
    public int monthsDone;
    public int monthstoDo;
    public int costConsumator;
    boolean restanta;
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
                System.out.println(consumator.getBudget());
//                System.out.println("Se termina ma???");
                money = consumator.PayCost((int) (1.2 * costConsumator));
                distribuitor.getMoney(money);
                System.out.println("a platit" + money);
                if(money == 0){
                    consumator.faliment = true;
                }
            }else{
                money = consumator.PayCost((int) (2.2 * costConsumator));
                System.out.println("a platit" + money);
                distribuitor.getMoney(money);
                if(money == 0){
                    consumator.faliment = true;
                    return true;
                }
            }
        }
        money = consumator.PayCost((int) (costConsumator));
        distribuitor.getMoney(money);
        System.out.println("a platit" + money);
        if(monthsDone == monthstoDo){
//            System.out.println("Se termina ma???");
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
