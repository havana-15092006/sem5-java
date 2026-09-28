import java.util.Scanner;

class Box {

    double length;
    double breadth;
    double height;

    // No dimension
    Box() {
        length = 0;
        breadth = 0;
        height = 0;
    }

    // One dimension
    Box(double side) {
        length = side;
        breadth = side;
        height = side;
    }

    // Three dimensions
    Box(double length, double breadth, double height) {
        this.length = length;
        this.breadth = breadth;
        this.height = height;
    }

    // Volume methods
    double volume() {
        return 0;
    }

    double volume(double side) {
        return side * side * side;
    }

    double volume(double length, double breadth, double height) {
        return length * breadth * height;
    }
}

class BoxDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Box b1 = new Box();

        System.out.print("Enter side of cube: ");
        double side = sc.nextDouble();

        Box b2 = new Box(side);

        System.out.print("Enter length: ");
        double length = sc.nextDouble();

        System.out.print("Enter breadth: ");
        double breadth = sc.nextDouble();

        System.out.print("Enter height: ");
        double height = sc.nextDouble();

        Box b3 = new Box(length, breadth, height);

        System.out.println("Volume of default box = " + b1.volume());
        System.out.println("Volume of cube = " + b2.volume(side));
        System.out.println("Volume of box = " +
                b3.volume(length, breadth, height));
    }
}