import java.util.Scanner;

class Shape {
    void draw() {
        System.out.println("Drawing a shape");
    }
}

class Circle extends Shape {
    void draw() {
        System.out.println("Drawing a circle");
    }
}

class RectangleShape extends Shape {
    void draw() {
        System.out.println("Drawing a rectangle");
    }
}

class DynamicDispatch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter shape (circle/rectangle): ");
        String choice = sc.nextLine();

        Shape s;

        if (choice.equalsIgnoreCase("circle")) {
            s = new Circle();
        } else {
            s = new RectangleShape();
        }

        s.draw();
    }
}