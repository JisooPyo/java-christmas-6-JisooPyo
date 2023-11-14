package christmas.domain.menu;

import christmas.error.CustomError;

public class Menu {
    private String name;
    private int cost;

    public Menu(String name) {
        validate(name);
    }

    private void validate(String name) {
        if (findInAppetizers(name)) return;
        if (findInMains(name)) return;
        if (findInDessert(name)) return;
        if (findInDrink(name)) return;
        throw new IllegalArgumentException(CustomError.INVALID_ORDER.getMessage());
    }

    private boolean findInAppetizers(String name) {
        AppetizerMenu appetizerMenu = new AppetizerMenu();
        if (appetizerMenu.existsMenu(name)) {
            this.name = name;
            this.cost = appetizerMenu.getMenuCost(name);
            return true;
        }
        return false;
    }

    private boolean findInMains(String name) {
        MainMenu mainMenu = new MainMenu();
        if (mainMenu.existsMenu(name)) {
            this.name = name;
            this.cost = mainMenu.getMenuCost(name);
            return true;
        }
        return false;
    }

    private boolean findInDessert(String name) {
        DessertMenu dessertMenu = new DessertMenu();
        if (dessertMenu.existsMenu(name)) {
            this.name = name;
            this.cost = dessertMenu.getMenuCost(name);
            return true;
        }
        return false;
    }

    private boolean findInDrink(String name) {
        DrinkMenu drinkMenu = new DrinkMenu();
        if (drinkMenu.existsMenu(name)) {
            this.name = name;
            this.cost = drinkMenu.getMenuCost(name);
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
