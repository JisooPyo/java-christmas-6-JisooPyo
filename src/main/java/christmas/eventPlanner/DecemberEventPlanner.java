package christmas.eventPlanner;

import christmas.view.InputView;
import christmas.view.OutputView;

public class DecemberEventPlanner {
    private InputView inputView;
    private OutputView outputView;

    public DecemberEventPlanner() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void start() {
        inputView.readInput();
    }
}
