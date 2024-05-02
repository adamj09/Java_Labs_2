package lab_10.Q3;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class ReadFromURL {
    public static String read(String urlString) {
        String content = "";
        try {
            URL url = new URL(urlString);
            Scanner input = new Scanner(url.openStream());
            while(input.hasNext()) {
                content += input.next() + " "; // Add words to content
            }
        }
        catch(MalformedURLException ex) {
            System.out.println("Invalid URL.");
        }
        catch(IOException ex) {
            System.out.println("Failed to read from URL.");
        }
        return content;
    }
}
