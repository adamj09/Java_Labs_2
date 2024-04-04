package lab_8_1;

import java.io.*;

public class FileSystem {
    public static void fileTest(String filepath) {
        try {
            writeToFile(filepath, """
            {Man} Once upon a time there was a lovely princess.
            But she had an enchantment upon her of a fearful sort which could only 
            be broken by love's first kiss.
            She was locked away in a castle guarded by a terrible fire-breathing 
            dragon.
            Many brave knigts had attempted to free her from this dreadful prison, 
            but non prevailed.
            She waited in the dragon's keep in the highest room of the tallest 
            tower for her true love and true love's first kiss.
            {Laughing} 
            Like that's ever gonna happen.
            {Paper Rusting, Toilet Flushes}
            What a load of - 
            Somebody once told me the world is gonna roll me
            I ain't the sharpest tool in the shed
            She was lookin' kind of dumb with her finger and her thumb
            In the shape of an "L" on her forehead
            The years start comin' and they don't stop comin'
            Fed to the rules and hit the ground runnin'
            Didn't make sense not to live for fun
            Your brain gets smart but your head gets dumb
            So much to do so much to see
            So what's wrong with takin' the backstreets
            You'll never know if you don't go
            You'll never shine if you don't glow
            Hey, now You're an all-star
            Get your game on, go play
            Hey, now You're a rock star
            Get the show on, get paid
            """, false);
            System.out.printf("--- File Info for: %s ---\n - Character count: %d\n - Word count: %d\n - Line count: %d\n", 
                filepath, characterCount(filepath), wordCount(filepath), lineCount(filepath));
        }
        catch(IOException ex) {
            System.out.println("Failed to write to file.");
        }
    }

    public static int characterCount(String filepath) throws IOException{
        return readFile(filepath).replaceAll("[ \\t\\n\\r]", "").length();
    }

    public static int wordCount(String filepath) throws IOException {
        return readFile(filepath).split("[ \\t\\n\\r]").length;
    }

    public static int lineCount(String filepath) throws IOException {
        return readFile(filepath).split("\n").length;
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