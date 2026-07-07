package com.java.masterclass.collections;

import java.util.*;

/**
 * Set Interface Demonstrations
 * 
 * Covers:
 * - HashSet (unordered, fast)
 * - TreeSet (sorted, slower)
 * - LinkedHashSet (insertion order)
 * - Set operations
 */
public class SetDemo {

    /**
     * Demonstrates HashSet
     */
    public static void demonstrateHashSet() {
        System.out.println("=== HashSet Demo ===");
        
        Set<String> cities = new HashSet<>();
        
        // Add elements (order not guaranteed)
        cities.add("New York");
        cities.add("London");
        cities.add("Paris");
        cities.add("Tokyo");
        cities.add("London");  // Duplicate, won't be added
        
        System.out.println("Cities (no duplicates): " + cities);
        System.out.println("Size: " + cities.size());
        
        // Contains check
        System.out.println("Contains 'Paris': " + cities.contains("Paris"));
        System.out.println("Contains 'Delhi': " + cities.contains("Delhi"));
        
        // Remove
        cities.remove("London");
        System.out.println("After removing London: " + cities);
        
        // Iterate (order is unpredictable)
        System.out.println("Iteration:");
        for (String city : cities) {
            System.out.println("  - " + city);
        }
    }

    /**
     * Demonstrates TreeSet (sorted)
     */
    public static void demonstrateTreeSet() {
        System.out.println("\n=== TreeSet Demo ===");
        
        Set<Integer> scores = new TreeSet<>();
        
        scores.add(95);
        scores.add(72);
        scores.add(88);
        scores.add(100);
        scores.add(65);
        
        System.out.println("Scores (sorted): " + scores);
        
        // First and last
        System.out.println("Highest score: " + ((TreeSet<Integer>) scores).last());
        System.out.println("Lowest score: " + ((TreeSet<Integer>) scores).first());
        
        // Subset operations
        TreeSet<Integer> treeScores = (TreeSet<Integer>) scores;
        System.out.println("Scores >= 80: " + treeScores.tailSet(80));
        System.out.println("Scores <= 80: " + treeScores.headSet(80));
        System.out.println("Scores 70-90: " + treeScores.subSet(70, 90));
    }

    /**
     * Demonstrates LinkedHashSet (insertion order)
     */
    public static void demonstrateLinkedHashSet() {
        System.out.println("\n=== LinkedHashSet Demo ===");
        
        Set<String> elements = new LinkedHashSet<>();
        
        elements.add("First");
        elements.add("Third");
        elements.add("Second");
        elements.add("Fourth");
        
        System.out.println("Elements (insertion order): " + elements);
        
        // Still no duplicates
        elements.add("First");
        System.out.println("After duplicate 'First': " + elements);
    }

    /**
     * Demonstrates Set operations
     */
    public static void demonstrateSetOperations() {
        System.out.println("\n=== Set Operations ===");
        
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 4, 5, 6, 7));
        
        // Union
        Set<Integer> union = new HashSet<>(set1);
        union.addAll(set2);
        System.out.println("Union: " + union);
        
        // Intersection
        Set<Integer> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);
        System.out.println("Intersection: " + intersection);
        
        // Difference (set1 - set2)
        Set<Integer> difference = new HashSet<>(set1);
        difference.removeAll(set2);
        System.out.println("Set1 - Set2: " + difference);
        
        // Check disjoint (no common elements)
        System.out.println("Set1 and Set2 disjoint: " + Collections.disjoint(set1, set2));
    }

    /**
     * Demonstrates removing duplicates from list
     */
    public static void removeDuplicates() {
        System.out.println("\n=== Remove Duplicates from List ===");
        
        List<String> listWithDuplicates = Arrays.asList(
            "Apple", "Banana", "Apple", "Orange", "Banana", "Mango"
        );
        System.out.println("List with duplicates: " + listWithDuplicates);
        
        // Using Set to remove duplicates
        List<String> uniqueList = new ArrayList<>(new LinkedHashSet<>(listWithDuplicates));
        System.out.println("Without duplicates: " + uniqueList);
    }

    /**
     * Demonstrates custom object in Set
     */
    public static void demonstrateCustomObjectInSet() {
        System.out.println("\n=== Custom Objects in Set ===");
        
        Set<Person> people = new HashSet<>();
        people.add(new Person("Alice", 25));
        people.add(new Person("Bob", 30));
        people.add(new Person("Alice", 25));  // Duplicate
        
        System.out.println("People set: ");
        for (Person p : people) {
            System.out.println("  - " + p);
        }
        System.out.println("Size: " + people.size());
    }

    static class Person {
        String name;
        int age;
        
        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
        
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Person)) return false;
            Person person = (Person) o;
            return age == person.age && name.equals(person.name);
        }
        
        @Override
        public int hashCode() {
            return Objects.hash(name, age);
        }
        
        @Override
        public String toString() {
            return name + " (" + age + ")";
        }
    }

    public static void main(String[] args) {
        demonstrateHashSet();
        demonstrateTreeSet();
        demonstrateLinkedHashSet();
        demonstrateSetOperations();
        removeDuplicates();
        demonstrateCustomObjectInSet();
    }
}
