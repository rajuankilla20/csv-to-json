import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test {

    private static double money =0.0;

    public static void main(String[] args) {

         List<String> list1 = new ArrayList<>();
        list1.add("1");
        list1.add("11");
        list1.add("12");
        list1.add("13");

        List<String> list2 = new ArrayList<>();

        list1.forEach(list2::add);

        list2.forEach(System.out::println);




    }
}
