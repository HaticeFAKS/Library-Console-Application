/*   Kahdije FAKSH    1220505802   */

import static java.lang.System.out;
import  java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        char onay = 'E', secim = ' ';
        kutuphane kutuphanemiz = new kutuphane();

        out.println("\n********************************");
        out.println("Kütüphane sistemine hoşgeldiniz!");
        out.println("********************************");

        while (onay == 'E' || onay == 'e') {

            kutuphane.ekran();
            out.print("Lütfen yapmak istediğiniz işlemi seçiniz:");
            secim = scanner.next().charAt(0);
            switch (secim) {
                case '1':
                    kutuphanemiz.kitapEkle();
                    break;
                case '2':
                    kutuphanemiz.kitapCikar();
                    break;
                case '3':
                    kutuphanemiz.uyeEkle();
                    break;
                case '4':
                    kutuphanemiz.uyeCikar();
                    break;
                case '5':
                    kutuphanemiz.gorevliEkle();
                    break;
                case '6':
                    kutuphanemiz.gorevliCikar();
                    break;
                case '7':kutuphanemiz.kitapVer();
                    break;
                case '8':kutuphanemiz.kitapIade();
                    break;
                case '9':kutuphanemiz.oduncKitaplariGoster();
                    break;
                default:
                    out.println("Geçersiz seçim girdiniz!");
                    break;
            }
            onay = kutuphane.islem(scanner);


        }
        out.println("İşleminiz bitmiştir. Güle güle!");
    }
}



