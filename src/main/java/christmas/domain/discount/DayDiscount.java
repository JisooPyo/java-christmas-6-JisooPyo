package christmas.domain.discount;

import christmas.domain.date.EventDate;
import christmas.domain.menu.TypeEnum;
import christmas.domain.order.Order;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DayDiscount {
    private final List<Order> orders;
    private final EventDate eventDate;
    private final int discountAmount = 2023;

    public DayDiscount(List<Order> orders, EventDate eventDate) {
        this.orders = orders;
        this.eventDate = eventDate;
    }

    public Map<String, Integer> getDiscount() {
        Map<String, Integer> dayDiscount = new HashMap<>();
        int date = eventDate.getDate();
        if ((date % 7 == 1 || date % 7 == 2) && getWeekendDiscount() != 0) {
            dayDiscount.put("주말 할인", getWeekendDiscount());
            return dayDiscount;
        }
        if (getWeekdayDiscount() != 0) {
            dayDiscount.put("평일 할인", getWeekdayDiscount());
        }
        return dayDiscount;
    }

    private int getWeekendDiscount() {
        int discount = 0;
        for (Order order : orders) {
            if (order.getMenu().getType().equals(TypeEnum.MAIN)) {
                discount += order.getCount() * discountAmount;
            }
        }
        return discount;
    }

    private int getWeekdayDiscount() {
        int discount = 0;
        for (Order order : orders) {
            if (order.getMenu().getType().equals(TypeEnum.DESSERT)) {
                discount += order.getCount() * discountAmount;
            }
        }
        return discount;
    }
}
