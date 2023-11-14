package christmas.domain.badge;

public enum BadgeEnum {
    STAR("별"),
    TREE("트리"),
    SANTA("산타");

    private final String name;

    BadgeEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
