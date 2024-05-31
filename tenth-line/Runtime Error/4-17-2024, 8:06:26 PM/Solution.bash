// https://leetcode.com/problems/tenth-line

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PrintTenthLine {

    public static void main(String[] args) throws IOException {
        String filePath = "file.txt"; // Replace with your file path
        int targetLine = 10;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int currentLine = 1;
            while ((line = reader.readLine()) != null) {
                if (currentLine == targetLine) {
                    System.out.println(line);
                    break;
                }
                currentLine++;
            }
            if (currentLine < targetLine) {
                System.out.println("File has less than 10 lines.");
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
