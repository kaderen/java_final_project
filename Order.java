import java.util.ArrayList;
import java.util.List;

public class Order {

    private List<Request> foodAndDrink;

    // TODO siparişi veren müşteri ve siparişe şefin başlayıp başlamadığını tutan
    // bir değişken de parametre olarak eklenecek
    // TODO YEMEK SAYISI 2Yİ GEÇMEMELİ VE İÇECEK SAYISI 1İ GEÇMEMELİ
    public Order(List<Request> foodAndDrink) throws IllegalOrderException {
        int foodCount = getFoodCount(foodAndDrink);
        int drinkCount = getDrinkCount(foodAndDrink);
        if (foodCount > 2 && drinkCount > 1) {
            throw new IllegalOrderException();
        }
        this.foodAndDrink = foodAndDrink;
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

    // TODO SİPARİŞİN NE KADAR SÜREDE HAZIRLANIP TÜKETİLDİĞİNİ INT OLARAK DÖNDÜREN
    // BIR METHOD YAZILACAK

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

    public static Order geneateOrder() throws IllegalOrderException {
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
        return new Order(list);

    }

    // TODO TOSTRING METHODU OVERRIDE EDİLEREK SIPARİŞ İÇERİĞİ YAZDIRILABİLİR

}
