package christmas.domain.discount;

import christmas.domain.date.EventDate;

public class ChristmasDiscount {
    private final EventDate eventDate;
    private final int startDiscount = 1000;
    private final int dayDiscount = 100;

    public ChristmasDiscount(EventDate eventDate) {
        this.eventDate = eventDate;
    }

    public int getDiscount() {
        if (eventDate.withinChristmasDiscountRange()) {
            return startDiscount + ((eventDate.getDate() - 1) * dayDiscount);
        }
        return 0;
    }
}
