import java.util.ArrayList;
import java.util.HashMap;

public class Table {

    private Customer customer;

    public Table(Customer customer) {
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public boolean isEmpty() {
        return customer == null;
    }

    // static method is not dependent to any of the object parameters.
    static HashMap<Integer,Table> getList() {
        HashMap<Integer,Table> tableList = new HashMap<Integer,Table>();

        for (int i = 0; i < 4; i++) {
            tableList.put(i,new Table(null));
        }
        return tableList;
    }

}
