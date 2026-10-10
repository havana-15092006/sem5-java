
import java.sql.*;

public class JdbcConnect {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/college";
        String user = "root";
        String password = "Havana@2006";

        try (Connection con =
                 DriverManager.getConnection(url, user, password)) {

            System.out.println("Database connected successfully!");

        } catch (SQLException e) {
            System.out.println("Connection failed!");
            System.out.println(e.getMessage());
        }
    }
}
