package christmas.eventPlanner;

import christmas.view.InputView;
import christmas.view.OutputView;

public class DecemberEventPlanner {
    private InputView inputView;
    private OutputView outputView;

    public DecemberEventPlanner() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void start() {
        inputView.readInput();
    }
}
