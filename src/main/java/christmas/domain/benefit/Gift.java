package christmas.domain.benefit;

import java.util.Map;

public class Gift {
    private int totalCost;
    private String name;
    private Integer cost;

    public Gift(int totalCost) {
        this.totalCost = totalCost;
    }

    public Gift(String name, Integer cost) {
        this.name = name;
        this.cost = cost;
    }

    public Gift getGift() {
        if (totalCost >= 120000) {
            return new Gift("샴페인 1개", 25000);
        }
        return new Gift("없음", 0);
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }
}
