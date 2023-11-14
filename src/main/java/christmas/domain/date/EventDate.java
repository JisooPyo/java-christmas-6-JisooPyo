package christmas.domain.date;

public class EventDate {
    private final int eventDate;

    public EventDate(String date) {
        validate(date);
        this.eventDate = Integer.parseInt(date);
    }
}
