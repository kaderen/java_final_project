import java.nio.BufferOverflowException;
import java.util.ArrayList;
import java.util.Date;

public class Customer extends Person implements Runnable {
    private boolean isOrdered;
    private Order order;

    public Customer(String name, String ssn, Date birth_Date, Gender gender) throws IllegalOrderException {
        super(name, ssn, birth_Date, gender);
        isOrdered = false;
        this.order = Order.geneateOrder();

    }

    public boolean isOrdered() {
        return isOrdered;
    }

    public void setOrdered(boolean isOrdered) {
        this.isOrdered = isOrdered;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public void run() {

        if (isOrdered == false) {
            Main main = Main.main;
            main.orderList.add(order);

        }
        /*
         * MÜŞTERİNİN DAHA ÖNCE SİPARİŞ VERİP VERMEDİĞİNİN KONTROLÜ OLACAK
         * EĞER MÜŞTERİ DAHA ÖNCE SİPARİŞ VERMEDİYSE İŞLEMLERE DEVAM EDİLECEK
         * MÜŞTERİNİN SİPARİŞİ, ORDERLIST'E EKLENECEK
         */

    }

    static ArrayList<Customer> getList() {
        ArrayList<Customer> customerList = new ArrayList<Customer>();
        try {
            customerList.add(new Customer("Zehra", "23456789876", Main.getDate("12.12.2000"), Gender.female));
            customerList.add(new Customer("Sedat", "23456098906", Main.getDate("28.10.2000"), Gender.male));
            customerList.add(new Customer("Kader", "23456789098", Main.getDate("16.10.1997"), Gender.female));
            customerList.add(new Customer("Ali", "0987654332", Main.getDate("24.06.1999"), Gender.male));
            customerList.add(new Customer("Selim", "0987654134", Main.getDate("24.06.1000"), Gender.male));
            customerList.add(new Customer("Muhammet", "0987354334", Main.getDate("24.06.2004"), Gender.male));
            customerList.add(new Customer("Mustafa", "0987644334", Main.getDate("24.06.2003"), Gender.male));
            customerList.add(new Customer("Irem", "0987654354", Main.getDate("24.06.2002"), Gender.female));
            customerList.add(new Customer("IremMelisa", "0987654334", Main.getDate("24.04.2000"), Gender.female));
            customerList.add(new Customer("Keder", "0987654734", Main.getDate("24.06.2020"), Gender.female));
            customerList.add(new Customer("Aydın", "0987654834", Main.getDate("24.06.2010"), Gender.male));
            customerList.add(new Customer("Bearkuan", "0987954334", Main.getDate("24.06.2009"), Gender.male));
            customerList.add(new Customer("Mehmet", "0987650334", Main.getDate("24.06.1996"), Gender.male));
            customerList.add(new Customer("Ayse", "0287650334", Main.getDate("24.06.1978"), Gender.female));
            customerList.add(new Customer("Özgür", "4987650334", Main.getDate("24.06.1994"), Gender.male));
        } catch (IllegalOrderException e) {
        }

        return customerList;
    }

}
