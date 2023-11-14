package christmas.domain.discount;

import christmas.domain.date.EventDate;
import christmas.domain.order.Order;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Discount {
    private final ChristmasDiscount christmasDiscount;
    private final DayDiscount dayDiscount;
    private final SpecialDiscount specialDiscount;

    public Discount(List<Order> orders, EventDate eventDate) {
        christmasDiscount = new ChristmasDiscount(eventDate);
        dayDiscount = new DayDiscount(orders, eventDate);
        specialDiscount = new SpecialDiscount(eventDate);
    }

    public Map<String, Integer> getTotalDiscount() {
        Map<String, Integer> totalDiscount = new HashMap<>();
        return totalDiscount;
    }
}
