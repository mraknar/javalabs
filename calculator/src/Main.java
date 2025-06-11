import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        double memory = 0; //Bellek değişkeni
        double result = 0;

        while(true){
            System.out.println("\n*** HESAP MAKİNESİ ***");
            System.out.println("*** Yapmak istediğiniz işlemi seçin ***");
            System.out.println("1. Toplama");
            System.out.println("2. Çıkarma");
            System.out.println("3. Çarpma");
            System.out.println("4. Bölme");
            System.out.println("5. Karekök Alma");
            System.out.println("6. Üslü Sayı Hesaplama");
            System.out.println("7. Sonucu Belleğe Kaydet");
            System.out.println("8. Belleği Temizle");
            System.out.println("9. Çıkış");

            Scanner scanner = new Scanner(System.in);

            System.out.println("İşlem numarası girin: ");
            int operation = scanner.nextInt();

            double firstNumber, secondNumber;

            switch(operation){
                case 1:
                    System.out.println("İlk sayıyı girin (Bellekteki değer için 'm'): ");
                    firstNumber = takeInput(memory); //kullanıcıdan input alma

                    System.out.println("İkinci sayıyı girin (Bellekteki değer için 'm'): ");
                    secondNumber = takeInput(memory);

                    result = sum(firstNumber, secondNumber);
                    System.out.println("\nSonuç: " + result);
                    continue;

                case 2:
                    System.out.println("İlk sayıyı girin (Bellekteki değer için 'm'): ");
                    firstNumber = takeInput(memory);

                    System.out.println("İkinci sayıyı girin (Bellekteki değer için 'm'): ");
                    secondNumber = takeInput(memory);

                    result = substract(firstNumber, secondNumber);
                    System.out.println("\nSonuç: " + result);
                    continue;

                case 3:
                    System.out.println("İlk sayıyı girin (Bellekteki değer için 'm'): ");
                    firstNumber = takeInput(memory);

                    System.out.println("İkinci sayıyı girin (Bellekteki değer için 'm'): ");
                    secondNumber = takeInput(memory);

                    result = multiply(firstNumber, secondNumber);
                    System.out.println("\nSonuç: " + result);
                    continue;

                case 4:
                    System.out.println("İlk sayıyı girin (Bellekteki değer için 'm'): ");
                    firstNumber = takeInput(memory);

                    System.out.println("İkinci sayıyı girin (Bellekteki değer için 'm'): ");
                    secondNumber = takeInput(memory);

                    if (secondNumber == 0){
                        System.out.println("Payda 0 olamaz, ana menüye dönülüyor.");
                        continue;
                    }

                    result = divide(firstNumber, secondNumber);
                    System.out.println("\nSonuç: " + result);
                    continue;

                case 5:
                    System.out.println("Sayı girin (Bellekteki değer için 'm'): ");
                    firstNumber = takeInput(memory);

                    result = squareroot(firstNumber);
                    System.out.println("\nSonuç: " + result);
                    continue;

                case 6:
                    System.out.println("İlk sayıyı girin (Bellekteki değer için 'm'): ");
                    firstNumber = takeInput(memory);

                    System.out.println("İkinci sayıyı girin (Bellekteki değer için 'm'): ");
                    secondNumber = takeInput(memory);

                    result = exponent(firstNumber, secondNumber);
                    System.out.println("\nSonuç: " + result);
                    continue;

                case 7:
                    memory = result;
                    System.out.println("Sonuç belleğe kaydedildi.");
                    continue;
                case 8:
                    memory = 0;
                    System.out.println("Bellek temizlendi.");
                    continue;
                case 9:
                    break;
                default:
                    System.out.println("Geçersiz işlem, ana menüye dönülüyor.");
                    continue;

            }
            break;

        }
    }
    public static double takeInput(double memory) {
        Scanner scanner = new Scanner(System.in);

        double number;
        String input = scanner.next(); //input ilk string olarak alınıyor

        if (input.equalsIgnoreCase("M")){ //kullanıcı bellekteki değeri mi kullanacak
            number = memory;
        }else{
            number = Double.parseDouble(input); //bellekteki değer kullanılmayacaksa string double'a çeviriliyor.
        }

        return number;
    }

    // İşlemler
    public static double sum(double a, double b) {
        return a + b;
    }
    public static double substract(double a, double b) {
        return a - b;
    }
    public static double multiply(double a, double b) {
        return a * b;
    }
    public static double divide(double a, double b) {
        return a / b;
    }
    public static double squareroot(double a) {
        return Math.sqrt(a);
    }
    public static double exponent(double a, double b) {
        return Math.pow(a, b);
    }
}