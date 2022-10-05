import java.util.ArrayList;
import java.util.Date;

public class Waiter extends Employee implements Runnable {
    private int tipCount;

    public Waiter(String name, String ssn, Date birth_Date, Gender gender, Date startDateOfWork, int salary,
            int tipCount) {
        super(name, ssn, birth_Date, gender, startDateOfWork, salary);
        this.tipCount = tipCount;
    }

    public int getTipCount() {
        return tipCount;
    }

    public void setTipCount(int tipCount) {
        this.tipCount = tipCount;
    }

    static ArrayList<Waiter> getList() {
        ArrayList<Waiter> waiterList = new ArrayList<Waiter>();

        waiterList.add(new Waiter("Kezban", "12334567765", Main.getDate("01.24.1989"), Gender.female,
                Main.getDate("08.12.2020"), 3000, 50));
        waiterList.add(new Waiter("Emre", "12345678943", Main.getDate("01.24.1876"), Gender.male,
                Main.getDate("08.12.2022"), 2500, 50));

        return waiterList;
    }

    @Override
    public void run() {
        
        // Tüm masaları gzerek içerisinde dolu bir masa ve siparişini vermeyen birisi varsa garson o masaya bakacak.

        Table lookingTable = null;
        Main main = Main.main;
        for (int i = 0; i < main.tableList.size(); i++) {
            Table temp = main.tableList.get(i);
            if (temp.isEmpty() == false && temp.getCustomer().isOrdered == false) {

                lookingTable = temp;
                break;
            }
        }
        if (lookingTable == null) {
            return;
        }

        //CUSTOMER SİPARİS VERİYOR.

        lookingTable.getCustomer().run();

        ChefPoolHandler chefs = new ChefPoolHandler(main.chefList);
        chefs.work();

        

        /*
         * işlemler MÜŞTERİYE SAHİP OLAN VE SİPARİŞ VERMEMİŞ OLAN BİR MASA varsa devam
         * eder yoksa biter
         * ilgili masadaki customer threadi çalıştırılır ve sipariş oluşturulur
         * sipariş oluşturulduktan sonra şef threadi çalıştırılır
         * tüm işlerini bitirmiş olan garsonun uygunluğu true olarak güncellenir.
         */
    }
}
