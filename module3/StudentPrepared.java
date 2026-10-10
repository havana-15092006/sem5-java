
import java.sql.*;
import java.util.Scanner;

public class StudentPrepared {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/college";
        String user = "root";
        String password = "Havana@2006";

        try (Scanner sc = new Scanner(System.in);
             Connection con =
                 DriverManager.getConnection(url, user, password)) {

            System.out.print("Enter roll number: ");
            int roll = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter name: ");
            String name = sc.nextLine();

            System.out.print("Enter course: ");
            String course = sc.nextLine();

            System.out.print("Enter marks: ");
            double marks = sc.nextDouble();

            String insert =
                "INSERT INTO student VALUES (?, ?, ?, ?)";

            try (PreparedStatement ps =
                     con.prepareStatement(insert)) {

                ps.setInt(1, roll);
                ps.setString(2, name);
                ps.setString(3, course);
                ps.setDouble(4, marks);

                ps.executeUpdate();
                System.out.println("Student registered successfully.");
            }

            System.out.print("Enter roll number to search: ");
            int searchRoll = sc.nextInt();

            String search =
                "SELECT * FROM student WHERE rollno = ?";

            try (PreparedStatement ps =
                     con.prepareStatement(search)) {

                ps.setInt(1, searchRoll);

                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        System.out.println("Roll No: " +
                            rs.getInt("rollno"));
                        System.out.println("Name: " +
                            rs.getString("name"));
                        System.out.println("Course: " +
                            rs.getString("course"));
                        System.out.println("Marks: " +
                            rs.getDouble("marks"));
                    } else {
                        System.out.println("Student not found.");
                    }
                }
            }

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        } catch (java.util.InputMismatchException e) {
            System.out.println("Invalid input. Enter numbers correctly.");
        }
    }
}
