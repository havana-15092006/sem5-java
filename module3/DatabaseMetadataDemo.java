
import java.sql.*;

public class DatabaseMetadataDemo {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/college";
        String user = "root";
        String password = "Havana@2006";

        try (Connection con =
                 DriverManager.getConnection(url, user, password)) {

            DatabaseMetaData md = con.getMetaData();

            System.out.println("Database Name: " +
                md.getDatabaseProductName());

            System.out.println("Database Version: " +
                md.getDatabaseProductVersion());

            System.out.println("Driver Name: " +
                md.getDriverName());

            System.out.println("Driver Version: " +
                md.getDriverVersion());

            System.out.println("Transactions Supported: " +
                md.supportsTransactions());

            System.out.println("Batch Updates Supported: " +
                md.supportsBatchUpdates());

            System.out.println("\nAvailable Tables:");

            try (ResultSet rs = md.getTables(
                    "college", null, "%", new String[]{"TABLE"})) {

                while (rs.next()) {
                    System.out.println(rs.getString("TABLE_NAME"));
                }
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
