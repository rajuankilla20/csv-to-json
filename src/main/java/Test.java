import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test {

    private static double money =0.0;

    public static void main(String[] args) {

        Set<String> items = new HashSet<>();

        items.add("20 Quarter Pound");
        items.add("3 Musketeers");
        items.add("A Taste Of Thai");
        items.add("A Taste Of Thai");
        items.add("A1");
        items.add("Activia");
        System.out.println("---FINAL ITEMS");
        items.forEach(System.out::println);
        System.out.println("---FINAL ITEMS SIZE "+ items.size());



    }
}
