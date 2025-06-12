import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while(true) {

            int mode = selectMode(scanner);

            Random random = new Random();
            int number, time, attempt;
            switch (mode) {
                case 1: //kolay mod
                    number = random.nextInt(1, 101);
                    time = 45;
                    attempt = 10;
                    break;
                case 2: //zor mod
                    number = random.nextInt(1, 1001);
                    time = 60;
                    attempt = 15;
                    break;
                default:
                    System.out.println("Geçersiz işlem, ana menüye dönülüyor.");
                    continue;
            }

            gameAttempts(number, time, attempt, mode, scanner);

            System.out.println("\nYeniden oynamak için 1, Çıkış yapmak için 0 basın.");
            if (scanner.nextInt() == 0){
                System.out.println("Çıkış yapılıyor...");
                return;
            }
        }
    }

    public static int selectMode(Scanner scanner){
        System.out.println("\n*** SAYI TAHMİN OYUNU ***");
        System.out.println("*** Oyun Modları ***");
        System.out.println("1. Kolay Mod -> 0-100 aralığı, 45 saniye, 10 deneme");
        System.out.println("2. Zor Mod -> 0-1000 aralığı, 60 saniye, 15 deneme");

        System.out.print("Oynamak istediğiniz modu seçin: ");

        if (! scanner.hasNextInt()) {
            System.out.println("Geçersiz mod, ana menüye dönülüyor.");
            scanner.next();
            return selectMode(scanner);
        }
        return scanner.nextInt();
    }

    public static void gameAttempts(int number, int time, int attempt, int mode, Scanner scanner){
        long time_start = System.currentTimeMillis();

        for (int i = 0; i < attempt; i++) {

            long time_now = (System.currentTimeMillis() - time_start);
            long remaining_time = time * 1000 - time_now;
            if (remaining_time <= 0){ //Süre biterse
                System.out.println("Süreniz bitti. Doğru cevap: "+ number);
                break;
            }

            System.out.println("\nKalan deneme hakkı: "+ (attempt - i) +",  Kalan süre:" + remaining_time/1000);
            System.out.print("Tahmininiz: ");
            if (! scanner.hasNextInt()) { //Sayı harici girilmesi durumunda
                System.out.println("Geçersiz karakter, tekrar deneyin.");
                scanner.next();
                i--;
                continue;
            }
            int guess = scanner.nextInt();

            if (guess == number){
                System.out.println("Tahmininiz doğru!");
                break;
            }

            int difference = number - guess;
            int range = (int) Math.pow(10,mode); //Kullanıcının sayıya yaklaştığını belirleme amaçlı zorluk moduna göre artan değişken

            if (Math.abs(difference) <= range){ //Zorluk moduna göre, 10 veya 100 sayı yakınsa biraz uyarısı
                if (difference > 0) System.out.println("Tahmininiz biraz düşük!");
                else System.out.println("Tahmininiz biraz yüksek!");
            }
            else if (difference > 0) System.out.println("Tahmininiz çok düşük!");

            else System.out.println("Tahmininiz çok yüksek!");


            if (i == attempt-1){ //Deneme hakkı biterse
                System.out.println("Hakkınız bitti. Doğru cevap: "+ number);
                break;
            }
        }
    }
}