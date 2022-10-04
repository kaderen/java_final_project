import java.util.ArrayList;
import java.util.Random;

public abstract class Request implements Consumable {
    private int price;
    private String name;
    private int time;
    private int quantity;

    public Request(int price, String name, int time, int quantity) {
        this.price = price;
        this.name = name;
        this.time = time;
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public int getTime() {
        return time;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // TODO TO STRING METHODU OVERRIDE EDILEREK ISTEĞIN ISMI VE FİYATI
    // GÖSTERILEBİLİR

    public static Food randomFood() {
        ArrayList<Food> list = new ArrayList<Food>();
        list.add(new Food(30, "Köfte", 3000, 4, FoodCategory.main));
        list.add(new Food(50, "Pizza", 4000, 2, FoodCategory.hot));
        list.add(new Food(35, "Magnolya", 3500, 2, FoodCategory.desert));
        list.add(new Food(129, "Balık", 2000, 1, FoodCategory.seafood));
        list.add(new Food(300, "Falafel", 5000, 3, FoodCategory.vegan));
        list.add(new Food(120, "Pilav", 2300, 1, FoodCategory.main));
        list.add(new Food(70, "Hamburger", 3200, 6, FoodCategory.main));
        list.add(null);
        list.add(null);

        list.add(null);

        Random rand = new Random();
        Food food = list.get(rand.nextInt(list.size()));
        return food;
    }

    public static Drink randomDrink() {
        ArrayList<Drink> list = new ArrayList<Drink>();
        list.add(new Drink(23, "Churchill", 200, 1, DrinkCategory.cold));
        list.add(new Drink(13, "Bira", 300, 1, DrinkCategory.cold));
        list.add(new Drink(33, "Frozen", 400, 1, DrinkCategory.cold));
        list.add(new Drink(43, "Soda", 220, 1, DrinkCategory.cold));
        list.add(new Drink(33, "Meyve SUyu", 240, 1, DrinkCategory.cold));
        list.add(new Drink(23, "Çay", 220, 1, DrinkCategory.hot));
        list.add(new Drink(3, "Su", 1000, 1, DrinkCategory.cold));
        list.add(null);
        list.add(null);

        list.add(null);

        Random rand = new Random();
        Drink drink = list.get(rand.nextInt(list.size()));
        return drink;
    }

}
