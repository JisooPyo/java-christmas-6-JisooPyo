package christmas.date;

import christmas.domain.date.EventDate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

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

    @DisplayName("크리스마스 할인 기간 체크 기능 테스트 - true")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 7, 8, 10, 13, 20, 25})
    void withinChristmasDiscountRangeTest1(int date) {
        EventDate eventDate = new EventDate(Integer.toString(date));
        assertTrue(eventDate.withinChristmasDiscountRange());
    }

    @DisplayName("크리스마스 할인 기간 체크 기능 테스트 - false")
    @ParameterizedTest
    @ValueSource(ints = {26, 27, 28, 29, 30, 31})
    void withinChristmasDiscountRangeTest2(int date) {
        EventDate eventDate = new EventDate(Integer.toString(date));
        assertFalse(eventDate.withinChristmasDiscountRange());
    }

    @DisplayName("주말 체크 기능 테스트 - true")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 8, 9, 15, 16, 22, 23, 29, 30})
    void isWeekendTest1(int date) {
        EventDate eventDate = new EventDate(Integer.toString(date));
        assertTrue(eventDate.isWeekend());
    }

    @DisplayName("주말 체크 기능 테스트 - false")
    @ParameterizedTest
    @ValueSource(ints = {4, 12, 20, 28, 24})
    void isWeekendTest2(int date) {
        EventDate eventDate = new EventDate(Integer.toString(date));
        assertFalse(eventDate.isWeekend());
    }

    @DisplayName("특별할인 기간 체크 기능 테스트 - true")
    @ParameterizedTest
    @ValueSource(ints = {3, 10, 17, 24, 25, 31})
    void withinSpecialDiscountRange1(int date) {
        EventDate eventDate = new EventDate(Integer.toString(date));
        assertTrue(eventDate.withinSpecialDiscountRange());
    }

    @DisplayName("특별할인 기간 체크 기능 테스트 - false")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 4, 12, 20, 21, 26, 28, 29, 30})
    void withinSpecialDiscountRange2(int date) {
        EventDate eventDate = new EventDate(Integer.toString(date));
        assertFalse(eventDate.withinSpecialDiscountRange());
    }
}
