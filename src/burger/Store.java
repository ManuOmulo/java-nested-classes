package burger;

public class Store {
  public static void main(String[] args) {
    Meal regularMeal = new Meal();
    regularMeal.addBurgerToppings("Bacon", "Avocado", "Cheese");
    System.out.println(regularMeal);

    Meal noToppings = new Meal();
    System.out.println(noToppings);

    Meal USRegularMeal = new Meal(0.68);
    USRegularMeal.addBurgerToppings("Bacon", "Avocado", "Cheese");
    System.out.println(USRegularMeal);

    Meal deluxeMeal = new Meal(1, true);
    deluxeMeal.addBurgerToppings("Cheese", "Pork");
    System.out.println(deluxeMeal);
  }
}
