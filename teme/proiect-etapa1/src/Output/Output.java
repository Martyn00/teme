package Output;

import Entities.Consumator;
import Entities.Distribuitor;

import java.util.ArrayList;
import java.util.List;

public class Output {
    private List<ConsumersOutput> consumers = new ArrayList<>();
    private List<DistsributersOutput> distributors = new ArrayList<>();

    public Output(List<Consumator> consumers, List<Distribuitor> distribuitors) {
        for (Consumator consumator : consumers) {
            this.consumers.add(new ConsumersOutput(consumator));
        }
        for (Distribuitor distribuitor : distribuitors) {
            this.distributors.add(new DistsributersOutput(distribuitor));
        }
    }

    public List<ConsumersOutput> getConsumers() {
        return consumers;
    }

    public void setConsumers(List<ConsumersOutput> consumers) {
        this.consumers = consumers;
    }

    public List<DistsributersOutput> getDistributors() {
        return distributors;
    }

    public void setDistributors(List<DistsributersOutput> distributors) {
        this.distributors = distributors;
    }
}
