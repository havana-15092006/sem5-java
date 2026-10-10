
import java.sql.*;

public class StudentCRUD {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/college";
        String user = "root";
        String password = "Havana@2006";

        try (Connection con =
                 DriverManager.getConnection(url, user, password);
             Statement st = con.createStatement()) {

            st.executeUpdate(
                "INSERT INTO student VALUES (104,'ARUN','BCA',80)"
            );
            System.out.println("Record inserted.");

            st.executeUpdate(
                "UPDATE student SET marks=90 WHERE rollno=104"
            );
            System.out.println("Record updated.");

            st.executeUpdate(
                "DELETE FROM student WHERE rollno=104"
            );
            System.out.println("Record deleted.");

            ResultSet rs = st.executeQuery(
                "SELECT * FROM student"
            );

            System.out.println("\nStudent Records");

            while (rs.next()) {
                System.out.println(
                    rs.getInt("rollno") + " " +
                    rs.getString("name") + " " +
                    rs.getString("course") + " " +
                    rs.getDouble("marks")
                );
            }

            rs.close();

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
