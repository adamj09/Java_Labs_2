package lab_8_1;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Q2.randNumTest();
    }

    public static void writeToFile(String filepath, String content) throws IOException {
        FileWriter file = new FileWriter(filepath, true);
        file.append(content);
        file.close();
    }

    public static String readFile(String filepath) throws IOException {
        FileReader reader = new FileReader(filepath);
            
        String content = "";
        int i;
        while((i = reader.read()) != -1) {
            content += (char)i;
        }
        reader.close();
        return content;
    }
}
