import java.util.Scanner;

class Animal {
    void sound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    void sound() {
        System.out.println("Dog barks");
    }
}

class Cat extends Animal {
    void sound() {
        System.out.println("Cat meows");
    }
}

class AnimalDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter animal (dog/cat): ");
        String animal = sc.nextLine();

        if (animal.equalsIgnoreCase("dog")) {
            Dog d = new Dog();
            d.sound();
        } else if (animal.equalsIgnoreCase("cat")) {
            Cat c = new Cat();
            c.sound();
        } else {
            Animal a = new Animal();
            a.sound();
        }
    }
}