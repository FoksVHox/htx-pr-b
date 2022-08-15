import java.util.Scanner;

/*
    Opgave 2
    Lav et program med en menu der kan gentages indtil brugeren vælger at stoppe programmet, og som kan
    beregne omkreds og areal af de tre forskellige figurtyper: Cirkel, rektangel og trekant.
 */
public class Geometry {
    public static void main(String[] args)
    {
        // Using Scanner for Getting Input from User
        Scanner in = new Scanner(System.in);

        System.out.println("Choose a form");
        System.out.println("1. Circle");
        System.out.println("2. Triangle");
        System.out.println("3. Rectangle");

        int a = in.nextInt();

        switch (a) {
            case 1 -> circle();
            case 2 -> triangle();
            case 3 -> rectangle();
        }

    }

    private static void rectangle() {
        Scanner in = new Scanner(System.in);
        System.out.println("Mode: Rectangle");

        System.out.println("Enter a X");
        int x = in.nextInt();

        System.out.println("Enter a Y");
        int y = in.nextInt();

        System.out.println("Area of rectangle is: "+(x*y));
    }

    private static void triangle() {
        Scanner in = new Scanner(System.in);
        System.out.println("Mode: Triangle");

        System.out.println("Enter a X");
        float x = in.nextFloat();

        System.out.println("Enter a Y");
        float y = in.nextFloat();

        double area = (x*y)/2;

        System.out.println("Area of triangle is: "+area);
    }

    private static void circle() {
        Scanner in = new Scanner(System.in);
        System.out.println("Mode: Circle");

        System.out.println("Enter a R");
        int r = in.nextInt();
        double area = Math.PI * r * r;
        System.out.println("Area of circle is: "+area);
    }
}
