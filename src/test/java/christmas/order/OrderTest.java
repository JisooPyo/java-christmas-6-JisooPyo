package christmas.order;

import christmas.domain.order.Order;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.internal.matchers.Or;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderTest {

    @DisplayName("메뉴 형식이 예시와 다른 경우 예외처리")
    @ParameterizedTest
    @ValueSource(strings = {"타파스1", "타파스", "타파스-", "-1", "1", "타파스 -1", "타파스- 1"})
    void validsteOrderTest1(String order) {
        assertThatThrownBy(() -> new Order(order))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    @DisplayName("메뉴의 개수가 0일 때 예외처리")
    @Test
    void validsteOrderTest2() {
        assertThatThrownBy(() -> new Order("타파스-0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    @DisplayName("메뉴 단건 주문 금액 구하기 테스트")
    @ParameterizedTest
    @CsvSource({"양송이수프-1,6000", "크리스마스파스타-2,50000", "제로콜라-3,9000"})
    void getCostTest(String menuAndCount, int price) {
        Order order = new Order(menuAndCount);
        assertEquals(price, order.getCost());
    }

}
