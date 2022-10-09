public class Food extends Request {

    private FoodCategory category;

    public Food(int price, String name, int cookingTime, int quantity, FoodCategory category,int consumeTime) {
        super(price, name, cookingTime, quantity, consumeTime);
        this.category = category;
    }

    public FoodCategory getCategory() {
        return category;
    }

    public void setCategory(FoodCategory category) {
        this.category = category;
    }

}
