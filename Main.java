import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Main {
    /*
     * AS A NOUN ANALYSIS OF OUR SYSTEM WE HAVE THE KEYWORDS AS
     * CUSTOMER_LIST -> LIST OF THE CUSTOMERS
     * TABLE_LIST -> LIST OF THE TABLES WHICH CUSTOMERS WILL SIT ON
     * WAITING_CUSTOMERS -> THE CUSTOMERS WHO COULDN'T FIND EMPTY TABLE
     * ORDER_LIST -> THE LIST OF ORDERS WHICH CUSTOMERS GIVE
     * WAITER_LIST -> THE WAITERS WHO RECIEVE ORDERS FROM CUSTOMERS
     * CHEF_LIST -> THE LIST OF CHEFS WHO COOKS THE ORDERS
     */

    // ? tek tek neden static yazmadık. -> Dışarıdan bu collectionslara
    // (değişkenlere) erişmek istediğimiz için.
    // ? Dışarıdan spesifik olarak aynı listelere erişmek istediğimiz için static
    // bir nesne oluşturduk.(hepsini içeriyor.)
    ArrayList<Waiter> waiterList = Waiter.getList();

    ArrayList<Chef> chefList = Chef.getList();

    HashMap<Integer, Table> tableList = Table.getList();

    Queue<Customer> waitingCustomers = new LinkedList<Customer>();

    Queue<Order> orderList = new LinkedList<Order>();

    static Main main = new Main();

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

        // WAITER POOL ILE BIR NESNE OLUŞTURULUP THREAD O ŞEKİLDE ÇALIŞTIRILACAK

        // ? Waiters'ın Thread havuzunu kullanmamızı sağlayan nesne.

        WaiterPoolHandler waiters = new WaiterPoolHandler(main.waiterList);

        Thread newCustomThread = new Thread(new Runnable() {
            @Override
            public void run() {
                // the list of customers
                ArrayList<Customer> list = Customer.getList();
                // ın every 5 second 5 new customers come to the system.
                Random rand = new Random();
                
                for (int i = 0; i < 3; i++) {
                    System.out.println("%%% NEW CUSTOMERS ARRIVED");
                    for (int j = 0; j < 5; j++) {
                        // döngüdeki anlık müşteri
                        Customer customer = list.get(i * 5 + j);
                        System.out .println("+++ " + customer.getName() + " NAMED CUSTOMER HAS ARRIVED TO THE RESTAURANT");
                        // eğer boş masa varsa o masanın indexi
                        int emptyIndex = -1;
                        // boş masa var mı yok mu boolean
                        boolean isEmptyPlaceExist = false;
                        // tüm masaları dolaşıp boş masa var mı bakılıyor
                        for (int k = 0; k < main.tableList.size(); k++) {
                            // boş masa varsa döngüden çıkılıyor
                            if (main.tableList.get(k).isEmpty()) {
                                isEmptyPlaceExist = true;
                                emptyIndex = k;
                                break;
                            }
                        }
                        // eğer table listte boş yer varsa, oraya eklenecek yoksa bekleyenlere eklenecek
                        if (isEmptyPlaceExist) {
                            // boş yer olduğundan masaya ekleme yapılıyor
                            main.tableList.put(emptyIndex, new Table(customer));
                            // WAITER THREAD WILL WORK

                            // ? uygun olan garsonu göreve yolluyoruz random şekilde oluşturduğumuz metod
                            // içerisinden ayarlanıyor.
                            waiters.work();

                        } else {
                            // boş yer olmadığından bekleme listesine alınıyor
                            // TODO BEKLEMEYENLERE BEKLEMEDEN İŞLETMEDEN ÇIKTI DİYE YAZDIR.
                            boolean isWaiting = rand.nextBoolean();
                            if (isWaiting) {
                                main.waitingCustomers.add(customer);
                                
                            } else {
                                System.out .println("--- " + customer.getName() + " NAMED CUSTOMER HAS LEFT FROM THE RESTAURANT");

                                
                            } 
                            

                           
                        }
                    }

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
