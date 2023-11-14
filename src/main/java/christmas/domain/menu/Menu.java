package christmas.domain.menu;

import christmas.error.CustomError;

public class Menu {
    private String name;
    private int cost;

    private final AppetizerMenu appetizerMenu;
    private final MainMenu mainMenu;
    private final DessertMenu dessertMenu;
    private final DrinkMenu drinkMenu;

    public Menu(String name) {
        validate(name);
        appetizerMenu = new AppetizerMenu();
        mainMenu = new MainMenu();
        dessertMenu = new DessertMenu();
        drinkMenu = new DrinkMenu();
    }

    private void validate(String name) {
        if (findInAppetizers(name)) return;
        if (findInMains(name)) return;
        if (findInDessert(name)) return;
        if (findInDrink(name)) return;
        throw new IllegalArgumentException(CustomError.INVALID_ORDER.getMessage());
    }

    private boolean findInAppetizers(String name) {
        if (appetizerMenu.existsMenu(name)) {
            this.name = name;
            this.cost = appetizerMenu.getMenuCost(name);
            return true;
        }
        return false;
    }

    private boolean findInMains(String name) {
        if (mainMenu.existsMenu(name)) {
            this.name = name;
            this.cost = mainMenu.getMenuCost(name);
            return true;
        }
        return false;
    }

    private boolean findInDessert(String name) {
        if (dessertMenu.existsMenu(name)) {
            this.name= name;
            this.cost=dessertMenu.getMenuCost(name);
            return true;
        }
        return false;
    }

    private boolean findInDrink(String name) {
        if (drinkMenu.existsMenu(name)) {
            this.name= name;
            this.cost=drinkMenu.getMenuCost(name);
            return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }
}
