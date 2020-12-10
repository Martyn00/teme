package Input;

import java.util.ArrayList;
import java.util.List;

public class Data {
    private int numberOfTurns;
    private InitialData initialData;
    private final List<MonthlyUpdates> monthlyUpdates = new ArrayList<>();
    public int getNumberOfTurns() {
        return numberOfTurns;
    }

    public void setNumberOfTurns(int numberOfTurns) {
        this.numberOfTurns = numberOfTurns;
    }

    public Data() {
        this.numberOfTurns = 0;
        this.initialData = new InitialData();
    }

    public InitialData getInitialData() {
        return initialData;
    }

    public void setInitialData(InitialData initialData) {
        this.initialData = initialData;
    }

    public List<MonthlyUpdates> getMonthlyUpdates() {
        return monthlyUpdates;
    }
}
