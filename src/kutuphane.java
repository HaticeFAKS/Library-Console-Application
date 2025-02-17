import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import static java.lang.System.out;
import  java.util.Scanner;
import java.io.IOException;

public class kutuphane {
    private List<kitap> kitaplar;
    private List<uye> uyeler;
    private List<gorevli> gorevliler;
    private Scanner scanner;
    private String isim;
    private String soyisim;

    public static  Map<uye, kitap> oduncKitaplar;


    kutuphane()
    {
        this.kitaplar=new ArrayList<>();
        uyeler=new ArrayList<>();
        gorevliler=new ArrayList<>();
        oduncKitaplar=new HashMap<>();
        scanner=new Scanner(System.in);
        isim=" ";
        soyisim=" ";
    }

    public void kitapEkle() {

        out.print("Lütfen eklemek istediğiniz kitabı giriniz:");
        isim = scanner.nextLine();
        for (kitap kitap : kitaplar) {
            if (kitap.getIsim().equals(isim)) {
                out.println("Böyle bir kitap zaten var!");
                return;
            }
        }
        kitaplar.add(new kitap(isim));
        out.println("Kitap başarıyla eklendi!");
    }


        public void kitapCikar()
        {
             Iterator<kitap> iterator;

            if (kitaplar.isEmpty()) {

                out.println("Kütüphanede çıkarılcak bir kitap yok!");
                return;
            }
            out.print("Lütfen kitap ismi giriniz:");
            isim = scanner.nextLine();
            iterator =kitaplar.iterator();
            while (iterator.hasNext()) {
                kitap currentKitap=iterator.next();
                    if (currentKitap.getIsim().equals(isim)) {
                        iterator.remove();out.println("Kitap başarıyla çıkarıldı!");
                        return;
                    }
            }
            out.println("Bu kitap mevcut değil!");

        }

    public void uyeEkle() {
        out.print("Lütfen üye ismini giriniz:");
        isim = scanner.nextLine();
        out.print("Lütfen üyenin soyismini giriniz:");
        soyisim = scanner.nextLine();


        if (uyeler.isEmpty()) {
            uye yeniUye = new uye(isim, soyisim);
            uyeler.add(yeniUye);
            out.println("Üye başarıyla eklendi!");
            return;
        }


        for (uye u : uyeler) {
            if (u.getIsim().equals(isim) && u.getSoyisim().equals(soyisim)) {
                out.println("Böyle bir üye zaten var!");
                return;
            }
        }


        uye yeniUye = new uye(isim, soyisim);
        uyeler.add(yeniUye);
        out.println("Üye başarıyla eklendi!");
    }

        public void uyeCikar()
        {


            if (uyeler.isEmpty()) {

                out.println("Kütüphanede silinecek bir üye yok!");
                return;

            }
            Iterator<uye> iterator;

                out.print("Lütfen üye ismini giriniz:");
                isim = scanner.nextLine();
                out.print("Lütfen üyenin soyismini giriniz:");
                soyisim=scanner.nextLine();

                iterator =uyeler.iterator();
            while (iterator.hasNext()) {
                uye currentUye=iterator.next();
                if (currentUye.getIsim().equals(isim) && currentUye.getSoyisim().equals(soyisim)) {
                    iterator.remove(); out.println("Üye başarıyla çıkarıldı!");
                    return;
                }

            }
            out.println("Bu üye mevcut değil!");


        }

    public void gorevliEkle() {
        out.print("Lütfen görevli ismini giriniz:");
        isim = scanner.nextLine();
        out.print("Lütfen görevlinin soyismini giriniz:");
        soyisim = scanner.nextLine();

        for (gorevli g : gorevliler) {
            if (g.getIsim().equals(isim) && g.getSoyisim().equals(soyisim)) {
                out.println("Böyle bir görevli zaten var!");
                return;
            }
        }

        gorevli yeniGorevli = new gorevli(isim, soyisim);
        gorevliler.add(yeniGorevli);
        out.println("Görevli başarıyla eklendi!");
    }

    public void gorevliCikar()
    {

        if (gorevliler.isEmpty()) {

            out.println("Kütüphanede silinecek bir görevli yok!");
            return;

        }
        Iterator<gorevli> iterator;
        out.print("Lütfen görevli ismini giriniz:");
        isim = scanner.nextLine();
        out.print("Lütfen görevli soyismini giriniz:");
        soyisim=scanner.nextLine();

        iterator =gorevliler.iterator();
        while (iterator.hasNext()) {
            gorevli currentGorevli=iterator.next();
            if (currentGorevli.getIsim().equals(isim) &&currentGorevli.getSoyisim().equals(soyisim)) {
                iterator.remove();out.println("Görevli başarıyla çıkarıldı");
                return;
            }

        }
        out.println("Bu görevli mevcut değil!");

    }
    public void kitapVer() {

        out.print("Lütfen üye ismini giriniz:");
       isim = scanner.nextLine();
        out.print("Lütfen üye soyismini giriniz:");
        soyisim = scanner.nextLine();


        out.print("Kitap ismini giriniz:");
        String kitap = scanner.nextLine();

        boolean uyeVarMi = false;
        uye currentUye = null;
        for (uye u : uyeler) {
            if (u.getIsim().equals(isim) && u.getSoyisim().equals(soyisim)) {
                uyeVarMi = true;
                currentUye = u;
                break;
            }
        }

        if (!uyeVarMi) {
            out.println("Bu üye mevcut değil!!");
            return;
        }

        boolean kitapVarMi = false;
        kitap currentKitap = null;
        for (kitap k : kitaplar) {
            if (k.getIsim().equals(kitap)) {
                kitapVarMi = true;
                currentKitap = k;
                break;
            }
        }

        if (!kitapVarMi) {
            out.println("Bu kitap mevcut değil!!");
            return;
        }

        if (oduncKitaplar.containsValue(currentKitap)) {
            out.println("Kitap şu anda size verilemiyor!");
            return;
        }

        oduncKitaplar.put(currentUye, currentKitap);
        out.println(" Sayın"+currentUye.getIsim()+" "+ currentUye.getSoyisim()+";\nBuyrun kitabınız:"+currentKitap.getIsim());
    }
    public void kitapIade() {


        out.print("Lütfen üye ismini giriniz:");
        isim = scanner.nextLine();
        out.print("Lütfen üye soyismini giriniz:");
        soyisim= scanner.nextLine();


        out.print("Kitap ismini giriniz:");
        String kitapIsmi = scanner.nextLine();

        boolean uyeVarMi = false;
        uye currentUye = null;
        for (uye u : uyeler) {
            if (u.getIsim().equals(isim) && u.getSoyisim().equals(soyisim)) {
                uyeVarMi = true;
                currentUye = u;
                break;
            }
        }

        if (!uyeVarMi) {
            out.println("Bu üye mevcut değil!");
            return;
        }

        boolean kitapVarMi = false;
        kitap currentKitap = null;
        for (kitap k : kitaplar) {
            if (k.getIsim().equals(kitapIsmi)) {
                kitapVarMi = true;
                currentKitap = k;
                break;
            }
        }

        if (!kitapVarMi) {
            out.println("Bu kitap mevcut değil!");
            return;
        }

        boolean oduncKitapMi = false;
        for (Map.Entry<uye, kitap> entry : oduncKitaplar.entrySet()) {
            if (entry.getKey().getIsim().equals(isim) && entry.getKey().getSoyisim().equals(soyisim) && entry.getValue().getIsim().equals(kitapIsmi)) {
                oduncKitapMi = true;
                break;
            }
        }

        if (!oduncKitapMi) {
            out.println("Bu kitap ödünç verilmemiş");
            return;
        }

        oduncKitaplar.remove(currentUye);
        out.println("Kitap kütüphaneye başarıyla iade edildi");
    }
    public  void oduncKitaplariGoster() {
        if (oduncKitaplar.isEmpty()) {
            out.println("Şu anda ödünç alınmış kitap bulunmamaktadır.");
            return;
        }

        out.println("Ödünç Alınmış Kitaplar:");
        out.println("-----------------------");

        for (Map.Entry<uye, kitap> entry : oduncKitaplar.entrySet()) {
            uye u = entry.getKey();
            kitap k = entry.getValue();
            out.println("Üye: " + u.getIsim() + " " + u.getSoyisim() + " - Kitap: " + k.getIsim());
        }
    }








    static void ekran()
    {


        out.println("\n*****************************************************");
        out.println("1-Kütüphaneye yeni bir kitap ekleme");
        out.println("2-Bir kitabı kütüphaneden çıkarma");
        out.println("3-Kütüphaneye yeni bir üye ekleme");
        out.println("4-Bir üyeyi kütüphaneden çıkarma");
        out.println("5-Kütüphaneye yeni bir görevli ekleme");
        out.println("6-Bir görevliyi kütüphaneden çıkarma");
        out.println("7-Bir üyeye ödünç kitap verme");
        out.println("8-Ödünç alınmış kitabı kütüphaneye bırakma");
        out.println("9-Şu anda ödünç kitapların kimlerde olduğunu takip etme");
        out.println("*******************************************************\n");
    }


    static char islem( Scanner scanner)
    {
        char onay=' ';
        out.println("\nBaşka işlem yapmak istiyor musunuz?");
        out.print("Devam etmek için E veya e bitirmek için h veya H giriniz:");
        onay = scanner.next().charAt(0);

        while (onay != 'E' && onay != 'e' && onay != 'h' && onay != 'H') {
            out.print("geçersiz harf girdiniz lütfen tekrar giriniz:");
            onay = scanner.next().charAt(0);
        }
        return onay;
    }


}

