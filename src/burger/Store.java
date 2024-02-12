package burger;

public class Store {
  public static void main(String[] args) {
    Meal regularMeal = new Meal();
    System.out.println(regularMeal);

    Meal USRegularMeal = new Meal(0.68);
    System.out.println(USRegularMeal);

    Meal deluxeMeal = new Meal(1, true);
    deluxeMeal.addBurgerToppings("Cheese", "Pork");
    System.out.println(deluxeMeal);
  }
}
