
import java.sql.*;

public class ResultSetMetadataDemo {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/college";
        String user = "root";
        String password = "Havana@2006";

        try (Connection con =
                 DriverManager.getConnection(url, user, password);
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM student")) {

            ResultSetMetaData md = rs.getMetaData();

            int count = md.getColumnCount();

            System.out.println("Number of Columns: " + count);

            for (int i = 1; i <= count; i++) {
                System.out.println("\nColumn " + i);
                System.out.println("Name: " +
                    md.getColumnName(i));
                System.out.println("Type: " +
                    md.getColumnTypeName(i));
                System.out.println("Size: " +
                    md.getColumnDisplaySize(i));
                System.out.println("Nullable: " +
                    md.isNullable(i));
                System.out.println("Class: " +
                    md.getColumnClassName(i));
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
