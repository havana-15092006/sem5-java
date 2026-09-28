import java.util.Scanner;

class Rectangle {

    int length;
    int breadth;

    // Default constructor
    Rectangle() {
        length = 1;
        breadth = 1;
    }

    // Parameterized constructor
    Rectangle(int length, int breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    // Square constructor
    Rectangle(int side) {
        length = side;
        breadth = side;
    }

    void area() {
        System.out.println("Area = " + (length * breadth));
    }
}

class RectangleDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Rectangle r1 = new Rectangle();

        System.out.print("Enter length: ");
        int length = sc.nextInt();

        System.out.print("Enter breadth: ");
        int breadth = sc.nextInt();

        Rectangle r2 = new Rectangle(length, breadth);

        System.out.print("Enter side of square: ");
        int side = sc.nextInt();

        Rectangle r3 = new Rectangle(side);

        System.out.println("Default rectangle:");
        r1.area();

        System.out.println("Parameterized rectangle:");
        r2.area();

        System.out.println("Square:");
        r3.area();
    }
}