package com.java.masterclass.java8;

import java.util.*;
import java.util.stream.*;

/**
 * Streams API Demonstrations
 * 
 * Covers:
 * - Stream creation
 * - Intermediate operations (filter, map, sort)
 * - Terminal operations (collect, forEach, reduce)
 * - Parallel streams
 * - Performance considerations
 */
public class StreamsDemo {

    static class Student {
        String name;
        int age;
        double gpa;
        String department;
        
        Student(String name, int age, double gpa, String department) {
            this.name = name;
            this.age = age;
            this.gpa = gpa;
            this.department = department;
        }
        
        @Override
        public String toString() {
            return name + " (Age:" + age + ", GPA:" + gpa + ", " + department + ")";
        }
    }

    /**
     * Demonstrates stream creation
     */
    public static void demonstrateStreamCreation() {
        System.out.println("=== Stream Creation ===");
        
        // From collection
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        Stream<Integer> stream1 = numbers.stream();
        System.out.println("Stream from list created");
        
        // From array
        String[] words = {"Hello", "World", "Java"};
        Stream<String> stream2 = Arrays.stream(words);
        System.out.println("Stream from array created");
        
        // Using Stream.of
        Stream<Integer> stream3 = Stream.of(10, 20, 30);
        System.out.println("Stream from Stream.of created");
        
        // Infinite stream
        Stream<Integer> infiniteStream = Stream.generate(() -> 1);
        Stream<Integer> rangeStream = IntStream.range(0, 5).boxed();
        System.out.println("Infinite and range streams created");
    }

    /**
     * Demonstrates filter operation
     */
    public static void demonstrateFilter() {
        System.out.println("\n=== Filter Operation ===");
        
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        
        // Filter even numbers
        List<Integer> evenNumbers = numbers.stream()
            .filter(n -> n % 2 == 0)
            .collect(Collectors.toList());
        System.out.println("Even numbers: " + evenNumbers);
        
        // Filter and count
        long count = numbers.stream()
            .filter(n -> n > 5)
            .count();
        System.out.println("Numbers > 5: " + count);
    }

    /**
     * Demonstrates map operation
     */
    public static void demonstrateMap() {
        System.out.println("\n=== Map Operation ===");
        
        List<String> words = Arrays.asList("hello", "world", "java");
        
        // Convert to uppercase
        List<String> upperCase = words.stream()
            .map(String::toUpperCase)
            .collect(Collectors.toList());
        System.out.println("Uppercase: " + upperCase);
        
        // Extract string lengths
        List<Integer> lengths = words.stream()
            .map(String::length)
            .collect(Collectors.toList());
        System.out.println("Lengths: " + lengths);
    }

    /**
     * Demonstrates flatMap operation
     */
    public static void demonstrateFlatMap() {
        System.out.println("\n=== FlatMap Operation ===");
        
        List<List<Integer>> numbers = Arrays.asList(
            Arrays.asList(1, 2),
            Arrays.asList(3, 4),
            Arrays.asList(5, 6)
        );
        
        // Flatten into single stream
        List<Integer> flattened = numbers.stream()
            .flatMap(Collection::stream)
            .collect(Collectors.toList());
        System.out.println("Flattened: " + flattened);
    }

    /**
     * Demonstrates sorting
     */
    public static void demonstrateSort() {
        System.out.println("\n=== Sorting ===");
        
        List<Integer> numbers = Arrays.asList(64, 34, 25, 12, 22);
        
        // Ascending
        List<Integer> ascending = numbers.stream()
            .sorted()
            .collect(Collectors.toList());
        System.out.println("Ascending: " + ascending);
        
        // Descending
        List<Integer> descending = numbers.stream()
            .sorted(Collections.reverseOrder())
            .collect(Collectors.toList());
        System.out.println("Descending: " + descending);
    }

    /**
     * Demonstrates distinct operation
     */
    public static void demonstrateDistinct() {
        System.out.println("\n=== Distinct Operation ===");
        
        List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 3, 3, 4, 5, 5);
        
        List<Integer> distinct = numbers.stream()
            .distinct()
            .collect(Collectors.toList());
        System.out.println("Distinct: " + distinct);
    }

    /**
     * Demonstrates limit and skip
     */
    public static void demonstrateLimitAndSkip() {
        System.out.println("\n=== Limit and Skip ===");
        
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        
        // Limit
        List<Integer> limited = numbers.stream()
            .limit(5)
            .collect(Collectors.toList());
        System.out.println("First 5: " + limited);
        
        // Skip
        List<Integer> skipped = numbers.stream()
            .skip(5)
            .collect(Collectors.toList());
        System.out.println("After skipping 5: " + skipped);
    }

    /**
     * Demonstrates reduce operation
     */
    public static void demonstrateReduce() {
        System.out.println("\n=== Reduce Operation ===");
        
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        
        // Sum
        int sum = numbers.stream()
            .reduce(0, (a, b) -> a + b);
        System.out.println("Sum: " + sum);
        
        // Product
        int product = numbers.stream()
            .reduce(1, (a, b) -> a * b);
        System.out.println("Product: " + product);
        
        // Find max
        int max = numbers.stream()
            .reduce(Integer.MIN_VALUE, Integer::max);
        System.out.println("Max: " + max);
    }

    /**
     * Demonstrates collect operations
     */
    public static void demonstrateCollect() {
        System.out.println("\n=== Collect Operations ===");
        
        List<String> words = Arrays.asList("Apple", "Banana", "Apple", "Orange", "Banana");
        
        // To Set (remove duplicates)
        Set<String> uniqueWords = words.stream()
            .collect(Collectors.toSet());
        System.out.println("Unique words: " + uniqueWords);
        
        // To Map
        Map<String, Integer> lengthMap = words.stream()
            .distinct()
            .collect(Collectors.toMap(w -> w, String::length));
        System.out.println("Word lengths: " + lengthMap);
        
        // Grouping
        Map<Integer, List<String>> byLength = words.stream()
            .collect(Collectors.groupingBy(String::length));
        System.out.println("Grouped by length: " + byLength);
    }

    /**
     * Demonstrates stream on objects
     */
    public static void demonstrateObjectStreams() {
        System.out.println("\n=== Object Streams ===");
        
        List<Student> students = Arrays.asList(
            new Student("Alice", 20, 3.8, "CS"),
            new Student("Bob", 21, 3.5, "CS"),
            new Student("Charlie", 20, 3.9, "Math"),
            new Student("Diana", 22, 3.7, "CS")
        );
        
        // Filter by department
        System.out.println("CS Students:");
        students.stream()
            .filter(s -> "CS".equals(s.department))
            .forEach(System.out::println);
        
        // Sort by GPA
        System.out.println("\nSorted by GPA (descending):");
        students.stream()
            .sorted((a, b) -> Double.compare(b.gpa, a.gpa))
            .forEach(System.out::println);
        
        // Extract names
        System.out.println("\nStudent names:");
        List<String> names = students.stream()
            .map(s -> s.name)
            .collect(Collectors.toList());
        System.out.println(names);
    }

    /**
     * Demonstrates forEach
     */
    public static void demonstrateForEach() {
        System.out.println("\n=== ForEach Operation ===");
        
        List<String> fruits = Arrays.asList("Apple", "Banana", "Orange");
        
        fruits.stream()
            .forEach(f -> System.out.println("  - " + f));
    }

    /**
     * Demonstrates parallel streams
     */
    public static void demonstrateParallelStream() {
        System.out.println("\n=== Parallel Streams ===");
        
        List<Integer> numbers = IntStream.range(1, 1000000)
            .boxed()
            .collect(Collectors.toList());
        
        // Sequential
        long start = System.nanoTime();
        long sum1 = numbers.stream()
            .mapToLong(n -> n)
            .sum();
        long sequentialTime = System.nanoTime() - start;
        
        // Parallel
        start = System.nanoTime();
        long sum2 = numbers.parallelStream()
            .mapToLong(n -> n)
            .sum();
        long parallelTime = System.nanoTime() - start;
        
        System.out.println("Sequential time: " + sequentialTime + " ns");
        System.out.println("Parallel time: " + parallelTime + " ns");
        System.out.println("Speedup: " + (sequentialTime / (double) parallelTime) + "x");
    }

    /**
     * Demonstrates peek (for debugging)
     */
    public static void demonstratePeek() {
        System.out.println("\n=== Peek (Debugging) ===");
        
        List<Integer> result = Arrays.asList(1, 2, 3, 4, 5).stream()
            .filter(n -> n > 2)
            .peek(n -> System.out.println("After filter: " + n))
            .map(n -> n * 2)
            .peek(n -> System.out.println("After map: " + n))
            .collect(Collectors.toList());
        
        System.out.println("Final result: " + result);
    }

    public static void main(String[] args) {
        demonstrateStreamCreation();
        demonstrateFilter();
        demonstrateMap();
        demonstrateFlatMap();
        demonstrateSort();
        demonstrateDistinct();
        demonstrateLimitAndSkip();
        demonstrateReduce();
        demonstrateCollect();
        demonstrateObjectStreams();
        demonstrateForEach();
        demonstrateParallelStream();
        demonstratePeek();
    }
}
