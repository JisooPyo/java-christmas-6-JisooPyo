package christmas.domain.discount;

import christmas.domain.date.EventDate;

public class SpecialDiscount {
    private final EventDate eventDate;

    public SpecialDiscount(EventDate eventDate) {
        this.eventDate = eventDate;
    }

    public int getDiscount() {
        int date = eventDate.getEventDate();
        if (date % 7 == 3 || date == 25) {
            return 1000;
        }
        return 0;
    }
}
