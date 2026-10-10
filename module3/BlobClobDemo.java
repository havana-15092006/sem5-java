
import java.sql.*;
import java.io.*;

public class BlobClobDemo {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/college";
        String user = "root";
        String password = "Havana@2006";

        // Store image and text
        String insert =
            "INSERT INTO documents VALUES (?, ?, ?)";

        try (Connection con =
                 DriverManager.getConnection(url, user, password);
             FileInputStream image =
                 new FileInputStream("photo.jpg");
             FileReader text = new FileReader("document.txt");
             PreparedStatement ps = con.prepareStatement(insert)) {

            ps.setInt(1, 1);
            ps.setBinaryStream(2, image);
            ps.setCharacterStream(3, text);
            ps.executeUpdate();

            System.out.println("BLOB and CLOB stored successfully.");

        } catch (IOException | SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Retrieve image and text
        String select =
            "SELECT image_data, text_data FROM documents WHERE id = 1";

        try (Connection con =
                 DriverManager.getConnection(url, user, password);
             PreparedStatement ps = con.prepareStatement(select);
             ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                try (InputStream image = rs.getBinaryStream("image_data");
                     FileOutputStream out =
                         new FileOutputStream("retrieved.jpg");
                     Reader reader = rs.getCharacterStream("text_data");
                     FileWriter writer =
                         new FileWriter("retrieved.txt")) {

                    byte[] buffer = new byte[4096];
                    int bytes;

                    while ((bytes = image.read(buffer)) != -1) {
                        out.write(buffer, 0, bytes);
                    }

                    char[] chars = new char[4096];
                    int count;

                    while ((count = reader.read(chars)) != -1) {
                        writer.write(chars, 0, count);
                    }
                }

                System.out.println("Image saved as retrieved.jpg");
                System.out.println("Text saved as retrieved.txt");
            } else {
                System.out.println("No document found.");
            }

        } catch (IOException | SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
