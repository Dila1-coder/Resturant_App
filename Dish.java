package Dila1;

public class Dish {
    private String name;
    private double price;
    private int spicinessLevel;
    private String sideDishes;
    private String toppings;

    private String cookingStyle;
    public Dish(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getSpicinessLevel() {
        return spicinessLevel;
    }

    public void setSpicinessLevel(int spicinessLevel) {
        this.spicinessLevel = spicinessLevel;
    }

    public String getSideDishes() {
        return sideDishes;
    }

    public String getCookingStyle() {
        return cookingStyle;
    }

    public void setCookingStyle(String cookingStyle) {
        this.cookingStyle = cookingStyle;
    }
    public String getToppings() {
        return toppings;
    }

    public void setToppings(String toppings) {
        this.toppings = toppings;
    }

    @Override
    public String toString() {
        return name + " - $" + price;
    }
}
