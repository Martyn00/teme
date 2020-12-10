package Input;

import java.util.ArrayList;
import java.util.List;

public class InitialData {
    private final List<Consumer> consumerInitials = new ArrayList<>();
    private final List<Distributor> distributors = new ArrayList<>();

    public List<Consumer> getConsumers() {
        return consumerInitials;
    }

    public List<Distributor> getDistributors() {
        return distributors;
    }

}
