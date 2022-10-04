import java.util.ArrayList;
import java.util.Date;

public class Waiter extends Employee implements Runnable{
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


    static ArrayList<Waiter> getList() {
        ArrayList<Waiter> waiterList = new ArrayList<Waiter>();

        waiterList.add(new Waiter("Kezban", "12334567765", Main.getDate("01.24.1989"), Gender.female,
                Main.getDate("08.12.2020"), 3000, 50));
        waiterList.add(new Waiter("Emre", "12345678943", Main.getDate("01.24.1876"), Gender.male,
                Main.getDate("08.12.2022"), 2500, 50));

        return waiterList;
    }

    @Override
    public void run() {
        //TODO WAITER IN SIPARİŞİ MÜŞTERİDEN ALIP ŞEFE İLETME SÜRECİ SIRASIYLA ŞU ŞEKİLDE İLERLER
        /*
         * işlemler MÜŞTERİYE SAHİP OLAN VE SİPARİŞ VERMEMİŞ OLAN BİR MASA varsa devam eder yoksa biter
         * ilgili masadaki customer threadi çalıştırılır ve sipariş oluşturulur
         * sipariş oluşturulduktan sonra şef threadi çalıştırılır
         * tüm işlerini bitirmiş olan garsonun uygunluğu true olarak güncellenir.
         */
    }
}
