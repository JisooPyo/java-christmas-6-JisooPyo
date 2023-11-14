package christmas.domain.order;

import christmas.domain.date.EventDate;
import christmas.error.CustomError;

import java.util.ArrayList;
import java.util.List;

public class Orders {
    private final List<Order> orders;
    private final EventDate eventDate;

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
        if (count > 20) {
            throw new IllegalArgumentException(CustomError.INVALID_ORDER.getMessage());
        }
    }

    private void checkDuplicateMenu(List<Order> orders) {

    }

    private void checkOnlyDrinks(List<Order> orders) {
    }

}
