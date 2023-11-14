package christmas.view;

import christmas.domain.order.Order;
import christmas.domain.order.Orders;

import java.text.DecimalFormat;

public class OutputView {
    private DecimalFormat decimalFormat = new DecimalFormat("###,###");

    public void output(Orders orders) {
        showFirstLine(orders);
        showOrderMenu(orders);
        showTotalOrderAmount(orders);
        showGift(orders);
        showBenefits(orders);
        showGiftPrice(orders);
        showTotalBenefitCost(orders);
        showExpectedPayCost(orders);
        showBadge(orders);
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
    }

    private void showTotalOrderAmount(Orders orders) {
        System.out.println("\n<할인 전 총주문 금액>");
        System.out.println(decimalFormat.format(orders.getOrderCost()) + "원");
    }

    private void showGift(Orders orders) {
        System.out.println("\n<증정 메뉴>");
        System.out.println(orders.getGift());
    }

    private void showBenefits(Orders orders) {
        System.out.println("\n<혜택 내역>");
        if (orders.getDiscount().keySet().size() == 0) {
            System.out.println("없음");
            return;
        }
        for (String key : orders.getDiscount().keySet()) {
            System.out.println(key + ": " +
                    decimalFormat.format(orders.getDiscount().get(key) * (-1)) + "원");
        }
    }

    private void showGiftPrice(Orders orders) {
        int giftPrice = orders.getGiftPrice();
        if (giftPrice != 0) {
            System.out.println("증정 이벤트: " + decimalFormat.format(giftPrice * (-1)) + "원");
        }
    }

    private void showTotalBenefitCost(Orders orders) {
        System.out.println("\n<총혜택 금액>");
        System.out.println(
                decimalFormat.format(orders.getTotalBenefitCost() * (-1)) + "원");
    }

    private void showExpectedPayCost(Orders orders) {
        System.out.println("\n<할인 후 예상 결제 금액>");
        System.out.println(
                decimalFormat.format(orders.getExpectedPayCost()) + "원");
    }

    private void showBadge(Orders orders) {
        System.out.println("\n<12월 이벤트 배지>");
        System.out.println(orders.getBadge());
    }
}
