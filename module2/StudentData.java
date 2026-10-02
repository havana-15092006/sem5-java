import java.io.*;

public class StudentData {

    public static void main(String[] args) {

        try {

            DataOutputStream dos =
                    new DataOutputStream(
                            new FileOutputStream("student.dat"));

            dos.writeInt(101);
            dos.writeUTF("Havana");
            dos.writeDouble(85.5);

            dos.close();

            DataInputStream dis =
                    new DataInputStream(
                            new FileInputStream("student.dat"));

            int roll = dis.readInt();
            String name = dis.readUTF();
            double marks = dis.readDouble();

            dis.close();

            System.out.println("Roll Number: " + roll);
            System.out.println("Name: " + name);
            System.out.println("Marks: " + marks);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}