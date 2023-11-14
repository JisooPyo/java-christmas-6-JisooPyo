package christmas.domain.menu;

import christmas.domain.menu.menuEnum.MainEnum;

import java.util.HashMap;
import java.util.Map;

public class MainMenu {
    private final Map<String, Integer> mains;

    public MainMenu() {
        this.mains = addMains();
    }

    private Map<String, Integer> addMains() {
        Map<String, Integer> mains = new HashMap<>();
        for (MainEnum main : MainEnum.values()) {
            mains.put(main.getName(), main.getCost());
        }
        return mains;
    }

    public boolean existsMenu(String menuName) {
        return mains.containsKey(menuName);
    }

    public int getMenuCost(String menuName) {
        return mains.get(menuName);
    }
}
