package christmas.domain.menu.menuEnum;

public enum MainEnum {
    T_BONE_STEAK("티본스테이크", 55000),
    BARBECUED_RIBS("바비큐립", 54000),
    SEAFOOD_PASTA("해산물파스타", 35000),
    CHRISTMAS_PASTA("크리스마스파스타", 25000);
    private final String name;
    private final int cost;

    MainEnum(String name, int cost) {
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
