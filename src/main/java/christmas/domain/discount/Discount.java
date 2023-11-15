package christmas.domain.discount;

import christmas.domain.date.EventDate;
import christmas.domain.order.Order;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Discount {
    private final Map<String, Integer> allDiscount;
    private final List<Order> orders;
    private final EventDate eventDate;

    public Discount(List<Order> orders, EventDate eventDate) {
        this.orders = orders;
        this.eventDate = eventDate;
        this.allDiscount = addDiscounts();
    }

    public Map<String, Integer> getTotalDiscount() {
        return Collections.unmodifiableMap(allDiscount);
    }

    public Map<String, Integer> addDiscounts() {
        Map<String, Integer> discounts = new HashMap<>();
        if (!isMoreThanTenThousand()) {
            return discounts;
        }
        addChristmasDiscount(discounts);
        addDayDiscount(discounts);
        addSpecialDiscount(discounts);
        return discounts;
    }

    private boolean isMoreThanTenThousand() {
        int cost = 0;
        for (Order order : orders) {
            cost += order.getMenu().getCost() * order.getCount();
        }
        return cost >= 10000;
    }

    private void addChristmasDiscount(Map<String, Integer> totalDiscount) {
        ChristmasDiscount christmasDiscount = new ChristmasDiscount(eventDate);
        int discount = christmasDiscount.getDiscount();
        if (discount != 0) {
            totalDiscount.put("크리스마스 디데이 할인", discount);
        }
    }

    private void addDayDiscount(Map<String, Integer> totalDiscount) {
        DayDiscount dayDiscount = new DayDiscount(orders, eventDate);
        String day = "";
        int discount = 0;
        for (String key : dayDiscount.getDiscount().keySet()) {
            day = key;
            discount = dayDiscount.getDiscount().get(key);
        }
        totalDiscount.put(day, discount);
    }

    private void addSpecialDiscount(Map<String, Integer> totalDiscount) {
        SpecialDiscount specialDiscount = new SpecialDiscount(eventDate);
        int discount = specialDiscount.getDiscount();
        if (discount != 0) {
            totalDiscount.put("특별 할인", discount);
        }
    }

    public int getTotalDiscountPrice() {
        int price = 0;
        for (String key : allDiscount.keySet()) {
            price += allDiscount.get(key);
        }
        return price;
    }

}
