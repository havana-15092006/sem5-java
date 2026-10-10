
import java.sql.*;

public class JdbcException {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/college";
        String user = "root";
        String password = "Havana@2006";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                url, user, password);

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(
                "SELECT * FROM student");

            while (rs.next()) {
                System.out.println(
                    rs.getInt("rollno") + " " +
                    rs.getString("name") + " " +
                    rs.getString("course") + " " +
                    rs.getDouble("marks"));
            }

            rs.close();
            st.close();
            con.close();

        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found.");
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Program execution completed.");
        }
    }
}
