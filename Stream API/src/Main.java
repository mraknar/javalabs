import java.text.Collator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        //NUMERİK İŞLEMLER
        //4 ile bölünebilen sayılar, intstream
        long numbers_div_four = IntStream.range(1,101)
                .filter(n -> n % 4 == 0)
                .count();
        System.out.println("numbers with dividable 4: " + numbers_div_four);

        //1-100 sayı listesi
        List <Integer> numbers = IntStream.rangeClosed(1,100)
                .boxed() //int to Integer, wrapper class
                .toList();

        //8 ile bölünebilen sayılar, list
        long numbers_div_eight = numbers.stream()
                .filter((n -> n % 8 == 0))
                .count();
        System.out.println("numbers with dividable 8: " + numbers_div_eight);

        //tek sayılar
        long count_odd_numbers = numbers.stream()
                .filter(n -> n % 2 == 1)
                .count();

        long sum_odd_numbers = numbers.stream()
                .filter(n -> n % 2 == 1)
                .mapToInt(e -> e) //Integer to int
                .sum();
        System.out.println("Total number of odd numbers: " + count_odd_numbers + ", sum: " + sum_odd_numbers);

        //çift sayılar
        long count_even_numbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .count();

        long sum_even_numbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(e -> e)
                .sum();
        System.out.println("Total number of even numbers: " + count_even_numbers + ", sum: " + sum_even_numbers);

        //asal sayılar
        long count_prime_numbers = numbers.stream()
                .filter(Main::isPrime)
                .count();
        System.out.println("Total number of prime numbers: " + count_prime_numbers);

        //3'ün katlarını 2 ile çarpıp toplamı bulma
        long count_div_three = numbers.stream()
                .filter(n -> n % 3 == 0)
                .map(n -> n * 2)
                .mapToInt(e -> e)
                .sum();
        System.out.println("Sum of the multiples of 3 multiplied by 2: " + count_div_three);


        //ALFABETİK İŞLEMLER
        List<String> cities = List.of(
                "Gaziantep", "Adana", "Çankırı", "Niğde", "Sakarya", "Çorum",
                "İzmir", "Konya", "Denizli", "Antalya", "Rize", "Nevşehir", "Kars", "Malatya",
                "Ağrı", "Kastamonu", "Ordu", "İstanbul", "Hakkari", "Ankara", "Edirne", "Bursa"
        );

        //A ile başlayan kelime sayısı
        long starts_with_a = cities.stream()
                .filter(s -> s.startsWith("A"))
                .count();
        System.out.println("\nNumber of cities starts with A: " + starts_with_a);

        //Tüm kelimeleri büyük harfe çevirip alfabetik sıralama
        System.out.println("Upper case and alphabetical: ");
        Collator turkishSort = Collator.getInstance(new Locale("tr", "TR")); //for turkish sorting
        cities.stream()
                .map(String::toUpperCase)
                //.sorted()
                .sorted(turkishSort)
                .forEach(s -> System.out.print(s + " "));

        //5 harften kısa şehirleri ters sırada yazdırma
        System.out.println("\nLess than 5 letters reversed: ");
        cities.stream()
                .filter(s -> s.length() <= 5)
                .sorted(turkishSort.reversed())
                .forEach(s -> System.out.print(s + " "));

        //Kelime uzunluğuna göre gruplama
        Map<Integer, List<String>> cities_grouped = cities.stream()
                .collect(Collectors.groupingBy(String::length));
        System.out.println("\nGrouped with word length: " + cities_grouped);
    }


    //asal sayı kontrolü
    public static boolean isPrime(int number){
        if (number <= 1){
            return false;
        }
        for (int i = 2; i < number; i++){
            if (number % i == 0){
                return false;
            }
        }
        return true;
    }
}