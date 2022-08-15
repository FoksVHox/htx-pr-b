import java.util.Scanner;
/*
    Opgave 1
    Lav et program der alt efter brugerens valg kan udskrive de første 20 tal i 1, 2, 3, og op til 20-tabellen.
 */
public class TablePrinter {
    public static void main(String[] args)
    {
        // Using Scanner for Getting Input from User
        Scanner in = new Scanner(System.in);

        System.out.println("Enter a tabel");

        int a = in.nextInt();
        if(a > 0){
            System.out.println("You entered integer " + a);
            for (int i = 1; i <= 20; i++) {
                System.out.println("Det "+i+". tal er " + a*i);
            }
        }

    }
}
