import java.util.Scanner;

class Bilgisayar {
    private String tur;
    private double fiyat;

    public Bilgisayar(String tur, double fiyat) {
        this.tur = tur;
        this.fiyat = fiyat;
    }

    public String OzellikleriGetir() {
        return "Tür: " + tur + ", Fiyat: " + fiyat + "TL";
    }

    public double FiyatGetir() {
        return fiyat;
    }

    public String TurGetir() {
        return tur;
    }
}

public class ATM {
    static double Para = 100;

    public static void main(String[] Args) {

        boolean IslemDurumu = true;
        while (IslemDurumu) {
            System.out.println("""
                    1:Bakiye Sorgulama
                    2:Para Çekme
                    3:Para Yatırma
                    4:Mağaza
                    5:Çıkış
                    """);
            System.out.println("Yapmak istediğiniz işlem numarasını giriniz: ");
            Scanner scannerIslemNumarası = new Scanner(System.in);
            int IslemNumarası = scannerIslemNumarası.nextInt();

            if (IslemNumarası >= 1 && IslemNumarası <= 5) {

                switch (IslemNumarası) {
                    case 1:
                        System.out.println("Mevcut bakiyeniz " + Para + "TL.");
                        break;
                    case 2:
                        double ParaCekmeMiktari = MiktarAl("Çekmek istediğiniz miktarı giriniz: ");
                        ParaCek(ParaCekmeMiktari);
                        break;
                    case 3:
                        double ParaYatirmaMiktari = MiktarAl("Yatırmak istediğiniz miktarı giriniz: ");
                        ParaYatir(ParaYatirmaMiktari);
                        break;
                    case 4:
                        Bilgisayar[] bilgisayarlar = {
                                new Bilgisayar("Kötü Bilgisayar", 1000),
                                new Bilgisayar("Orta Bilgisayar", 2000),
                                new Bilgisayar("Süper Bilgisayar", 3000)

                        };
                        System.out.println("Mevcut Mağaza Ürünleri:");
                        for (int i = 0; i < bilgisayarlar.length; i++) {
                            System.out.println((i + 1) + ". " + bilgisayarlar[i].OzellikleriGetir());
                        }
                        Scanner scan = new Scanner(System.in);
                        System.out.println("Satın almak istediğiniz ürün numarasını girin: ");
                        int secim = scan.nextInt();

                        if (secim >= 1 && secim <= bilgisayarlar.length) {
                            Bilgisayar secilenBilgisayar = bilgisayarlar[secim - 1];
                            double BilgisayarUcreti = secilenBilgisayar.FiyatGetir();
                            if (Para >= BilgisayarUcreti) {
                                Para -= BilgisayarUcreti;
                                System.out.println(
                                        secilenBilgisayar.TurGetir() + " Adlı ürünü " + secilenBilgisayar.FiyatGetir()
                                                + "TL'ye satın aldın. Mevcut bakiyen: " + Para + "TL.");
                            } else {
                                System.out.println("Yetersiz Bakiye!");
                            }

                        } else {
                            System.out.println("Geçersiz seçim!");
                        }

                        break;
                    case 5:
                        System.out.println("Sistemden çıkılıyor...");
                        IslemDurumu = false;
                }
            } else {
                System.out.println("Hatalı işlem numarası, lütfen tekrar deneyin.");
            }
        }

    }

    public static double MiktarAl(String mesaj) {
        System.out.println(mesaj);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextDouble();
    }

    public static void ParaCek(double miktar) {
        if (Para >= miktar) {
            Para -= miktar;
            System.out.println("Hesabından " + miktar + "TL para çektin. Mevcut bakiyen: " + Para + "TL.");
        } else {
            System.out.println("Hesabında çekmek istediğin miktarda para mevcut değil!");
        }
    }

    public static void ParaYatir(double miktar) {
        Para += miktar;
        System.out.println("Hesabına " + miktar + "TL para yatırdın. Mevcut bakiyen: " + Para);
    }

}
