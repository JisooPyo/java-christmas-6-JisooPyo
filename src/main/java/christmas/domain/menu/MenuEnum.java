package christmas.domain.menu;

import java.util.Arrays;

public enum MenuEnum {
    MUSHROOM_SOUP("양송이수프", TypeEnum.APPETIZER, 6000),
    TAPAS("타파스", TypeEnum.APPETIZER, 5500),
    CAESAR_SALAD("시저샐러드", TypeEnum.APPETIZER, 8000),
    T_BONE_STEAK("티본스테이크", TypeEnum.MAIN, 55000),
    BARBECUED_RIBS("바비큐립", TypeEnum.MAIN, 54000),
    SEAFOOD_PASTA("해산물파스타", TypeEnum.MAIN, 35000),
    CHRISTMAS_PASTA("크리스마스파스타", TypeEnum.MAIN, 25000),
    CHOCOLATE_CAKE("초코케이크", TypeEnum.DESSERT, 15000),
    ICE_CREAM("아이스크림", TypeEnum.DESSERT, 5000),
    ZERO_COKE("제로콜라", TypeEnum.DRINK, 3000),
    RED_WINE("레드와인", TypeEnum.DRINK, 60000),
    CHAMPAGNE("샴페인", TypeEnum.DRINK, 25000);
    private final String name;
    private final TypeEnum type;
    private final int cost;

    MenuEnum(String name, TypeEnum type, int cost) {
        this.name = name;
        this.type = type;
        this.cost = cost;
    }

    public static MenuEnum getMenuEnum(String name) {
        for (MenuEnum menuEnum : MenuEnum.values()) {
            if (menuEnum.name.equals(name)) {
                return menuEnum;
            }
        }
        return null;
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
