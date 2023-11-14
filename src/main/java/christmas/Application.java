package christmas;

import christmas.eventPlanner.DecemberEventPlanner;

public class Application {
    public static void main(String[] args) {
        DecemberEventPlanner decemberEventPlanner = new DecemberEventPlanner();
        decemberEventPlanner.start();
    }
}
