package christmas.error;

public enum CustomError {
    INPUT_MUST_NUMBER("[ERROR] 숫자만 입력해 주세요."),
    INVALID_DATE("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    AVAILABLE_MAX_TWENTY("[ERROR] 메뉴는 한 번에 최대 20개까지만 주문할 수 있습니다."),
    INVALID_ORDER("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."),
    MUST_ADD_NON_DRINK("[ERROR] 음료만 주문하실 수 없습니다. 다시 입력해 주세요.");

    private final String message;

    CustomError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
