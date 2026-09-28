import java.util.Scanner;

class Student {
    String name;
    int rollNo;
    double mark;

    void display() {
        System.out.println("Name = " + name);
        System.out.println("Roll No = " + rollNo);
        System.out.println("Mark = " + mark);
    }
}

class StudentDetails {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Student s = new Student();

        System.out.print("Enter name: ");
        s.name = sc.nextLine();

        System.out.print("Enter roll number: ");
        s.rollNo = sc.nextInt();

        System.out.print("Enter mark: ");
        s.mark = sc.nextDouble();

        s.display();
    }
}