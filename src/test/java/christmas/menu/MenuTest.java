package christmas.menu;

import christmas.domain.menu.Menu;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MenuTest {
    @DisplayName("메뉴판에 없는 메뉴를 입력하는 경우 예외처리한다.")
    @Test
    void validateMenuTest() {
        assertThatThrownBy(() -> new Menu("오리구이"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

}
