import java.util.Date;

public abstract class Employee extends Person {
    private Date startDateOfWork;
    private int salary;

    public Employee(String name, String ssn, Date birth_Date, Gender gender, Date startDateOfWork, int salary) {
        super(name, ssn, birth_Date, gender);
        this.startDateOfWork = startDateOfWork;
        this.salary = salary;
    }

    public Date getStartDateOfWork() {
        return startDateOfWork;
    }

    public void setStartDateOfWork(Date startDateOfWork) {
        this.startDateOfWork = startDateOfWork;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

}
