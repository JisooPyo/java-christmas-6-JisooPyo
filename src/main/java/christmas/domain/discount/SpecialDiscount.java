package christmas.domain.discount;

import christmas.domain.date.EventDate;

public class SpecialDiscount {
    private final EventDate eventDate;
    private final int discountAmount = 1000;

    public SpecialDiscount(EventDate eventDate) {
        this.eventDate = eventDate;
    }

    public int getDiscount() {
        if (eventDate.withinSpecialDiscountRange()) {
            return discountAmount;
        }
        return 0;
    }
}
