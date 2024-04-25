package class_work_1;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Class_Work_1 {
    public static void main(String[] args) {
        try {
            createTestFiles(); // Create files first
            sortFileTest("Class_Work_1/sampleText.txt", "Class_Work_1/sorted.txt"); // Sort Fileds
        }
        catch(IOException ex) {
            System.out.println(ex);
        }
    }

    public static void sortFileTest(String toSort, String sorted) throws IOException {
        // Get initial, unsorted, unaltered words
        ArrayList<String> content = new ArrayList<>(Arrays.asList(readFile(toSort).split("[ \\t\\n\\r]")));
        
        ArrayList<String> sortedContent = new ArrayList<>();

        // Make all words lowercase and remove trailing punctuation
        for(String word : content) {
            StringBuilder wordLowercase = new StringBuilder(word.toLowerCase()); 
            if(!(wordLowercase.charAt(wordLowercase.length() - 1) > 'a' 
                    && wordLowercase.charAt(wordLowercase.length() - 1) < 'z') 
                    && wordLowercase.length() > 1) {
                wordLowercase.setLength(wordLowercase.length() - 1);
            }
            sortedContent.add(wordLowercase.toString());
        }

        java.util.Collections.sort(sortedContent); // Sort alphabetically
        java.util.Collections.reverse(sortedContent); // Reverse

        for(int i = 0; i < sortedContent.size(); i++) {
            if(sortedContent.get(i).charAt(0) > 'a' && sortedContent.get(i).charAt(0) < 'z') {
                // Display sorted words on terminal
                System.out.println(sortedContent.get(i));
                // Write sorted word to file
                writeToFile(sorted, sortedContent.get(i) + "\n", true);
            }
        }
    }

    // Create files to test with
    public static void createTestFiles() throws IOException {
        // Create unsorted, sample text file
        writeToFile("Class_Work_1/sampleText.txt", """
        1 405 FREEWAY - LOS ANGELES - EARLY EVENING 1
        Christmas tinsel on the light poles. We ARE LOOKING east past
        Inglewood INTO the orange grid of L.A. at night when suddenly
        we TILT UP TO CATCH the huge belly of a landing 747 -- the
        noise is deafening.
        2 INT. 747 - PASSENGERS - SAME 2
        The usual moment just after landing when you let out that sigh
        of relief that you've made it in one piece. As the plane TAXIS
        to its gate, they stir, gather personal belongings.
        3 ON JOHN MCCLANE 3
        mid-thirties, good-looking, athletic and tired from his trip.
        He sits by the window. His relief on landing is subtle, but
        we NOTICE. Suddenly, he hears --
        SALESMAN'S VOICE
        You don't like flying, do you?
        McClane turns, looks at the Babbit clone next to him. Caught,
        he tenses, holds his armrests in exaggerated fear.
        """, false);

        // Create file for sorted words
        writeToFile("Class_Work_1/sorted.txt", "", false);
    }

    public static void writeToFile(String filepath, String content, boolean append) throws IOException {
        FileWriter file = new FileWriter(filepath, append);
        file.append(content);
        file.close();
    }

    public static String readFile(String filepath) throws IOException {
        FileReader reader = new FileReader(filepath);
        
        String content = "";
        for(int i; (i = reader.read()) != -1;) {
            content += (char)i;
        }
        reader.close();
        return content;
    }
}
