import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test {

    private static double money =0.0;

    public static void main(String[] args) {

        String input = "123456789";     //input string
        String lastFourDigits = "";     //substring containing last 4 characters

        if (input.length() > 4)
        {
            lastFourDigits = input.substring(input.length() - 4);
        }
        else
        {
            lastFourDigits = input;
        }

        System.out.println(lastFourDigits);

    }
}
