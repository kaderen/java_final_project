import java.util.ArrayList;
import java.util.Date;

//TODO CHEF BIR THREAD OLARAK ÇALIŞABİLMELİ VE BU THREAD SIRASIYLA
/*
 * KUYRUKTAN BİR SİPARİŞİ POLL İLE ÇEKİP O SİPARİŞİ HAZIRLAMALI (O SÜRE BOYUNCA SLEEP) NOT: SİPARİŞE DAHA ÖNCE BAŞLANMAMIŞ OLUNMALI
 * SİPARİŞ HAZIR OLUNCA MASADAN ILGILI SIPARIŞI VEREN MUSTERİ KALKMALI
 * BOŞALAN MASAYA BEKLEYEN MÜŞTERİLER LİSTESİNDEN BİRİ GELMELİ
 * WAITERPOOL OLAN THREAD HAVUZU GÖREVE ÇAĞRILAMLI
 */
public class Chef extends Employee implements Runnable{

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

    @Override
    public void run() {
        /*
         * ÖNCELİKLE ORDER KUYRUĞUNDA POLL METODU İLE BİR ORDER NESNESİ ÇEKİLMELİ
         * SONRASINDA ORDER'A BAŞLANIP BAŞLANMADIĞI KONTROL EDİLMELİ
         * EĞER BAŞLANMADIYSA İŞLEMLERE DEVAM EDİLECEK
         * ÖNCELİKLE İŞLEMLERDEN ÖNCE ORDER'A BAŞLANDIĞI SET EDILMELI
         * SONRASINDA SİPARİŞİN SÜRESİNCE THREAD UYUYACAK Kİ YEMEKLER HAZIR OLSUN
         * SİPARİŞ TAMAMLANDIĞINDA İSE SİPARİŞİ HAZIRLANAN MÜŞTERİ MASADAN KALKMALI
         * BOŞALAN YERE İSE BEKLEYENLER ARASINDAN POLL İLE MÜŞTERİ ÇEKİLİP YERLEŞTİRİLMELŞİ
         * MASA TEKRAR DOLDUĞUNDA WAITERPOOL İLE GARSON GÖREVLENDİRİLMELİ
         */
        
    }
}
