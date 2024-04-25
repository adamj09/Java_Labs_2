package lab_10.Q4;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class BookKeeper {
    private static ArrayList<String> authors = new ArrayList<>();
    private static HashMap<String, String> books = new HashMap<String, String>(); // Book as key, author as value

    // Add new book entries using the console
    public static void bookKeep() {
        Scanner userInput = new Scanner(System.in);

        // Prompt user to add book
        System.out.println("Add a new entry (author and book title on two separate lines):");
        addBook(userInput.nextLine(), userInput.nextLine());

        try { // Update book lists
            updateAuthorList("Lab_10/authors.txt");
            updateBookList("Lab_10/books.txt");
        }
        catch(IOException ex) {
            System.out.println(ex);
        }
        userInput.close();
    }

    // Add a new book to the list
    private static void addBook(String author, String newBook) {
        if(books.containsKey(newBook)) { // If the list contains the book we're trying to add, don't add it
            System.out.println("The list already contains this book!");
            return;
        }
        if(!authors.contains(author)) { // Add author if not already in list
            authors.add(author);
            java.util.Collections.sort(authors); // Make sure list of authors remains in alphabetical order
        }
        books.put(newBook, author);
    }

    // Update the file storing all the authors' names
    private static void updateAuthorList(String authorListPath) throws IOException {
        String authorList = "";
        for(String author : authors) {
            authorList += author + "\n";
        }
        writeToFile(authorListPath, authorList, false);
    }

    // Update the file storing all the book titles and the index of the author of the books
    private static void updateBookList(String bookListPath) throws IOException {
        String bookList = "";
        for(String book : books.keySet()) {
            bookList += (authors.indexOf(books.get(book)) + 1) + " " + book + "\n";
        }
        writeToFile(bookListPath, bookList, false);
    }

    // Write to a file
    private static void writeToFile(String filepath, String content, boolean append) throws IOException {
        FileWriter file = new FileWriter(filepath, append);
        file.append(content);
        file.close();
    }
}
