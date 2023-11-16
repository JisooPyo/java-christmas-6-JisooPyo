package christmas.gift;

import christmas.domain.gift.Gift;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GiftTest {
    @DisplayName("총주문 금액이 12만원 이상이면 샴페인을 증정한다.")
    @ParameterizedTest
    @ValueSource(ints = {120_000, 130_000, 140_000, 200_000})
    void giftTest1(int total) {
        Gift gift = new Gift(total);
        assertEquals("샴페인 1개", gift.getName());
        assertEquals(25000, gift.getCost());
    }

    @DisplayName("총주문 금액이 12만원 이상이 아니면 증정 이벤트는 없다.")
    @ParameterizedTest
    @ValueSource(ints = {110_000, 100_000, 90_000, 80_000})
    void giftTest2(int total) {
        Gift gift = new Gift(total);
        assertEquals("없음", gift.getName());
        assertEquals(0, gift.getCost());
    }
}
