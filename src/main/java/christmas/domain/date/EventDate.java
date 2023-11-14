package christmas.domain.date;

import christmas.error.CustomError;

import java.util.regex.Pattern;

public class EventDate {
    private final int date;

    public EventDate(String date) {
        validate(date);
        this.date = Integer.parseInt(date);
    }

    private void validate(String date) {
        consistsOfNumber(date);
        checkFormat(date);
        checkValidDate(date);
    }

    private void consistsOfNumber(String date) {
        if (!Pattern.matches("^[0-9]+$", date)) {
            throw new IllegalArgumentException(CustomError.INVALID_DATE.getMessage());
        }
    }

    private void checkFormat(String date) {
        try {
            Integer.parseInt(date);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(CustomError.INVALID_DATE.getMessage());
        }
    }

    private void checkValidDate(String date) {
        int check = Integer.parseInt(date);
        if (!(1 <= check && check <= 31)) {
            throw new IllegalArgumentException(CustomError.INVALID_DATE.getMessage());
        }
    }

    public int getDate() {
        return date;
    }
}
