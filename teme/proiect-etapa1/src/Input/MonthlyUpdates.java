package Input;

import java.util.ArrayList;
import java.util.List;

public class MonthlyUpdates {
    private List<CostChanges> costsChanges = new ArrayList<>();
    private List<Consumer> newConsumers = new ArrayList<>();

    public List<CostChanges> getCostsChanges() {
        return costsChanges;
    }

    public void setCostsChanges(List<CostChanges> costsChanges) {
        this.costsChanges = costsChanges;
    }

    public List<Consumer> getNewConsumers() {
        return newConsumers;
    }

    public void setNewConsumers(List<Consumer> newConsumers) {
        this.newConsumers = newConsumers;
    }
}
