public class Food extends Request {

    private FoodCategory category;

    public Food(int price, String name, int time, int quantity, FoodCategory category) {
        super(price, name, time, quantity);
        this.category = category;
    }

    @Override
    public void make() {

    }

    public FoodCategory getCategory() {
        return category;
    }

    public void setCategory(FoodCategory category) {
        this.category = category;
    }

}
