import java.util.Scanner;

class Employee {
    String name;
    int id;
    double salary;

    void display() {
        System.out.println("Name = " + name);
        System.out.println("ID = " + id);
        System.out.println("Salary = " + salary);
        System.out.println();
    }
}

class EmployeeDetails {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Employee e1 = new Employee();
        Employee e2 = new Employee();
        Employee e3 = new Employee();

        System.out.println("Enter details of Employee 1:");
        System.out.print("Name: ");
        e1.name = sc.next();
        System.out.print("ID: ");
        e1.id = sc.nextInt();
        System.out.print("Salary: ");
        e1.salary = sc.nextDouble();

        System.out.println("\nEnter details of Employee 2:");
        System.out.print("Name: ");
        e2.name = sc.next();
        System.out.print("ID: ");
        e2.id = sc.nextInt();
        System.out.print("Salary: ");
        e2.salary = sc.nextDouble();

        System.out.println("\nEnter details of Employee 3:");
        System.out.print("Name: ");
        e3.name = sc.next();
        System.out.print("ID: ");
        e3.id = sc.nextInt();
        System.out.print("Salary: ");
        e3.salary = sc.nextDouble();

        System.out.println("\nEmployee Details:");

        e1.display();
        e2.display();
        e3.display();
    }
}