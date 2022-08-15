import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
    Opgave 4
    Lav et program der tager en tekststreng fra brugeren og udskriver bogstaverne i alfabetisk rækkefølge.
 */

public class AlfaSorter {
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter string");
        String input = in.nextLine();

        char parts[] = input.toCharArray();
        char temp;

        int i = 0;
        while (i < parts.length) {
            int j = i + 1;
            while (j < parts.length) {
                if (parts[j] < parts[i]) {

                    // Comparing the characters one by one
                    temp = parts[i];
                    parts[i] = parts[j];
                    parts[j] = temp;
                }
                j += 1;
            }
            i += 1;
        }
        // By now loop is done means we have
        // iterated the whole array
        System.out.println(parts);
    }
}
