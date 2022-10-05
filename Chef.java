import java.util.ArrayList;
import java.util.Date;

/*
 * KUYRUKTAN BİR SİPARİŞİ POLL İLE ÇEKİP O SİPARİŞİ HAZIRLAMALI (O SÜRE BOYUNCA SLEEP) NOT: SİPARİŞE DAHA ÖNCE BAŞLANMAMIŞ OLUNMALI
 * SİPARİŞ HAZIR OLUNCA MASADAN ILGILI SIPARIŞI VEREN MUSTERİ KALKMALI
 * BOŞALAN MASAYA BEKLEYEN MÜŞTERİLER LİSTESİNDEN BİRİ GELMELİ
 * WAITERPOOL OLAN THREAD HAVUZU GÖREVE ÇAĞRILAMLI
 */
public class Chef extends Employee implements Runnable {

    private int reward;

    public Chef(String name, String ssn, Date birth_Date, Gender gender, Date startDateOfWork, int salary, int reward) {
        super(name, ssn, birth_Date, gender, startDateOfWork, salary);
        this.reward = reward;
    }

    public int getReward() {
        return reward;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }

    static ArrayList<Chef> getList() {
        ArrayList<Chef> chefList = new ArrayList<Chef>();

        chefList.add(new Chef("Sena", "123459678943", Main.getDate("01.24.1876"), Gender.male,
                Main.getDate("08.12.2022"), 4500, 4));

        return chefList;

    }

    @Override
    public void run() {
        Main main = Main.main;

        // Poll = Alır ve kuyruktan çıkartır.

        Order order = main.orderList.poll();

        if (order.isStarted() == false) {

            order.setStarted(true);
            System.out.println("!!! CHEF THREAD STARTED TO WORK ON ORDER FROM CUSTOMER NAMED "
                    + order.getCustomer().getName() + ":  " + order);
            try {
                Thread.sleep(order.getTotalTime());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            int key = order.getCustomer().getTableNumber();
            Customer customer = null;

            try {
                customer = main.waitingCustomers.poll();
                customer.setTableNumber(key);
            } catch (Exception e) {
            }
            main.tableList.get(key).setCustomer(customer);
            System.out.println("--- " + order.getCustomer().getName()
                    + " NAMED CUSTOMER FINISHED AND EXITTING THE SYSTEM");

            main.waiters.work();

        }

    }
}
