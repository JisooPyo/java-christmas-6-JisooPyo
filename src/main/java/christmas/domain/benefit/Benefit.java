package christmas.domain.benefit;

import christmas.domain.date.EventDate;
import christmas.domain.discount.Discount;
import christmas.domain.order.Order;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Benefit {
    private final List<Order> orders;
    private final int totalCost;
    private final EventDate eventDate;

    public Benefit(List<Order> orders, int totalCost, EventDate eventDate) {
        this.orders = orders;
        this.totalCost = totalCost;
        this.eventDate = eventDate;
    }

    public Map<String, Integer> getBenefits() {
        Map<String, Integer> benefits = new HashMap<>();
        if (totalCost < 10000) {
            benefits.put("없음", 0);
            return benefits;
        }
        addDiscount(benefits);
        addGift(benefits);
        return benefits;
    }

    public int getBenefitsAmount() {
        int totalBenefitAmount = 0;
        for (String key : getBenefits().keySet()) {
            totalBenefitAmount += getBenefits().get(key);
        }
        return totalBenefitAmount;
    }

    private void addDiscount(Map<String, Integer> benefits) {
        Discount discount = new Discount(orders, eventDate);
        for (String key : discount.getTotalDiscount().keySet()) {
            benefits.put(key, discount.getTotalDiscount().get(key));
        }
    }

    private void addGift(Map<String, Integer> benefits) {
        Gift gift = new Gift(totalCost).getGift();
        if (gift.getCost() != 0) {
            benefits.put(gift.getName(), gift.getCost());
        }
    }

}
