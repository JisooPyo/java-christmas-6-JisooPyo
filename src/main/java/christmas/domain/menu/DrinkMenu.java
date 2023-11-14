package christmas.domain.menu;

import christmas.domain.menu.menuEnum.DrinkEnum;

import java.util.HashMap;
import java.util.Map;

public class DrinkMenu {
    private final Map<String, Integer> drinks;

    public DrinkMenu() {
        this.drinks = addDrinks();
    }

    private Map<String, Integer> addDrinks() {
        Map<String, Integer> drinks = new HashMap<>();
        for (DrinkEnum drink : DrinkEnum.values()) {
            drinks.put(drink.getName(), drink.getCost());
        }
        return drinks;
    }

    public boolean existsMenu(String menuName) {
        return drinks.containsKey(menuName);
    }

    public int getMenuCost(String menuName) {
        return drinks.get(menuName);
    }
}
