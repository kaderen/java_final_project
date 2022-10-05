import java.util.ArrayList;
import java.util.List;

public class Order {

    private List<Request> foodAndDrink;
    private boolean isStarted;
    private Customer customer;

    public Order(List<Request> foodAndDrink, Customer customer) throws IllegalOrderException {
        int foodCount = getFoodCount(foodAndDrink);
        int drinkCount = getDrinkCount(foodAndDrink);
        if (foodCount > 2 || drinkCount > 1) {
            throw new IllegalOrderException();
        }
        this.foodAndDrink = foodAndDrink;
        this.isStarted = false;
        this.customer = customer;
    }

    public List<Request> getFoodAndDrink() {
        return foodAndDrink;
    }

    public void setFoodAndDrink(List<Request> foodAndDrink) throws IllegalOrderException {
        int foodCount = getFoodCount(foodAndDrink);
        int drinkCount = getDrinkCount(foodAndDrink);
        if (foodCount > 2 && drinkCount > 1) {
            throw new IllegalOrderException();
        }
        this.foodAndDrink = foodAndDrink;
    }

    public boolean isStarted() {
        return isStarted;
    }

    public void setStarted(boolean isStarted) {
        this.isStarted = isStarted;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getTotalTime() {
        int temp = 0;
        for (Request request : foodAndDrink) {

            temp += request.getTime();

        }
        return temp;

    }

    public static int getFoodCount(List<Request> rawList) {
        int total = 0;
        for (Request request : rawList) {
            try {
                Food food = (Food) request;
                total++;
            } catch (Exception e) {
                continue;
            }
        }
        return total;
    }

    public static int getDrinkCount(List<Request> rawList) {
        int total = 0;
        for (Request request : rawList) {
            try {
                Drink drink = (Drink) request;

                total++;
            } catch (Exception e) {
                continue;
            }
        }
        return total;
    }

    public static Order generateOrder(Customer customer) throws IllegalOrderException {
        ArrayList<Request> list = new ArrayList<Request>();
        Food food1 = Request.randomFood();
        Food food2 = Request.randomFood();
        Drink drink = Request.randomDrink();

        if (food1 != null)
            list.add(food1);
        if (food2 != null)
            list.add(food2);
        if (drink != null)
            list.add(drink);
        return new Order(list, customer);

    }

    @Override
    public String toString() {

        String temp = "";
        for (Request request : foodAndDrink) {
            temp += "\n\t" + request;
        }
        return temp;
    }

}
