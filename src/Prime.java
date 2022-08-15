import java.util.Scanner;

/*
    Opgave 7
    Lav et program der kan afgøre om et givet tal n er et primtal.
    a) Udvid programmet så det kan finde alle primtal op til et givet tal n.
    b) Tilføj muligheden for at gemme de fundne primtal i en fil.
    c) Lav en menu hvor det er muligt at teste både enkelte tal og intervaller af tal, samt evt. gemme i en
    given fil.
 */
public class Prime {
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter prime-number");
        int num = in.nextInt();

        boolean flag = false;
        for (int i = 2; i <= num / 2; ++i) {
            // condition for nonprime number
            if (num % i == 0) {
                flag = true;
                break;
            }
        }

        if (!flag) {
            System.out.println(num + " is a prime number.");
        } else {
            System.out.println(num + " is not a prime number.");
        }

        System.out.println("Want to print all primes until "+num+"? (1/0)");
        int bool = in.nextInt();

        if(bool == 1){
            for (int i = 2; i <= num; i++) {
                if (num % i != 0) {
                    System.out.println(i + " is a prime number.");
                }
            }
        }

        System.out.println("Want to save the primes to a file? (1/0)");
        bool = in.nextInt();

        if(bool == 1){
            System.out.println("What should we call the file?");
            String fileName = in.next();
        }
    }
}
