package christmas.domain.benefit;

public class Gift {
    private String name;
    private int cost;

    public Gift(int totalCost) {
        this.name = "없음";
        this.cost = 0;

        checkTotalCost(totalCost);
    }

    private void checkTotalCost(int totalCost) {
        if (totalCost >= 120_000) {
            this.name = "샴페인 1개";
            this.cost = 25000;
        }
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }
}
