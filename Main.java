import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static Date getDate(String date) {
        SimpleDateFormat dateformat = new SimpleDateFormat("dd.MM.yyyy");
        Date rdate;
        try {
            rdate = dateformat.parse(date);
            return rdate;
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void main(String[] args) {
        /*
         * AS A NOUN ANALYSIS OF OUR SYSTEM WE HAVE THE KEYWORDS AS
         * CUSTOMER_LIST -> LIST OF THE CUSTOMERS
         * TABLE_LIST -> LIST OF THE TABLES WHICH CUSTOMERS WILL SIT ON
         * WAITING_CUSTOMERS -> THE CUSTOMERS WHO COULDN'T FIND EMPTY TABLE
         * ORDER_LIST -> THE LIST OF ORDERS WHICH CUSTOMERS GIVE
         * WAITER_LIST -> THE WAITERS WHO RECIEVE ORDERS FROM CUSTOMERS
         * CHEF_LIST -> THE LIST OF CHEFS WHO COOKS THE ORDERS
         */

        ArrayList<Waiter> waiterList = Waiter.getList();

        ArrayList<Chef> chefList = Chef.getList();

        HashMap<Integer, Table> tableList = Table.getList();

        Queue<Customer> waitingCustomers = new LinkedList<Customer>();

        Queue<Order> orderList = new LinkedList<Order>();

        //
        Thread newCustomThread = new Thread(new Runnable() {
            @Override
            public void run() {
                // the list of customers
                ArrayList<Customer> list = Customer.getList();
                // ın every 5 second 5 new customers come to the system.
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 5; j++) {
                        // döngüdeki anlık müşteri
                        Customer customer = list.get(i + j);
                        // eğer boş masa varsa o masanın indexi
                        int emptyIndex = -1;
                        // boş masa var mı yok mu boolean
                        boolean isEmptyPlaceExist = false;
                        // tüm masaları dolaşıp boş masa var mı bakılıyor
                        for (int k = 0; k < tableList.size(); k++) {
                            // boş masa varsa döngüden çıkılıyor
                            if (tableList.get(k).isEmpty()) {
                                isEmptyPlaceExist = true;
                                emptyIndex = k;
                                break;
                            }
                        }
                        // eğer table listte boş yer varsa, oraya eklenecek yoksa bekleyenlere eklenecek
                        if (isEmptyPlaceExist) {
                            // boş yer olduğundan masaya ekleme yapılıyor
                            tableList.put(emptyIndex, new Table(customer));
                        } else {
                            // boş yer olmadığından bekleme listesine alınıyor
                            waitingCustomers.add(customer);
                        }
                    }
                    System.out.println(waitingCustomers);
                    System.out.println(tableList);
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {

                        e.printStackTrace();
                    }
                }
            }
        });
        newCustomThread.start();

    }

}
