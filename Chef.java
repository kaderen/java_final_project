import java.util.ArrayList;
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

    static ArrayList<Chef> getList() {
        ArrayList<Chef> chefList = new ArrayList<Chef>();

        chefList.add(new Chef("Sena", "123459678943", Main.getDate("01.24.1876"), Gender.male, Main.getDate("08.12.2022"), 4500, 4));

        return chefList;

    }
}
