import java.util.Date;

public class Waiter extends Employee {
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
}
