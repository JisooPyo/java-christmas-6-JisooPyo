package christmas.domain.badge;

public enum BadgeEnum {
    STAR("별", 5000),
    TREE("트리", 10000),
    SANTA("산타", 20000);

    private final String name;
    private final int basis;

    BadgeEnum(String name, int basis) {
        this.name = name;
        this.basis = basis;
    }

    public String getName() {
        return name;
    }

    public int getBasis() {
        return basis;
    }
}
