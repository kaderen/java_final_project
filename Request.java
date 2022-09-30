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

}
