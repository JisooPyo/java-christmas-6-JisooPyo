package christmas.domain.order;

import christmas.domain.badge.Badge;
import christmas.domain.date.EventDate;
import christmas.domain.discount.Discount;
import christmas.domain.gift.Gift;
import christmas.domain.menu.TypeEnum;
import christmas.error.CustomError;

import java.util.*;

public class Orders {
    private final List<Order> orders;
    private final EventDate eventDate;
    private final Discount discount;
    private final int maxOrder = 20;
    private final Gift gift;
    private final Badge badge;

    public Orders(String orderInput, EventDate eventDate) {
        this.eventDate = eventDate;
        this.orders = order(orderInput);
        validate(orders);
        this.discount = new Discount(orders, eventDate);
        this.gift = new Gift(getOrdersCost());
        this.badge = new Badge(getTotalBenefitCost());
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
        for (Order order : orders) {
            if (!(order.getMenu().getType().equals(TypeEnum.DRINK))) {
                return;
            }
        }
        throw new IllegalArgumentException(CustomError.MUST_ADD_NON_DRINK.getMessage());
    }

    public int getOrdersCost() {
        int ordersCost = 0;
        for (Order order : orders) {
            ordersCost += order.getCost();
        }
        return ordersCost;
    }

    public Map<String, Integer> getDiscount() {
        return discount.getTotalDiscount();
    }

    public String getGift() {
        return gift.getName();
    }

    public int getGiftPrice() {
        return gift.getCost();
    }

    public int getTotalBenefitCost() {
        return getAllDiscountCost() + getGiftPrice();
    }

    public int getExpectedPayCost() {
        return getOrdersCost() - getAllDiscountCost();
    }

    public String getBadge() {
        return badge.getName();
    }

    private int getAllDiscountCost() {
        return discount.getTotalDiscountPrice();
    }

    public EventDate getEventDate() {
        return eventDate;
    }

    public List<Order> getOrders() {
        return Collections.unmodifiableList(orders);
    }
}
