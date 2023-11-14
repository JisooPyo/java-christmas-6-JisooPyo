package christmas.view;

import christmas.domain.order.Order;
import christmas.domain.order.Orders;

public class OutputView {
    public void output(Orders orders) {
        showFirstLine(orders);
        showOrderMenu(orders);
        showTotalOrderAmount(orders);
        showGift(orders);
        showBenefits(orders);
        showGiftPrice(orders);
        showTotalBenefitCost(orders);
    }

    private void showFirstLine(Orders orders) {
        int date = orders.getEventDate().getDate();
        System.out.println("12월 " + date + "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
    }

    private void showOrderMenu(Orders orders) {
        System.out.println("\n<주문 메뉴>");
        for (Order order : orders.getOrders()) {
            System.out.println(order.getMenu().getName() + " " + order.getCount() + "개");
        }
        System.out.println();
    }

    private void showTotalOrderAmount(Orders orders) {
        System.out.println("\n<할인 전 총주문 금액>");
        System.out.println(orders.getOrderCost() + "원");
    }

    private void showGift(Orders orders) {
        System.out.println("\n<증정 메뉴>");
        System.out.println(orders.getGift().getName());
    }

    private void showBenefits(Orders orders) {
        System.out.println("\n<혜택 내역>");
        if (orders.getBenefits().keySet().size() == 1) {
            System.out.println("없음");
            return;
        }
        for (String key : orders.getBenefits().keySet()) {
            System.out.println(key + ": -" + orders.getBenefits().get(key) + "원");
        }
    }

    private void showGiftPrice(Orders orders) {
        int giftPrice = orders.getGift().getCost();
        if (giftPrice != 0) {
            System.out.println("증정 이벤트: -" + giftPrice + "원");
        }
    }

    private void showTotalBenefitCost(Orders orders) {
        System.out.println("\n<총혜택 금액>");
        System.out.println("-" + orders.getTotalBenefitCost() + "원");
    }
}
