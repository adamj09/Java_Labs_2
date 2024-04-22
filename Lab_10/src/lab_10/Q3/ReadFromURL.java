package lab_10.Q3;

import java.net.MalformedURLException;
import java.net.URL;

public class ReadFromURL {
    public static String read(String urlString) {
        try {
            URL url = new URL(urlString);
        }
        catch(MalformedURLException ex) {
            System.out.println("Invalid URL.");
        }
        
    }
}
