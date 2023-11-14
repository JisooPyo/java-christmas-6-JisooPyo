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
    }

    private List<Order> order(String orderInput) {
        String[] checkOrders = orderInput.split(",");
        validateLength(checkOrders);
        List<Order> checkedOrders = new ArrayList<>();
        for (int i = 0; i < checkOrders.length; i++) {
            Order order = new Order(checkOrders[i]);
            checkedOrders.add(order);
        }
        return checkedOrders;
    }

    private void validateLength(String[] checkOrders) {
        if (checkOrders.length >= 21) {
            throw new IllegalArgumentException(CustomError.AVAILABLE_MAX_TWENTY.getMessage());
        }
    }

}
