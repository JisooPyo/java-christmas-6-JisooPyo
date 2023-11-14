package christmas.error;

public enum CustomError {
    INPUT_MUST_NUMBER("[ERROR] 숫자만 입력해 주세요."),
    INVALID_DATE("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");

    private final String message;

    CustomError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
