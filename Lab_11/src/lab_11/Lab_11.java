package lab_11;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Lab_11 {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        while(true){ // Run app (with menu)
            System.out.println("--- Demos ---\n [1] Generic Stack Test\n [2] Generic Queue Test\n " + 
                "[3] Linked List Test\n [4] Priority Queue Test\n [5] Exit");
            try { 
                switch (userInput.nextInt()) { // Get choice of demo from user
                    case 1: // Q1
                        genericStackTest();
                        break;
                    case 2: // Q1
                        genericQueueTest();
                        break;
                    case 3: // Q2
                        linkedListTest();
                        break;
                    case 4: // Q3
                        priorityQueueTest();
                        break;
                    case 5: // Exit app
                        userInput.close();
                        System.exit(0);
                    default: // Invalid number
                        throw new InputMismatchException();
                }
                System.out.println(); // Add spacing between menu and demo
            }
            catch(InputMismatchException ex) { // Catch any invalid input
                System.err.println("Invalid choice. \nPlease enter an integer between 1 and 5.");
                userInput.nextLine(); // Discard input on current line
            }
        }
    }

    public static void genericStackTest() {
        SportsCar[] sportsCars = { // Objects to be added to stack
            new SportsCar("LaFerrari", "Ferrari", "Red"),
            new SportsCar("Hurican", "Lamborghini", "Black"),
            new SportsCar("911", "Porsche", "Blue")
        };

        // Create Stack
        GenericStack<SportsCar> sportsCarStack = new GenericStack<>();
        for(SportsCar car : sportsCars) {
            sportsCarStack.push(car);
        }

        // Test Search
        SportsCar goofyCar = new SportsCar("Goofymobile", "Goofy", "blue");
        System.out.println("Position of " + sportsCars[1].toString() + ": " + sportsCarStack.search(sportsCars[1]));
        System.out.println("Position of " + goofyCar.toString() + ": " + sportsCarStack.search(goofyCar) + " (should be -1)");

        // Test Peek
        System.out.println("SportsCar at top of stack: " + sportsCarStack.peek());

        // Test Pop
        System.out.println("\n--- All SportsCars ---");
        while(!sportsCarStack.isEmpty()) {
            System.out.println(sportsCarStack.pop().toString());
        }
    }

    public static void genericQueueTest() {
        String[] animalStrings = { // Objects to be added to queue
            "tiger",
            "panda",
            "leopard",
            "iguana",
            "wolf"
        };

        // Create Queue
        GenericQueue<String> animals = new GenericQueue<>();
        for(String animal : animalStrings) {
            animals.enqueue(animal);
        }

        System.out.println("Queue Size: " + animals.getSize());
        System.out.println("Removing first element: " + animals.dequeue());
        System.out.println("Queue Size after removing first element: " + animals.getSize());
    
        System.out.println("Position of \"" + animalStrings[2] + "\" in queue: " + animals.search(animalStrings[2]));
        System.out.println("Position of \"" + animalStrings[0] + "\" in queue: " + animals.search(animalStrings[0]) + " (should be -1)");
    }

    public static void linkedListTest() {
        // Objects to be added to linked list
        ArrayList<SportsCar> sportsCars = new ArrayList<>();
        sportsCars.add(new SportsCar("LaFerrari", "Ferrari", "Red"));
        sportsCars.add(new SportsCar("Hurican", "Lamborghini", "Black"));
        sportsCars.add(new SportsCar("911", "Porsche", "Blue"));
        sportsCars.add(new SportsCar("California T", "Ferrari", "Orange"));
        sportsCars.add(new SportsCar("Sesto Elemento", "Lamborghini", "Black"));
        sportsCars.add(new SportsCar("Cayenne", "Porsche", "Grey"));
        // Create LinkedList
        LinkedList<SportsCar> linkedList = new LinkedList<>(sportsCars);
        System.out.println("\nOriginal List: " + linkedList.toString());
        // Test Remove
        System.out.println("\nRemoving: " + sportsCars.get(2).toString() + "...");
        linkedList.remove(2);
        // Test add
        SportsCar goofyCar = new SportsCar("Goofymobile", "Goofy", "blue");
        System.out.println("\nAdding: " + goofyCar.toString() + "...");
        linkedList.add(goofyCar);
        // Test Iterator
        ListIterator<SportsCar> iterator = linkedList.listIterator();
        // Move forward through LinkedList
        System.out.println("\n--- Linked List Forward ---");
        while(iterator.hasNext()) {
            System.out.println(iterator.next().toString());
        }
        // Move backward through LinkedList
        System.out.println("\n--- Linked List Backward ---");
        while(iterator.hasPrevious()) {
            System.out.println(iterator.previous().toString());
        }
    }

    public static void priorityQueueTest() {
        // Reverse order using Comparator
        PriorityQueue<Integer> queue1 = new PriorityQueue<>(Comparator.reverseOrder());
        queue1.offer(7);
        queue1.offer(1);
        queue1.offer(2);
        queue1.offer(3);
        queue1.offer(4);
        queue1.offer(5);
        queue1.offer(6);
        // Print Queue
        System.out.print("Reversed priority queue: ");
        while(queue1.size() > 0) {
            System.out.print(queue1.remove() + " ");
        }

        System.out.println(); // Spacing
        // Forward order using Comparable interface implemented by Integer
        PriorityQueue<Integer> queue2 = new PriorityQueue<>();
        queue2.offer(7);
        queue2.offer(1);
        queue2.offer(2);
        queue2.offer(3);
        queue2.offer(4);
        queue2.offer(5);
        queue2.offer(6);
        // Print Queue
        System.out.print("Regular priority queue: ");
        while(queue2.size() > 0) {
            System.out.print(queue2.remove() + " ");
        }
    }
} 
