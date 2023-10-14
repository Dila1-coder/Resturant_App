package Dila1;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<Dish> dishes;

    public Menu() {
        dishes = new ArrayList<>();
    }

    public void addDish(Dish dish) {
        dishes.add(dish);
    }

    public List<Dish> getDishes() {
        return dishes;
    }
}

