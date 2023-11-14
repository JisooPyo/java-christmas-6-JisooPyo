package christmas.domain.benefit;

import christmas.domain.date.EventDate;
import christmas.domain.discount.Discount;
import christmas.domain.order.Order;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Benefit {
    private final Map<String, Integer> benefits;
    private final Gift gift;
    private final Discount discount;

    public Benefit(List<Order> orders, int totalCost, EventDate eventDate) {
        this.gift = new Gift(totalCost);
        this.discount = new Discount(orders, eventDate);
        this.benefits = getBenefits(orders, totalCost);
    }

    private Map<String, Integer> getBenefits(List<Order> orders, int totalCost) {
        Map<String, Integer> benefits = new HashMap<>();
        if (totalCost < 10000) {
            benefits.put("없음", 0);
            return benefits;
        }

    }

    public int getTotalBenefits() {
        int totalBenefits = 0;
        for (Integer price : benefits.values()) {
            totalBenefits += price;
        }
        return totalBenefits;
    }
}
