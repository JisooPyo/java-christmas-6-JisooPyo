package christmas.domain.badge;

public class Badge {
    private final int benefitAmount;

    public Badge(int benefitAmount) {
        this.benefitAmount = benefitAmount;
    }

    public String getName() {
        if (benefitAmount >= BadgeEnum.SANTA.getBasis()) {
            return BadgeEnum.SANTA.getName();
        }
        if (benefitAmount >= BadgeEnum.TREE.getBasis()) {
            return BadgeEnum.TREE.getName();
        }
        if (benefitAmount >= BadgeEnum.STAR.getBasis()) {
            return BadgeEnum.STAR.getName();
        }
        return "없음";
    }

}
