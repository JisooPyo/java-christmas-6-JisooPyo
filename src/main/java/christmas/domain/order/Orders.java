package christmas.domain.order;

import christmas.domain.badge.Badge;
import christmas.domain.date.EventDate;
import christmas.domain.discount.Discount;
import christmas.domain.gift.Gift;
import christmas.domain.menu.DrinkMenu;
import christmas.error.CustomError;

import java.util.*;

public class Orders {
    private final List<Order> orders;
    private final EventDate eventDate;
    private final int maxOrder = 20;

    public Orders(String orderInput, EventDate eventDate) {
        this.eventDate = eventDate;
        this.orders = order(orderInput);
        validate(orders);
    }

    private List<Order> order(String orderInput) {
        String[] checkOrders = orderInput.split(",");
        List<Order> checkedOrders = new ArrayList<>();
        for (int i = 0; i < checkOrders.length; i++) {
            Order order = new Order(checkOrders[i]);
            checkedOrders.add(order);
        }
        return checkedOrders;
    }

    private void validate(List<Order> orders) {
        checkTotalCount(orders);
        checkDuplicateMenu(orders);
        checkOnlyDrinks(orders);
    }

    private void checkTotalCount(List<Order> orders) {
        int count = 0;
        for (Order order : orders) {
            count += order.getCount();
        }
        if (count > maxOrder) {
            throw new IllegalArgumentException(CustomError.EXCEED_MAXIMUM_ORDER.getMessage());
        }
    }

    private void checkDuplicateMenu(List<Order> orders) {
        Set<String> menus = new HashSet<>();
        for (Order order : orders) {
            menus.add(order.getMenu().getName());
        }
        if (menus.size() != orders.size()) {
            throw new IllegalArgumentException(CustomError.INVALID_ORDER.getMessage());
        }
    }

    private void checkOnlyDrinks(List<Order> orders) {
        DrinkMenu drinkMenu = new DrinkMenu();
        for (Order order : orders) {
            if (!drinkMenu.existsMenu(order.getMenu().getName())) {
                return;
            }
        }
        throw new IllegalArgumentException(CustomError.MUST_ADD_NON_DRINK.getMessage());
    }

    public EventDate getEventDate() {
        return eventDate;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public int getOrderCost() {
        int orderCost = 0;
        for (Order order : orders) {
            orderCost += order.getMenu().getCost() * order.getCount();
        }
        return orderCost;
    }

    public String getGift() {
        Gift gift = new Gift(getOrderCost());
        return gift.getName();
    }

    public Map<String, Integer> getDiscount() {
        Discount discount = new Discount(orders, eventDate);
        return discount.getTotalDiscount();
    }

    public int getGiftPrice() {
        Gift gift = new Gift(getOrderCost());
        return gift.getCost();
    }

    public int getTotalBenefitCost() {
        return getAllDiscountCost() + getGiftPrice();
    }

    public int getExpectedPayCost() {
        return getOrderCost() - getAllDiscountCost();
    }

    public String getBadge() {
        Badge badge = new Badge(getTotalBenefitCost());
        return badge.getName();
    }

    private int getAllDiscountCost() {
        int allDiscount = 0;
        for (String key : getDiscount().keySet()) {
            allDiscount += getDiscount().get(key);
        }
        return allDiscount;
    }
}
