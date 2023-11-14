package christmas.domain.menu.menuEnum;

public enum DessertEnum {
    CHOCOLATE_CAKE("초코케이크", 15000),
    ICE_CREAM("아이스크림", 5000);
    private final String name;
    private final int cost;

    DessertEnum(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }
}
