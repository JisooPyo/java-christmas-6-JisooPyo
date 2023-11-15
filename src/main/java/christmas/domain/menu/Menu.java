package christmas.domain.menu;

import christmas.error.CustomError;

public class Menu {
    private final String name;
    private final TypeEnum type;
    private final int cost;

    public Menu(String name) {
        MenuEnum menuEnum = findMenu(name);
        this.name = menuEnum.getName();
        this.type = menuEnum.getType();
        this.cost = menuEnum.getCost();
    }

    private MenuEnum findMenu(String name) {
        MenuEnum menuEnum = MenuEnum.getMenuEnum(name);
        if (menuEnum == null) {
            throw new IllegalArgumentException(CustomError.INVALID_ORDER.getMessage());
        }
        return menuEnum;
    }

    public String getName() {
        return name;
    }

    public TypeEnum getType() {
        return type;
    }

    public int getCost() {
        return cost;
    }
}
