
import java.sql.*;

public class ResultSetNavigation {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/college";
        String user = "root";
        String password = "Havana@2006";

        String sql = "SELECT * FROM student ORDER BY rollno";

        try (Connection con =
                 DriverManager.getConnection(url, user, password);
             Statement st = con.createStatement(
                 ResultSet.TYPE_SCROLL_INSENSITIVE,
                 ResultSet.CONCUR_READ_ONLY);
             ResultSet rs = st.executeQuery(sql)) {

            if (rs.next())
                show(rs, "next()");

            if (rs.next())
                show(rs, "next()");

            if (rs.previous())
                show(rs, "previous()");

            if (rs.first())
                show(rs, "first()");

            if (rs.last())
                show(rs, "last()");

            if (rs.absolute(2))
                show(rs, "absolute(2)");

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    static void show(ResultSet rs, String method)
            throws SQLException {
        System.out.println(method + " -> " +
            rs.getInt("rollno") + " " +
            rs.getString("name"));
    }
}
