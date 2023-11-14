package christmas.domain.benefit;

import christmas.domain.date.EventDate;
import christmas.domain.discount.Discount;
import christmas.domain.order.Order;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Benefit {
    private final List<Order> orders;
    private final EventDate eventDate;

    public Benefit(List<Order> orders, EventDate eventDate) {
        this.orders = orders;
        this.eventDate = eventDate;
    }

    public Map<String, Integer> getBenefits() {
        Map<String, Integer> benefits = new HashMap<>();
        int orderCost = getOrderCost(orders);
        if (orderCost < 10000) {
            benefits.put("없음", 0);
            return benefits;
        }
        addDiscount(benefits);
        return benefits;
    }

    private int getOrderCost(List<Order> orders) {
        int cost = 0;
        for (Order order : orders) {
            cost += order.getMenu().getCost();
        }
        return cost;
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

}
