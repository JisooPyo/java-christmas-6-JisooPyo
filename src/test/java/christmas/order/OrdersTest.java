package christmas.order;

import christmas.domain.date.EventDate;
import christmas.domain.order.Orders;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class OrdersTest {
    Orders orders;

    @DisplayName("메뉴를 21개 이상 주문했을 경우 예외처리")
    @Test
    void checkTotalCountTest() {
        String orderInput = "타파스-20,제로콜라-1";
        EventDate eventDate = new EventDate("26");
        assertThatThrownBy(() -> new Orders(orderInput, eventDate))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 메뉴는 한 번에 최대 20개까지만 주문할 수 있습니다.");
    }

    @DisplayName("중복 메뉴를 입력한 경우 예외처리")
    @Test
    void checkDuplicateMenuTest() {
        String orderInput = "타파스-1,타파스-2";
        EventDate eventDate = new EventDate("26");
        assertThatThrownBy(() -> new Orders(orderInput, eventDate))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    @DisplayName("음료수만 시켰을 때 예외처리")
    @Test
    void checkOnlyDrinksTest() {
        String orderInput = "제로콜라-1,샴페인-1,레드와인-1";
        EventDate eventDate = new EventDate("26");
        assertThatThrownBy(() -> new Orders(orderInput, eventDate))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 음료만 주문하실 수 없습니다. 다시 입력해 주세요.");
    }

    @DisplayName("할인 전 총 주문 금액 테스트")
    @Test
    void getOrderCostTest() {
        String orderInput = "양송이수프-1,타파스-2,티본스테이크-1,아이스크림-1,레드와인-1";
        EventDate eventDate = new EventDate("26");
        int expectedPrice = 6000 * 1 + 5500 * 2 + 55000 * 1 + 5000 * 1 + 60000;

        orders = new Orders(orderInput, eventDate);
        assertEquals(expectedPrice, orders.getOrderCost());
    }

    @DisplayName("할인 전 총 주문 금액이 12만원 이상일 때 샴페인 증정 테스트")
    @Test
    void getGiftTest1() {
        String orderInput = "티본스테이크-1,바비큐립-1,해산물파스타-1";
        EventDate eventDate = new EventDate("26");
        orders = new Orders(orderInput, eventDate);

        assertEquals("샴페인 1개", orders.getGift());
        assertEquals(25000, orders.getGiftPrice());
    }

    @DisplayName("할인 후 총 주문 금액이 12만원 미만일 때 샴페인 증정 X 테스트")
    @Test
    void getGiftTest2() {
        String orderInput = "양송이수프-1,초코케이크-1";
        EventDate eventDate = new EventDate("26");
        orders = new Orders(orderInput, eventDate);

        assertEquals("없음", orders.getGift());
        assertEquals(0, orders.getGiftPrice());
    }

    @DisplayName("통합 테스트")
    @Test
    void getDiscountTest() {
        String orderInput = "티본스테이크-1,바비큐립-1,해산물파스타-1";
        EventDate eventDate = new EventDate("24");
        orders = new Orders(orderInput, eventDate);

        assertEquals(3300, orders.getDiscount().get("크리스마스 디데이 할인"));
        assertNull(orders.getDiscount().get("평일 할인"));
        assertEquals(1000, orders.getDiscount().get("특별 할인"));

        assertEquals(29300, orders.getTotalBenefitCost());
        assertEquals(139700, orders.getExpectedPayCost());

        assertEquals("산타", orders.getBadge());
    }
}
