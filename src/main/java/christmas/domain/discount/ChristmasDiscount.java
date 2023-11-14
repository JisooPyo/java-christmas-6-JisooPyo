package christmas.domain.discount;

import christmas.domain.date.EventDate;

public class ChristmasDiscount {
    private final EventDate eventDate;

    public ChristmasDiscount(EventDate eventDate) {
        this.eventDate = eventDate;
    }

    public int getDiscount() {
        int date = eventDate.getDate();
        if (1 <= date && date <= 25) {
            return 1000 + ((date - 1) * 100);
        }
        return 0;
    }
}
