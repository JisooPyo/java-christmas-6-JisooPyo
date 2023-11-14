package christmas.domain.order;

import christmas.domain.menu.Menu;
import christmas.error.CustomError;

import java.util.regex.Pattern;

public class Order {
    private final Menu menu;

    private final int count;

    public Order(String order) {
        validate(order);
        this.menu = findMenu(order);
        this.count = findCount(order);
    }

    private void validate(String order) {
        if (!Pattern.matches("^[가-힣]+-[0-9]+$", order)) {
            throw new IllegalArgumentException(CustomError.INVALID_ORDER.getMessage());
        }
    }

    private Menu findMenu(String order) {
        int seperationIndex = order.indexOf("-");
        String checkMenu = order.substring(0, seperationIndex);
        return new Menu(checkMenu);
    }

    private int findCount(String order) {
        int seperationIndex = order.indexOf("-");
        String checkCount = order.substring(seperationIndex + 1);
        if (Integer.parseInt(checkCount) < 1) {
            throw new IllegalArgumentException(CustomError.INVALID_ORDER.getMessage());
        }
        return Integer.parseInt(checkCount);
    }

    public int getCount() {
        return this.count;
    }
}
