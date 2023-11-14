package christmas.badge;

import christmas.domain.badge.Badge;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BadgeTest {

    @DisplayName("혜택 금액에 따른 배지 확인")
    @ParameterizedTest
    @CsvSource({"0,없음", "2500,없음", "5000,별", "7500,별",
            "10000,트리", "15000,트리", "20000,산타", "30000,산타"})
    void getNameTest(int benefitAmount, String badgeName) {
        Badge badge = new Badge(benefitAmount);

        assertEquals(badgeName, badge.getName());
    }
}
