
import java.sql.*;
import java.util.Scanner;

public class CallableDemo {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/college";
        String user = "root";
        String password = "Havana@2006";

        try (Scanner sc = new Scanner(System.in);
             Connection con =
                 DriverManager.getConnection(url, user, password)) {

            System.out.print("Enter roll number: ");
            int id = sc.nextInt();

            try (CallableStatement cs =
                     con.prepareCall("{CALL GetStudent(?)}")) {

                cs.setInt(1, id);

                try (ResultSet rs = cs.executeQuery()) {
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
            System.out.println("Error: " + e.getMessage());
        }
    }
}
