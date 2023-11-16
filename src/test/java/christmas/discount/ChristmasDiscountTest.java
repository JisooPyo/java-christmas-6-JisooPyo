package christmas.discount;

import christmas.domain.date.EventDate;
import christmas.domain.discount.ChristmasDiscount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChristmasDiscountTest {
    @DisplayName("1일부터 25일까지 1000원부터 100원씩 증가하면서 할인받는다.")
    @ParameterizedTest
    @CsvSource({"1,1000", "2,1100", "3,1200", "24,3300", "25,3400"})
    void getDiscountTest1(String date, int discount) {
        EventDate eventDate = new EventDate(date);
        ChristmasDiscount christmasDiscount = new ChristmasDiscount(eventDate);

        assertEquals(discount, christmasDiscount.getDiscount());
    }

    @DisplayName("26일부터 31일까지는 크리스마스 할인이 적용되지 않습니다.")
    @ParameterizedTest
    @CsvSource({"26,0", "27,0", "28,0", "29,0", "30,0", "31,0"})
    void getDiscountTest2(String date, int discount) {
        EventDate eventDate = new EventDate(date);
        ChristmasDiscount christmasDiscount = new ChristmasDiscount(eventDate);

        assertEquals(discount, christmasDiscount.getDiscount());
    }
}
