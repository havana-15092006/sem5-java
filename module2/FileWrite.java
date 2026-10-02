import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class FileWrite {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = sc.nextLine();

        try {

            FileOutputStream fos =
                    new FileOutputStream("new.txt", true);

            fos.write((text + "\n").getBytes());

            fos.close();

            System.out.println("Data written successfully.");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}