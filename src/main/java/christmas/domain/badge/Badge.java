package christmas.domain.badge;

public class Badge {
    private final int benefitAmount;

    public Badge(int benefitAmount) {
        this.benefitAmount = benefitAmount;
    }

    public String getName() {
        if (benefitAmount >= 20000) {
            return BadgeEnum.SANTA.getName();
        }
        if (benefitAmount >= 10000) {
            return BadgeEnum.TREE.getName();
        }
        if (benefitAmount >= 5000) {
            return BadgeEnum.STAR.getName();
        }
        return "없음";
    }

}
