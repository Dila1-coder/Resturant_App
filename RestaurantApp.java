package Dila1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RestaurantApp {
    private Menu menu;
    private Scanner scanner;
    public RestaurantApp() {
        menu = new Menu();
        scanner = new Scanner(System.in);

    }

    public void addDefaultSeafoodDishes() {
        menu.addDish(new Dish("Grilled Salmon", 18.99));
        menu.addDish(new Dish("Shrimp Scampi", 15.49));
        menu.addDish(new Dish("Lobster Roll", 22.99));
        menu.addDish(new Dish("Calamari Fritti", 12.99));
        menu.addDish(new Dish("Pan-Seared Tuna", 19.99));
        menu.addDish(new Dish("Garlic Butter Shrimp", 17.99));
        menu.addDish(new Dish("Seafood Paella", 21.99));
        menu.addDish(new Dish("Crab Cakes", 16.99));
        menu.addDish(new Dish("Clam Chowder", 10.99));
        menu.addDish(new Dish("Grilled Swordfish", 20.99));
        menu.addDish(new Dish("Miso-Glazed Cod", 18.49));
        menu.addDish(new Dish("Scallops with Lemon Butter", 22.49));
        menu.addDish(new Dish("Stuffed Lobster", 25.99));
        menu.addDish(new Dish("Tuna Poke Bowl", 14.99));
        menu.addDish(new Dish("Coconut Shrimp", 13.99));
    }

    private void displayWElcomeMessage() {

        System.out.println(
                "\uD83C\uDF0A Welcome to Seafood Delights! \uD83C\uDF0A" + "\n");
    }

    public void displayMenu() {
        List<Dish> dishes = menu.getDishes();
        for (Dish dish : dishes) {
            System.out.println(dish);
        }
    }

    public void placeOrder() {
        System.out.println("What would you like to order? \nEnter the name of the dish: ");
        String dishName = scanner.nextLine();

        List<Dish> dishes = menu.getDishes();
        Dish selectedDish = null;
        for (Dish dish : dishes) {
            if (dish.getName().equalsIgnoreCase(dishName)) {
                selectedDish = dish;
                break;
            }
        }

        if (selectedDish == null) {
            System.out.println("I'm sorry, that dish is not available. Please choose another dish.");
            return;
        }

        System.out.println("Would you like to customize your order? (yes/no)");
        String customChoice = scanner.nextLine();
        if (customChoice.equalsIgnoreCase("yes \n")) {
            System.out.println("Customizing " + selectedDish.getName() + ":");
            customizeDish(selectedDish);
        }

        System.out.println("Excellent choice! One " + selectedDish.getName() + " coming right up!");
    }

    private void customizeDish(Dish dish) {
        // Customize spiciness level
        System.out.println("Choose spiciness level (1-5, 1 being mild and 5 being very spicy): ");
        int spiciness = Integer.parseInt(scanner.nextLine());
        dish.setSpicinessLevel(spiciness);

        // Customize cooking style
        System.out.println("Choose the cooking style for " + dish.getName() + " (Grilled/Pan-fried/Baked): ");
        String cookingStyle = scanner.nextLine();
        dish.setCookingStyle(cookingStyle);


        // Customize toppings
        System.out.println("Available toppings for " + dish.getName() + ":");
        System.out.println("1. Lemon slices");
        System.out.println("2. Fresh herbs (e.g., parsley, dill, cilantro, basil)");
        System.out.println("3. Toasted breadcrumbs");
        System.out.println("4. Parmesan cheese");
        System.out.println("5. Diced onions or scallions");
        System.out.println("6. Roasted garlic");
        // Add more topping options if desired

        System.out.println("Choose extra toppings (comma-separated, e.g., 1,3,5): ");
        String chosenToppingsInput = scanner.nextLine();
        String[] chosenToppingsArray = chosenToppingsInput.split(",");
        List<String> chosenToppingsList = new ArrayList<>();
        for (String topping : chosenToppingsArray) {
            int toppingIndex = Integer.parseInt(topping.trim());
            if (toppingIndex >= 1 && toppingIndex <= 6) {
                switch (toppingIndex) {
                    case 1:
                        chosenToppingsList.add("Lemon slices");
                        break;
                    case 2:
                        chosenToppingsList.add("Fresh herbs");
                        break;
                    case 3:
                        chosenToppingsList.add("Toasted breadcrumbs");
                        break;
                    case 4:
                        chosenToppingsList.add("Parmesan cheese");
                        break;
                    case 5:
                        chosenToppingsList.add("Diced onions or scallions");
                        break;
                    case 6:
                        chosenToppingsList.add("Roasted garlic");
                        break;
                    // Add more cases if more toppings are added
                }
            }
        }
        dish.setToppings(String.join(", ", chosenToppingsList));
    }



    public boolean wantToOrderAgain() {
        System.out.println("Do you want to order something else? (yes/no)");
        String response = scanner.nextLine();
        return response.equalsIgnoreCase("yes");
    }

    public void startOrdering() {
        displayWElcomeMessage();

        // Ask the user if they are ready to see the menu
        System.out.println("Are you ready to see the menu? (yes/no)");
        String response = scanner.nextLine();
        if (!response.equalsIgnoreCase("yes")) {
            System.out.println("No problem! Just let Chef Charlie know what you'd like to order.");
            placeOrder();
        } else {
            while (true) {
                displayMenu();
                placeOrder();
                if (!wantToOrderAgain()) {
                    System.out.println("Thank you for ordering. \n \uD83D\uDC1F\uD83E\uDD90\uD83E\uDD9E\uD83E\uDD80\uD83E\uDD91 Enjoy your Seafood Delights experience! \uD83E\uDD91\uD83E\uDD80\uD83E\uDD9E\uD83E\uDD90\uD83D\uDC1F");
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        RestaurantApp restaurant = new RestaurantApp();
        restaurant.addDefaultSeafoodDishes();

        restaurant.startOrdering();
    }
}
