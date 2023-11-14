package christmas.view;

import christmas.domain.order.Order;
import christmas.domain.order.Orders;

public class OutputView {
    public void output(Orders orders) {
        showFirstLine(orders);
        showOrderMenu(orders);
        showTotalOrderAmount(orders);
    }

    private void showFirstLine(Orders orders) {
        int date = orders.getEventDate().getDate();
        System.out.println("12월 " + date + "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n");
    }

    private void showOrderMenu(Orders orders) {
        System.out.println("<주문 메뉴>");
        for (Order order : orders.getOrders()) {
            System.out.println(order.getMenu().getName() + " " + order.getCount() + "개");
        }
        System.out.println();
    }

    private void showTotalOrderAmount(Orders orders) {
        System.out.println("<할인 전 총주문 금액>");
        System.out.println(orders.getTotalCost() + "원");
    }
}
