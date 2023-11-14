package christmas.domain.gift;

public class Gift {
    private int totalCost;

    public Gift(int totalCost) {
        this.totalCost = totalCost;
    }

    public String getName() {
        if (totalCost >= 120000) {
            return "샴페인 1개";
        }
        return "없음";
    }

    public int getCost() {
        if (totalCost >= 120000) {
            return 25000;
        }
        return 0;
    }
}
