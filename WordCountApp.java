import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class WordCountApp {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Word Count Program");
        System.out.print("Enter '1' to input text or '2' to provide a file: ");
        int c = in.nextInt();
        in.nextLine();

        String text = "";

        if (c == 1) {
            System.out.print("Enter the text: ");
            text = in.nextLine();
        } else if (c == 2) {
            System.out.print("Enter the file path: ");
            String filePath = in.nextLine();
            try {
                text = readFile(filePath);
            } catch (IOException e) {
                System.out.println("Error reading the file: " + e.getMessage());
                System.exit(1);
            }
        } else {
            System.out.println("Invalid ! Reenter the input again.");
            System.exit(1);
        }

        String[] w = text.split("[\\s\\p{Punct}]+");

        int wordCount = w.length;

        System.out.println("Total word count is : " + wordCount);

        in.close();
    }

    private static String readFile(String filePath) throws IOException {
        StringBuilder c = new StringBuilder();
        BufferedReader r = new BufferedReader(new FileReader(filePath));
        String line;

        while ((line = r.readLine()) != null) {
            c.append(line).append("\n");
        }

        r.close();
        return c.toString();
    }
}
