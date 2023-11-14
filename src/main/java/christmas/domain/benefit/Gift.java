package christmas.domain.benefit;

public class Gift {
    private int totalCost;
    private String name;
    private Integer cost;

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
