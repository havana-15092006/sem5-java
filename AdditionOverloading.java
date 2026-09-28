import java.util.Scanner;

class Calculator {

    int add(int a, int b) {
        return a + b;
    }

    int add(int a, int b, int c) {
        return a + b + c;
    }

    double add(double a, double b) {
        return a + b;
    }
}

class AdditionOverloading {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Calculator c = new Calculator();

        System.out.print("Enter first integer: ");
        int a = sc.nextInt();

        System.out.print("Enter second integer: ");
        int b = sc.nextInt();

        System.out.print("Enter third integer: ");
        int d = sc.nextInt();

        System.out.print("Enter first double: ");
        double x = sc.nextDouble();

        System.out.print("Enter second double: ");
        double y = sc.nextDouble();

        System.out.println("Sum of two integers = " + c.add(a, b));
        System.out.println("Sum of three integers = " + c.add(a, b, d));
        System.out.println("Sum of two doubles = " + c.add(x, y));
    }
}