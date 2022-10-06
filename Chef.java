import java.util.Date;
import java.util.ArrayList;

public class Chef extends Employee {

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

    @Override
    public void run() {

        Main main = Main.main;

        // ! Poll = Alır ve kuyruktan çıkartır.

        Order order = main.orderList.poll();

        if (order.isStarted() == false) {
            order.setStarted((true));
            System.out.println("!!! Chef: " + getName() + "   CHEF THREAD STARTED TO WORK ON ORDER FROM CUSTOMER NAMED "
                    + order.getCustomer().getName() + ":  " + order);

            // The thread will sleep until the order is ready.
            try {
                Thread.sleep(order.getTotalTime());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Removing the customer from the table.
            int key = order.getCustomer().getTableNumber();
            Customer customer = null;

            // Polling a customer from the queue.
            try {
                customer = main.waitingCustomers.poll();
                customer.setTableNumber(key);
            } catch (Exception e) {
            }

            // updating the customer in the table which key is equal to the last order's
            // key.

            main.tableList.get(key).setCustomer(customer);
            System.out.println("--- " + order.getCustomer().getName()
                    + " NAMED CUSTOMER FINISHED AND EXITTING THE SYSTEM");

            if (customer != null)
                main.waiters.work();

        }

    }

    public static ArrayList<Chef> getList() {
        ArrayList<Chef> chefList = new ArrayList<Chef>();

        chefList.add(new Chef("Sena", "123459678943", Main.getDate("01.24.1876"), Gender.male,
                Main.getDate("08.12.2022"), 4500, 4));

        chefList.add(new Chef("Yagmur", "1234594587943", Main.getDate("10.02.1994"), Gender.female,
                Main.getDate("02.11.2022"), 2200, 6));

        return chefList;

    }

}
