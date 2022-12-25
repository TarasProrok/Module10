package module10;
import java.util.regex.*;
import java.io.*;

public class ValidPhoneNumbersToConsole {
    public static void main(String[] args) throws IOException {
        String patterns
                = "^((\\(\\d{3}\\))|\\d{3})[ .]?\\d{3}[-.]?\\d{4}$"
                + "|^(\\d{3})[-.]?\\d{3}[-.]?\\d{4}$";
        Pattern pattern = Pattern.compile(patterns);
        try (BufferedReader br = new BufferedReader
                (new FileReader("/Users/mac/Desktop/Java/HelloWorld/src/module10/file1.txt"))) {
            String line = br.readLine();
            while (line != null) {
                Matcher m = pattern.matcher(line);
                while (m.find()) {
                    System.out.println(line);
                }
                line = br.readLine();
            }
        }
    }
}
