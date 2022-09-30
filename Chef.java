import java.util.Date;

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
}
