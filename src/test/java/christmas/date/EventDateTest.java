package christmas.date;

import christmas.domain.date.EventDate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class EventDateTest {
    @DisplayName("날짜는 숫자로만 이루어져야 한다.")
    @Test
    void consistsOfNumberTest() {
        assertThatThrownBy(() -> new EventDate("1일"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
    }

    @DisplayName("날짜에 너무 큰 값이 들어오면 안된다.")
    @Test
    void checkFormat() {
        assertThatThrownBy(() -> new EventDate("123456789123456789123456789"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
    }

    @DisplayName("날짜는 1일부터 31일까지여야 한다. - 예외처리")
    @ParameterizedTest
    @ValueSource(strings = {"0", "32", "33"})
    void checkValidDateTest1(String date) {
        assertThatThrownBy(() -> new EventDate(date))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
    }

    @DisplayName("날짜는 1일부터 31일까지여야 한다. - 성공")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "29", "30", "31"})
    void checkValidDateTest2(String date) {
        assertDoesNotThrow(() -> new EventDate(date));
    }
}
