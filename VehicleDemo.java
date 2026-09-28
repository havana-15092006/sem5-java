import java.util.Scanner;

abstract class Vehicle {

    abstract void start();

    void display() {
        System.out.println("This is a vehicle.");
    }
}

class Car extends Vehicle {

    void start() {
        System.out.println("Car starts with a key.");
    }
}

class Bike extends Vehicle {

    void start() {
        System.out.println("Bike starts with a self-start.");
    }
}

class VehicleDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter vehicle (car/bike): ");
        String choice = sc.nextLine();

        Vehicle v;

        if (choice.equalsIgnoreCase("car"))
            v = new Car();
        else
            v = new Bike();

        v.display();
        v.start();
    }
}