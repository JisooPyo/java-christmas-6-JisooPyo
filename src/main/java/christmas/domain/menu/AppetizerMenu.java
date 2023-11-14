package christmas.domain.menu;

import christmas.domain.menu.menuEnum.AppetizerEnum;

import java.util.HashMap;
import java.util.Map;

public class AppetizerMenu {
    private final Map<String, Integer> appetizers;

    public AppetizerMenu() {
        this.appetizers = addAppetizers();
    }

    private Map<String, Integer> addAppetizers() {
        Map<String, Integer> appetizers = new HashMap<>();
        for (AppetizerEnum appetizer : AppetizerEnum.values()) {
            appetizers.put(appetizer.getName(), appetizer.getCost());
        }
        return appetizers;
    }

    public boolean existsMenu(String menuName) {
        return appetizers.containsKey(menuName);
    }

    public int getMenuCost(String menuName) {
        return appetizers.get(menuName);
    }
}
