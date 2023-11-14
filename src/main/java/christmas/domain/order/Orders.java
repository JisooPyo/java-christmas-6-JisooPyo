package christmas.domain.order;

import christmas.domain.badge.Badge;
import christmas.domain.benefit.Benefit;
import christmas.domain.benefit.Gift;
import christmas.domain.date.EventDate;
import christmas.domain.menu.DrinkMenu;
import christmas.error.CustomError;

import java.util.*;

public class Orders {
    private final List<Order> orders;
    private final EventDate eventDate;
    private final Benefit benefit;
    private final Gift gift;

    public Orders(String orderInput, EventDate eventDate) {
        this.eventDate = eventDate;
        this.orders = order(orderInput);
        validate(orders);
        this.benefit = new Benefit(orders, eventDate);
        this.gift = getGift();
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
        if (count > 20) {
            throw new IllegalArgumentException(CustomError.AVAILABLE_MAX_TWENTY.getMessage());
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

    public Map<String, Integer> getBenefits() {
        return benefit.getBenefits();
    }

    public EventDate getEventDate() {
        return eventDate;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public Gift getGift() {
        return new Gift(getOrderCost());
    }

    public int getOrderCost() {
        int orderCost = 0;
        for (Order order : orders) {
            orderCost += order.getMenu().getCost() * order.getCount();
        }
        return orderCost;
    }

    public int getTotalBenefitCost() {
        return benefit.getBenefitsAmount() + gift.getCost();
    }

    public String getBadge() {
        Badge badge = new Badge(getTotalBenefitCost());
        return badge.getBadge();
    }

    public int getExpectedPayCost() {
        return getOrderCost() - benefit.getBenefitsAmount();
    }

}
