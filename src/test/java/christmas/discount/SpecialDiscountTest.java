package christmas.discount;

import christmas.domain.date.EventDate;
import christmas.domain.discount.SpecialDiscount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SpecialDiscountTest {
    @DisplayName("특별 할인 테스트 - 별이 있는 날짜")
    @ParameterizedTest
    @ValueSource(strings = {"3", "10", "17", "24", "25", "31"})
    void gitDiscountTest1(String date) {
        EventDate eventDate = new EventDate(date);
        SpecialDiscount specialDiscount = new SpecialDiscount(eventDate);

        assertEquals(1000, specialDiscount.getDiscount());
    }

    @DisplayName("특별 할인 테스트 - 별이 없는 날짜")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "4", "5", "6", "7", "8", "9", "11",
            "12", "13", "14", "15", "16", "18", "19", "20", "21", "22",
            "23", "26", "27", "28", "29", "30"})
    void gitDiscountTest2(String date) {
        EventDate eventDate = new EventDate(date);
        SpecialDiscount specialDiscount = new SpecialDiscount(eventDate);

        assertEquals(0, specialDiscount.getDiscount());
    }
}
