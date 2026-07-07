package com.java.masterclass.collections;

import java.util.*;

/**
 * Collections Utility Class Demonstrations
 * 
 * Covers:
 * - Sorting
 * - Searching
 * - Shuffling
 * - Wrapping (synchronized, unmodifiable)
 * - Frequency counting
 */
public class CollectionsUtilDemo {

    /**
     * Demonstrates sorting
     */
    public static void demonstrateSorting() {
        System.out.println("=== Sorting ===");
        
        List<Integer> numbers = new ArrayList<>(Arrays.asList(64, 34, 25, 12, 22, 11, 90));
        System.out.println("Original: " + numbers);
        
        // Sort ascending
        Collections.sort(numbers);
        System.out.println("Sorted ascending: " + numbers);
        
        // Sort descending
        Collections.sort(numbers, Collections.reverseOrder());
        System.out.println("Sorted descending: " + numbers);
    }

    /**
     * Demonstrates searching
     */
    public static void demonstrateSearching() {
        System.out.println("\n=== Searching ===");
        
        List<Integer> sortedNumbers = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50, 60, 70));
        System.out.println("List: " + sortedNumbers);
        
        // Binary search (requires sorted list)
        int index = Collections.binarySearch(sortedNumbers, 40);
        System.out.println("Index of 40: " + index);
        
        // Not found
        index = Collections.binarySearch(sortedNumbers, 35);
        System.out.println("Index of 35 (not found): " + index + " (negative means insertion point)");
    }

    /**
     * Demonstrates shuffling
     */
    public static void demonstrateShuffling() {
        System.out.println("\n=== Shuffling ===");
        
        List<String> cards = new ArrayList<>(Arrays.asList("A", "2", "3", "4", "5", "K", "Q", "J"));
        System.out.println("Original: " + cards);
        
        Collections.shuffle(cards);
        System.out.println("Shuffled: " + cards);
    }

    /**
     * Demonstrates min/max operations
     */
    public static void demonstrateMinMax() {
        System.out.println("\n=== Min/Max Operations ===");
        
        List<Integer> numbers = Arrays.asList(45, 23, 89, 12, 67, 34);
        
        System.out.println("List: " + numbers);
        System.out.println("Minimum: " + Collections.min(numbers));
        System.out.println("Maximum: " + Collections.max(numbers));
        
        // Custom comparator
        System.out.println("Minimum (reverse order): " + 
            Collections.min(numbers, Collections.reverseOrder()));
    }

    /**
     * Demonstrates frequency counting
     */
    public static void demonstrateFrequency() {
        System.out.println("\n=== Frequency Counting ===");
        
        List<String> fruits = Arrays.asList("Apple", "Banana", "Apple", "Orange", "Banana", "Apple");
        System.out.println("Fruits: " + fruits);
        
        System.out.println("Frequency of 'Apple': " + Collections.frequency(fruits, "Apple"));
        System.out.println("Frequency of 'Banana': " + Collections.frequency(fruits, "Banana"));
        System.out.println("Frequency of 'Orange': " + Collections.frequency(fruits, "Orange"));
    }

    /**
     * Demonstrates fill operation
     */
    public static void demonstrateFill() {
        System.out.println("\n=== Fill Operation ===");
        
        List<String> list = new ArrayList<>(Arrays.asList("A", "B", "C", "D", "E"));
        System.out.println("Original: " + list);
        
        Collections.fill(list, "X");
        System.out.println("After fill with 'X': " + list);
    }

    /**
     * Demonstrates rotate operation
     */
    public static void demonstrateRotate() {
        System.out.println("\n=== Rotate Operation ===");
        
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        System.out.println("Original: " + numbers);
        
        Collections.rotate(numbers, 2);
        System.out.println("After rotate by 2: " + numbers);
        
        Collections.rotate(numbers, -3);
        System.out.println("After rotate by -3: " + numbers);
    }

    /**
     * Demonstrates swap operation
     */
    public static void demonstrateSwap() {
        System.out.println("\n=== Swap Operation ===");
        
        List<String> items = new ArrayList<>(Arrays.asList("First", "Second", "Third", "Fourth"));
        System.out.println("Original: " + items);
        
        Collections.swap(items, 0, 3);
        System.out.println("After swapping 0 and 3: " + items);
    }

    /**
     * Demonstrates synchronized collections
     */
    public static void demonstrateSynchronizedCollections() {
        System.out.println("\n=== Synchronized Collections ===");
        
        List<String> unsynchronizedList = new ArrayList<>(Arrays.asList("A", "B", "C"));
        List<String> synchronizedList = Collections.synchronizedList(unsynchronizedList);
        
        synchronizedList.add("D");
        System.out.println("Synchronized list: " + synchronizedList);
        System.out.println("Thread-safe for concurrent access");
    }

    /**
     * Demonstrates unmodifiable collections
     */
    public static void demonstrateUnmodifiableCollections() {
        System.out.println("\n=== Unmodifiable Collections ===");
        
        List<String> originalList = Arrays.asList("A", "B", "C");
        List<String> unmodifiableList = Collections.unmodifiableList(originalList);
        
        System.out.println("Unmodifiable list: " + unmodifiableList);
        
        try {
            unmodifiableList.add("D");
        } catch (UnsupportedOperationException e) {
            System.out.println("Cannot modify: " + e.getMessage());
        }
    }

    /**
     * Demonstrates disjoint check
     */
    public static void demonstrateDisjoint() {
        System.out.println("\n=== Disjoint Check ===");
        
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4);
        List<Integer> list2 = Arrays.asList(5, 6, 7, 8);
        List<Integer> list3 = Arrays.asList(3, 4, 5, 6);
        
        System.out.println("List1: " + list1);
        System.out.println("List2: " + list2);
        System.out.println("List3: " + list3);
        
        System.out.println("List1 and List2 disjoint: " + Collections.disjoint(list1, list2));
        System.out.println("List1 and List3 disjoint: " + Collections.disjoint(list1, list3));
    }

    /**
     * Demonstrates immutable collections (Java 9+)
     */
    public static void demonstrateImmutableCollections() {
        System.out.println("\n=== Immutable Collections ===");
        
        // Java 9+ factory methods
        List<String> immutableList = List.of("A", "B", "C");
        Set<String> immutableSet = Set.of("X", "Y", "Z");
        Map<String, Integer> immutableMap = Map.of("one", 1, "two", 2);
        
        System.out.println("Immutable list: " + immutableList);
        System.out.println("Immutable set: " + immutableSet);
        System.out.println("Immutable map: " + immutableMap);
    }

    public static void main(String[] args) {
        demonstrateSorting();
        demonstrateSearching();
        demonstrateShuffling();
        demonstrateMinMax();
        demonstrateFrequency();
        demonstrateFill();
        demonstrateRotate();
        demonstrateSwap();
        demonstrateSynchronizedCollections();
        demonstrateUnmodifiableCollections();
        demonstrateDisjoint();
        demonstrateImmutableCollections();
    }
}
