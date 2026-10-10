
import java.sql.*;
import java.util.Scanner;

public class BankTransaction {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/college";
        String user = "root";
        String password = "Havana@2006";

        try (Scanner sc = new Scanner(System.in);
             Connection con = DriverManager.getConnection(
                 url, user, password)) {

            System.out.print("Enter sender account number: ");
            int sender = sc.nextInt();

            System.out.print("Enter receiver account number: ");
            int receiver = sc.nextInt();

            System.out.print("Enter amount to transfer: ");
            double amount = sc.nextDouble();

            if (sender == receiver || amount <= 0) {
                System.out.println("Invalid transaction.");
                return;
            }

            con.setAutoCommit(false);

            try {
                String debitSQL =
                    "UPDATE bank SET balance = balance - ? " +
                    "WHERE account_no = ? AND balance >= ?";

                try (PreparedStatement ps =
                         con.prepareStatement(debitSQL)) {
                    ps.setDouble(1, amount);
                    ps.setInt(2, sender);
                    ps.setDouble(3, amount);

                    if (ps.executeUpdate() != 1) {
                        throw new SQLException(
                            "Sender not found or insufficient balance.");
                    }
                }

                String creditSQL =
                    "UPDATE bank SET balance = balance + ? " +
                    "WHERE account_no = ?";

                try (PreparedStatement ps =
                         con.prepareStatement(creditSQL)) {
                    ps.setDouble(1, amount);
                    ps.setInt(2, receiver);

                    if (ps.executeUpdate() != 1) {
                        throw new SQLException(
                            "Receiver account not found.");
                    }
                }

                con.commit();
                System.out.println("Transaction successful!");
                
            } catch (SQLException e) {
                con.rollback();
                System.out.println("Transaction failed.");
                System.out.println("Reason: " + e.getMessage());
                System.out.println("Changes rolled back.");
            }

            con.setAutoCommit(true);

            System.out.println("\nUpdated Account Details:");

            try (Statement st = con.createStatement();
                 ResultSet rs = st.executeQuery(
                     "SELECT * FROM bank")) {

                while (rs.next()) {
                    System.out.println(
                        rs.getInt("account_no") + "  " +
                        rs.getString("holder") + "  " +
                        rs.getDouble("balance"));
                }
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
