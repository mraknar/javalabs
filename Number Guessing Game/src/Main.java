import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        while(true) {
            System.out.println("\n*** SAYI TAHMİN OYUNU ***");
            System.out.println("*** Oyun Modları ***");
            System.out.println("1. Kolay Mod -> 0-100 aralığı, 60 saniye, 12 deneme");
            System.out.println("2. Zor Mod -> 0-1000 aralığı, 90 saniye, 18 deneme");

            Scanner scanner = new Scanner(System.in);
            System.out.print("Oynamak istediğiniz modu seçin: ");
            if (!scanner.hasNextInt()) {
                System.out.println("Geçersiz mod, ana menüye dönülüyor.");
                continue;
            }
            int operation = scanner.nextInt();

            Random random = new Random();
            int number, time, attempt;
            switch (operation) {
                case 1:
                    number = random.nextInt(1, 101);
                    time = 60;
                    attempt = 12;
                    break;
                case 2:
                    number = random.nextInt(1, 1001);
                    time = 90;
                    attempt = 18;
                    break;
                default:
                    System.out.println("Geçersiz işlem, ana menüye dönülüyor.");
                    continue;
            }
            System.out.println(number);
            long time_start = System.currentTimeMillis();

            for (int i = 0; i < attempt; i++) {

                long time_now = (System.currentTimeMillis() - time_start);
                long remaining_time = time * 1000 - time_now;
                if (remaining_time <= 0){
                    System.out.println("Süreniz bitti. Doğru cevap: "+ number);
                    break;
                }

                System.out.println("\nKalan deneme hakkı: "+ (attempt - i) +",  Kalan süre:" + remaining_time/1000);
                System.out.print("Tahmininiz: ");
                if (! scanner.hasNextInt()) {
                    System.out.println("Geçersiz karakter, tekrar deneyin.");
                    scanner.next();
                    i--;
                    continue;
                }
                int guess = scanner.nextInt();

                if (guess == number){
                    System.out.println("Tahmininiz doğru!");
                    break;
                }else if ((number - guess) > 0 && (number - guess) <= Math.pow(10,operation)){
                    System.out.println("Tahmininiz biraz düşük!");
                }else if ((number - guess) < 0 && (number - guess) >= -Math.pow(10,operation)){
                    System.out.println("Tahmininiz biraz yüksek!");
                }else if ((number - guess) > 0){
                    System.out.println("Tahmininiz çok düşük!");
                }else if ((number - guess) < 0){
                    System.out.println("Tahmininiz çok yüksek!");
                }

                if (i == attempt-1){
                    System.out.println("Hakkınız bitti. Doğru cevap: "+ number);
                    break;
                }
            }
            System.out.println("\nYeniden oynamak için 1, Çıkış yapmak için 0");
            if (scanner.nextInt() == 0){
                System.out.println("Çıkış yapılıyor...");
                break;
            };
        }
    }
}