package com.java.masterclass.collections;

import java.util.*;

/**
 * Map Interface Demonstrations
 * 
 * Covers:
 * - HashMap (unordered, fast)
 * - TreeMap (sorted by keys)
 * - LinkedHashMap (insertion order)
 * - ConcurrentHashMap (thread-safe)
 * - Map operations
 */
public class MapDemo {

    /**
     * Demonstrates HashMap
     */
    public static void demonstrateHashMap() {
        System.out.println("=== HashMap Demo ===");
        
        Map<String, Integer> grades = new HashMap<>();
        
        // Put key-value pairs
        grades.put("Alice", 95);
        grades.put("Bob", 87);
        grades.put("Charlie", 92);
        grades.put("David", 78);
        
        System.out.println("Grades: " + grades);
        
        // Get values
        System.out.println("Alice's grade: " + grades.get("Alice"));
        System.out.println("Eve's grade: " + grades.get("Eve"));  // null
        
        // Check if key exists
        System.out.println("Contains 'Bob': " + grades.containsKey("Bob"));
        System.out.println("Contains grade 95: " + grades.containsValue(95));
        
        // Get or default
        System.out.println("Eve's grade (default 0): " + grades.getOrDefault("Eve", 0));
        
        // Update value
        grades.put("Alice", 98);
        System.out.println("Updated Alice's grade: " + grades.get("Alice"));
        
        // Remove
        grades.remove("David");
        System.out.println("After removing David: " + grades);
        
        // Size
        System.out.println("Number of students: " + grades.size());
    }

    /**
     * Demonstrates iterating over Map
     */
    public static void demonstrateMapIteration() {
        System.out.println("\n=== Map Iteration ===");
        
        Map<String, String> capitals = new HashMap<>();
        capitals.put("India", "New Delhi");
        capitals.put("USA", "Washington DC");
        capitals.put("UK", "London");
        capitals.put("Japan", "Tokyo");
        
        // Iterate over entries
        System.out.println("Using entrySet():");
        for (Map.Entry<String, String> entry : capitals.entrySet()) {
            System.out.println("  " + entry.getKey() + " -> " + entry.getValue());
        }
        
        // Iterate over keys
        System.out.println("Using keySet():");
        for (String country : capitals.keySet()) {
            System.out.println("  " + country);
        }
        
        // Iterate over values
        System.out.println("Using values():");
        for (String capital : capitals.values()) {
            System.out.println("  " + capital);
        }
        
        // Using forEach
        System.out.println("Using forEach:");
        capitals.forEach((country, capital) -> 
            System.out.println("  " + country + " -> " + capital)
        );
    }

    /**
     * Demonstrates TreeMap (sorted by keys)
     */
    public static void demonstrateTreeMap() {
        System.out.println("\n=== TreeMap Demo ===");
        
        Map<String, Integer> populationMap = new TreeMap<>();
        
        populationMap.put("China", 1400000000);
        populationMap.put("India", 1380000000);
        populationMap.put("USA", 330000000);
        populationMap.put("Brazil", 215000000);
        populationMap.put("Australia", 26000000);
        
        System.out.println("Countries (sorted): ");
        populationMap.forEach((country, pop) -> 
            System.out.println("  " + country + ": " + pop)
        );
    }

    /**
     * Demonstrates LinkedHashMap (insertion order)
     */
    public static void demonstrateLinkedHashMap() {
        System.out.println("\n=== LinkedHashMap Demo ===");
        
        Map<String, Integer> insertionOrderMap = new LinkedHashMap<>();
        
        insertionOrderMap.put("First", 1);
        insertionOrderMap.put("Third", 3);
        insertionOrderMap.put("Second", 2);
        insertionOrderMap.put("Fourth", 4);
        
        System.out.println("Insertion order maintained: ");
        insertionOrderMap.forEach((key, value) -> 
            System.out.println("  " + key + ": " + value)
        );
    }

    /**
     * Demonstrates common Map operations
     */
    public static void demonstrateMapOperations() {
        System.out.println("\n=== Map Operations ===");
        
        Map<Integer, String> idToName = new HashMap<>();
        idToName.put(1, "Alice");
        idToName.put(2, "Bob");
        idToName.put(3, "Charlie");
        
        // putIfAbsent
        idToName.putIfAbsent(1, "NewAlice");  // Won't update
        idToName.putIfAbsent(4, "David");     // Will add
        System.out.println("After putIfAbsent: " + idToName);
        
        // replace
        idToName.replace(2, "Robert");
        System.out.println("After replace: " + idToName);
        
        // computeIfAbsent
        idToName.computeIfAbsent(5, k -> "Eve");
        System.out.println("After computeIfAbsent: " + idToName);
        
        // merge
        idToName.merge(1, " Smith", (old, new_) -> old + new_);
        System.out.println("After merge: " + idToName);
    }

    /**
     * Demonstrates word frequency counter using Map
     */
    public static void demonstrateFrequencyCounter() {
        System.out.println("\n=== Word Frequency Counter ===");
        
        String text = "the quick brown fox jumps over the lazy dog the fox";
        String[] words = text.split(" ");
        
        Map<String, Integer> frequency = new HashMap<>();
        
        // Count word frequencies
        for (String word : words) {
            frequency.put(word, frequency.getOrDefault(word, 0) + 1);
        }
        
        System.out.println("Word frequencies: ");
        frequency.entrySet().stream()
            .sorted((a, b) -> b.getValue() - a.getValue())
            .forEach(entry -> System.out.println("  " + entry.getKey() + ": " + entry.getValue()));
    }

    /**
     * Demonstrates Map with custom objects
     */
    public static void demonstrateMapWithObjects() {
        System.out.println("\n=== Map with Custom Objects ===");
        
        Map<String, Student> studentMap = new HashMap<>();
        
        studentMap.put("S001", new Student("Alice", 95));
        studentMap.put("S002", new Student("Bob", 87));
        studentMap.put("S003", new Student("Charlie", 92));
        
        System.out.println("Students: ");
        studentMap.forEach((id, student) -> 
            System.out.println("  " + id + ": " + student)
        );
        
        // Get specific student
        Student alice = studentMap.get("S001");
        System.out.println("Found student: " + alice);
    }

    static class Student {
        String name;
        int grade;
        
        Student(String name, int grade) {
            this.name = name;
            this.grade = grade;
        }
        
        @Override
        public String toString() {
            return name + " (Grade: " + grade + ")";
        }
    }

    public static void main(String[] args) {
        demonstrateHashMap();
        demonstrateMapIteration();
        demonstrateTreeMap();
        demonstrateLinkedHashMap();
        demonstrateMapOperations();
        demonstrateFrequencyCounter();
        demonstrateMapWithObjects();
    }
}
