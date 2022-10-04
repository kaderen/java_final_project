import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class WaiterPoolHandler {
    private ArrayList<Waiter> waiters;
    private ThreadPoolExecutor threadPool;

    //? Neden contstructor'dan ArrayList<Waiter> istendi?? -> Kaç tane thread olavcağını belirleyebilmek için 
    //?waiters'ın boyutunu aldık ve uygun olan garsona görev verildiği için waiter listesine ihtiyacımız var.
    public WaiterPoolHandler(ArrayList<Waiter> waiters) {
        this.waiters = waiters;
        this.threadPool = (ThreadPoolExecutor) Executors.newFixedThreadPool(waiters.size());
    }

    void work() {
        Random rand = new Random();
        Waiter availableWaiter = waiters.get(rand.nextInt(waiters.size()));
        

        threadPool.execute(availableWaiter);
    }

}
