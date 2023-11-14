package christmas.domain.discount;

import christmas.domain.date.EventDate;
import christmas.domain.menu.DessertMenu;
import christmas.domain.menu.MainMenu;
import christmas.domain.order.Order;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DayDiscount {
    private final List<Order> orders;
    private final EventDate eventDate;

    public DayDiscount(List<Order> orders, EventDate eventDate) {
        this.orders = orders;
        this.eventDate = eventDate;
    }

    public Map<String, Integer> getDiscount() {
        Map<String, Integer> dayDiscount = new HashMap<>();
        int date = eventDate.getEventDate();
        if (date % 7 == 1 || date % 7 == 2) {
            dayDiscount.put("주말 할인", getWeekendDiscount());
            return dayDiscount;
        }
        dayDiscount.put("평일 할인", getWeekdayDiscount());
        return dayDiscount;
    }

    private int getWeekendDiscount() {
        MainMenu mainMenu = new MainMenu();
        int discount = 0;
        for (Order order : orders) {
            if (mainMenu.existsMenu(order.getMenu().getName())) {
                discount += order.getCount() * 2023;
            }
        }
        return discount;
    }

    private int getWeekdayDiscount() {
        DessertMenu dessertMenu = new DessertMenu();
        int discount = 0;
        for (Order order : orders) {
            if (dessertMenu.existsMenu(order.getMenu().getName())) {
                discount += order.getCount() * 2023;
            }
        }
        return discount;
    }
}
