package christmas.domain.order;

import christmas.domain.menu.Menu;

public class Order {
    private final Menu menu;

    private final int count;

    public Order(String menu, int count) {
        validate(menu);
        this.menu = findMenu(menu);
        this.count = count;
    }

    private void validate(String menu) {
    }

    private Menu findMenu(String menu) {
        return null;
    }
}
