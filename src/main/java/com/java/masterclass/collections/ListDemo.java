package com.java.masterclass.collections;

import java.util.*;

/**
 * List Interface Demonstrations
 * 
 * Covers:
 * - ArrayList (dynamic array)
 * - LinkedList (doubly linked list)
 * - CopyOnWriteArrayList (thread-safe)
 * - List operations and performance
 */
public class ListDemo {

    /**
     * Demonstrates ArrayList
     */
    public static void demonstrateArrayList() {
        System.out.println("=== ArrayList Demo ===");
        
        List<String> fruits = new ArrayList<>();
        
        // Add elements
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");
        fruits.add("Mango");
        System.out.println("Fruits: " + fruits);
        
        // Access by index
        System.out.println("First fruit: " + fruits.get(0));
        
        // Insert at specific position
        fruits.add(2, "Grapes");
        System.out.println("After insert: " + fruits);
        
        // Remove
        fruits.remove("Banana");
        System.out.println("After remove: " + fruits);
        
        // Iterate
        System.out.println("Iteration:");
        for (String fruit : fruits) {
            System.out.println("  - " + fruit);
        }
        
        // Stream operations
        System.out.println("Filtered (length > 5):");
        fruits.stream()
            .filter(f -> f.length() > 5)
            .forEach(f -> System.out.println("  - " + f));
    }

    /**
     * Demonstrates LinkedList
     */
    public static void demonstrateLinkedList() {
        System.out.println("\n=== LinkedList Demo ===");
        
        LinkedList<Integer> numbers = new LinkedList<>();
        
        // Add elements
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        System.out.println("Numbers: " + numbers);
        
        // Add at beginning
        numbers.addFirst(5);
        System.out.println("After addFirst: " + numbers);
        
        // Add at end
        numbers.addLast(40);
        System.out.println("After addLast: " + numbers);
        
        // Remove from beginning
        int first = numbers.removeFirst();
        System.out.println("Removed first: " + first + ", List: " + numbers);
        
        // Remove from end
        int last = numbers.removeLast();
        System.out.println("Removed last: " + last + ", List: " + numbers);
        
        // Peek operations (view without removing)
        System.out.println("Peek first: " + numbers.peekFirst());
        System.out.println("Peek last: " + numbers.peekLast());
    }

    /**
     * Demonstrates List comparison and performance
     */
    public static void demonstrateListComparison() {
        System.out.println("\n=== ArrayList vs LinkedList ===");
        
        int n = 10000;
        
        // ArrayList performance
        long startTime = System.nanoTime();
        List<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arrayList.add(i);
        }
        for (int i = 0; i < n; i++) {
            arrayList.get(i);
        }
        long arrayListTime = System.nanoTime() - startTime;
        
        // LinkedList performance
        startTime = System.nanoTime();
        List<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            linkedList.add(i);
        }
        for (int i = 0; i < n; i++) {
            linkedList.get(i);  // O(n) operation!
        }
        long linkedListTime = System.nanoTime() - startTime;
        
        System.out.println("ArrayList time: " + arrayListTime + " ns");
        System.out.println("LinkedList time: " + linkedListTime + " ns");
        System.out.println("LinkedList is " + (linkedListTime/arrayListTime) + "x slower for random access");
    }

    /**
     * Demonstrates common List methods
     */
    public static void demonstrateListMethods() {
        System.out.println("\n=== Common List Methods ===");
        
        List<String> colors = new ArrayList<>(Arrays.asList("Red", "Green", "Blue", "Yellow"));
        
        // Size and contains
        System.out.println("Size: " + colors.size());
        System.out.println("Contains 'Red': " + colors.contains("Red"));
        
        // Index operations
        System.out.println("Index of 'Green': " + colors.indexOf("Green"));
        System.out.println("Last index of 'Red': " + colors.lastIndexOf("Red"));
        
        // Sublist
        System.out.println("Sublist (1-3): " + colors.subList(1, 3));
        
        // Reverse
        Collections.reverse(colors);
        System.out.println("Reversed: " + colors);
        
        // Sort
        Collections.sort(colors);
        System.out.println("Sorted: " + colors);
        
        // Shuffle
        Collections.shuffle(colors);
        System.out.println("Shuffled: " + colors);
    }

    public static void main(String[] args) {
        demonstrateArrayList();
        demonstrateLinkedList();
        demonstrateListComparison();
        demonstrateListMethods();
    }
}
