package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.domain.date.EventDate;
import christmas.domain.order.Orders;

public class InputView {

    public void readInput() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
        EventDate eventDate = readDate();
        Orders orders = readOrder(eventDate);
    }

    private EventDate readDate() {
        try {
            System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
            String date = Console.readLine();
            return new EventDate(date);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + "\n");
            return readDate();
        }
    }

    private Orders readOrder(EventDate eventDate) {
        try {
            System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. " +
                    "(e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
            String orderInput = Console.readLine();
            return new Orders(orderInput, eventDate);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + "\n");
            return readOrder(eventDate);
        }
    }
}
