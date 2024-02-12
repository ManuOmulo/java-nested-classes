package burger;

import java.util.ArrayList;
import java.util.List;

public class Meal {
  private double price = 5.0;
  private Burger burger;
  private Item drink;
  private Item side;
  private boolean isDeluxe;

  private double conversionRate;

  public Meal() {
    this(1);
  }

  public Meal(double conversionRate) {
    this(conversionRate, false);
  }

  public Meal(double conversionRate, boolean isDeluxe) {
    this.conversionRate = conversionRate;
    this.isDeluxe = isDeluxe;
    burger = new Burger(isDeluxe ? "deluxe" : "regular", "burger");
    drink = new Item("coke", "drink", 1.5);
    System.out.println(drink.name);
    side = new Item("fries", "side", 2.0);
  }

  public double getTotal() {
    double total = burger.price + drink.price + side.price;
    return Item.getPrice(total, conversionRate);
  }

  public void addBurgerToppings(String... toppings) {
    List<Item> toppingsList = new ArrayList<>();

    for (String topping : toppings) {
      switch (topping) {
        case "Bacon" -> toppingsList.add(new Item("Bacon", "regular", 2));
        case "Avocado" -> toppingsList.add(new Item("Avocado", "small", 3));
        case "Shrimp" -> toppingsList.add(new Item("Shrimp", "jumbo", 4));
        case "Pork" -> toppingsList.add(new Item("Pork", "thin", 3));
        case "Beef" -> toppingsList.add(new Item("Beef", "lean", 3));
        default -> toppingsList.add(new Item("Cheese", "regular", 2));
      }
    }
    burger.addToppings(toppingsList);
  }

  @Override
  public String toString() {
    return "%s%n%s%n%s%n%26s$%.2f".formatted(burger, drink, side,
        "Total Due: ", getTotal());
  }


  private class Item {
    private String name;
    private String type;
    private double price;

    public Item(String name, String type) {
      this(name, type, type.equals("burger") ? Meal.this.price : 0);
    }

    public Item(String name, String type, double price) {
      this.name = name;
      this.type = type;
      this.price = price;
    }

    @Override
    public String toString() {
      return "%-11s%-15s $%.2f".formatted(type, name, getPrice(price, conversionRate));
    }

    private static double getPrice(double price, double rate) {
      return price * rate;
    }
  }


  private class Burger extends Item {
    private boolean isRegular = Meal.this.isDeluxe;
    private double price;
    private List<Item> toppings = new ArrayList<>();

    public Burger(String name, String type) {
      super(name, type, (Meal.this.isDeluxe ? 15 : Meal.this.price));
    }

    private void addToppings(List<Item> toppingsList) {
      if (isRegular) {
        for (Item topping : toppingsList) {
          toppings.add(topping);
          price += topping.price;
        }
      } else {
        for (Item topping : toppingsList) {
          toppings.add(topping);
        }
      }

    }

    @Override
    public String toString() {
      if (toppings.isEmpty()) {
        return ("%-10s %-15s $%.2f ").formatted(super.name, super.type, price);
      }

      System.out.println("Toppings: ");

      for (Item topping : toppings) {
        getToppingDetails(topping);
      }

      return ("%-10s %-15s $%.2f ").formatted(super.name, super.type, price);
    }

    private void getToppingDetails(Item topping) {
      System.out.printf("- %-5s %5s $%.2f\n".formatted(topping.name, topping.type, topping.price));
    }
  }
}
