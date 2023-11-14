package christmas.domain.menu;

import christmas.domain.menu.menuEnum.DessertEnum;

import java.util.HashMap;
import java.util.Map;

public class DessertMenu {
    private final Map<String, Integer> desserts;

    public DessertMenu() {
        this.desserts = addDesserts();
    }

    private Map<String, Integer> addDesserts() {
        Map<String, Integer> desserts = new HashMap<>();
        for (DessertEnum dessert : DessertEnum.values()) {
            desserts.put(dessert.getName(), dessert.getCost());
        }
        return desserts;
    }

    public boolean existsMenu(String menuName) {
        return desserts.containsKey(menuName);
    }

    public int getMenuCost(String menuName) {
        return desserts.get(menuName);
    }
}
