import java.io.*;
import java.util.Scanner;

public class EmployeeRecord {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

            DataOutputStream dos =
                    new DataOutputStream(
                            new FileOutputStream("employees.dat"));

            System.out.print("Enter Employee ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Salary: ");
            double salary = sc.nextDouble();

            dos.writeInt(id);
            dos.writeUTF(name);
            dos.writeDouble(salary);

            dos.close();

            DataInputStream dis =
                    new DataInputStream(
                            new FileInputStream("employees.dat"));

            System.out.println("\nEmployee Details");

            System.out.println("ID: " + dis.readInt());
            System.out.println("Name: " + dis.readUTF());
            System.out.println("Salary: " + dis.readDouble());

            dis.close();

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}