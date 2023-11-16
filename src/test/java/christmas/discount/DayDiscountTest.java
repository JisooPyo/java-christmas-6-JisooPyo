package christmas.discount;

import christmas.domain.date.EventDate;
import christmas.domain.discount.DayDiscount;
import christmas.domain.order.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DayDiscountTest {
    List<Order> orders = new ArrayList<>();
    EventDate eventDate;

    @BeforeEach
    void setUp() {
        // 에피타이저
        orders.add(new Order("양송이수프-1"));
        orders.add(new Order("시저샐러드-1"));
        // 메인
        orders.add(new Order("바비큐립-1"));
        orders.add(new Order("크리스마스파스타-2"));
        // 디저트
        orders.add(new Order("초코케이크-1"));
        orders.add(new Order("아이스크림-3"));
        // 음료
        orders.add(new Order("제로콜라-1"));
        orders.add(new Order("레드와인-4"));
    }

    @DisplayName("주말 할인 테스트")
    @Test
    void getDiscountTest1() {
        eventDate = new EventDate("22");
        DayDiscount dayDiscount = new DayDiscount(orders, eventDate);

        // 주말에는 메인 메뉴 메뉴 1개당 2023원 할인
        int discount = 2023 * 3;

        assertEquals(discount, dayDiscount.getDiscount().get("주말 할인"));
    }

    @DisplayName("평일 할인 테스트")
    @Test
    void getDiscountTest2() {
        eventDate = new EventDate("13");
        DayDiscount dayDiscount = new DayDiscount(orders, eventDate);

        // 평일에는 디저트 메뉴 메뉴 1개당 2023원 할인
        int discount = 2023 * 4;

        assertEquals(discount, dayDiscount.getDiscount().get("평일 할인"));
    }
}
