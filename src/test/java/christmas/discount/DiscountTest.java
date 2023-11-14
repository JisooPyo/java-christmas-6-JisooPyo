package christmas.discount;

import christmas.domain.date.EventDate;
import christmas.domain.discount.Discount;
import christmas.domain.order.Order;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DiscountTest {
    List<Order> orders = new ArrayList<>();

    @DisplayName("주문 금액이 10000원이 넘지 않으면 할인 혜택은 없다.")
    @Test
    void getTotalDiscount1() {
        orders.add(new Order("양송이수프-1"));
        orders.add(new Order("제로콜라-1"));
        EventDate eventDate = new EventDate("1");
        Discount discount = new Discount(orders, eventDate);
        assertEquals(0, discount.getTotalDiscount().size());
    }

    @DisplayName("크리스마스 디데이 할인 검사")
    @ParameterizedTest
    @CsvSource({"13,2200", "21,3000"})
    void getTotalDiscount2(String date, int price) {
        addOrders();
        EventDate eventDate = new EventDate(date);
        Discount discount = new Discount(orders, eventDate);
        assertEquals(price, discount.getTotalDiscount().get("크리스마스 디데이 할인"));
    }

    @DisplayName("주말/평일 검사")
    @ParameterizedTest
    @CsvSource({"7,4046,평일 할인", "8,8092,주말 할인", "9,8092,주말 할인", "10,4046,평일 할인"})
    void getTotalDiscount3(String date, int price, String key) {
        addOrders();
        EventDate eventDate = new EventDate(date);
        Discount discount = new Discount(orders, eventDate);
        assertEquals(price, discount.getTotalDiscount().get(key));
    }

    @DisplayName("특별 할인 검사")
    @ParameterizedTest
    @CsvSource({"22,0", "23,0", "24,1000", "25,1000"})
    void getTotalDiscount4(String date, int price) {
        addOrders();
        EventDate eventDate = new EventDate(date);
        Discount discount = new Discount(orders, eventDate);
        assertEquals(price, discount.getTotalDiscount().getOrDefault("특별 할인", 0));
    }

    private void addOrders() {
        orders.add(new Order("양송이수프-1"));
        orders.add(new Order("타파스-1"));
        orders.add(new Order("시저샐러드-1"));
        orders.add(new Order("티본스테이크-1"));
        orders.add(new Order("바비큐립-1"));
        orders.add(new Order("해산물파스타-1"));
        orders.add(new Order("크리스마스파스타-1"));
        orders.add(new Order("초코케이크-1"));
        orders.add(new Order("아이스크림-1"));
        orders.add(new Order("제로콜라-1"));
        orders.add(new Order("레드와인-1"));
        orders.add(new Order("샴페인-1"));
    }
}
