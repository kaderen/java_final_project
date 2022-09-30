public class Drink extends Request {

    private DrinkCategory category;

    public Drink(int price, String name, int time, int quantity, DrinkCategory category) {
        super(price, name, time, quantity);
        this.category= category;
    }

    @Override
    public void make() {

    }

    public DrinkCategory getCategory() {
        return category;
    }

    public void setCategory(DrinkCategory category) {
        this.category = category;
    }

}
