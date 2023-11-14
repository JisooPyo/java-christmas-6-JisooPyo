package christmas.domain.discount;

import christmas.domain.date.EventDate;
import christmas.domain.order.Order;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Discount {
    private final List<Order> orders;
    private final EventDate eventDate;

    public Discount(List<Order> orders, EventDate eventDate) {
        this.orders = orders;
        this.eventDate = eventDate;
    }

    public Map<String, Integer> getTotalDiscount() {
        Map<String, Integer> totalDiscount = new HashMap<>();
        addChristmasDiscount(totalDiscount);
        addDayDiscount(totalDiscount);
        addSpecialDiscount(totalDiscount);
        return totalDiscount;
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

}
