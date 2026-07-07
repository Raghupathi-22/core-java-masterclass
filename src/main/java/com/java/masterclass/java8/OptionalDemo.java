package com.java.masterclass.java8;

import java.util.*;

/**
 * Optional Class Demonstrations
 * 
 * Covers:
 * - Creating Optional objects
 * - Optional methods (isPresent, get, orElse, orElseGet, etc.)
 * - Chaining Optional operations
 * - Optional best practices
 */
public class OptionalDemo {

    static class User {
        String name;
        String email;
        int age;
        
        User(String name, String email, int age) {
            this.name = name;
            this.email = email;
            this.age = age;
        }
        
        @Override
        public String toString() {
            return name + " (" + email + ", " + age + ")";
        }
    }

    /**
     * Demonstrates creating Optional
     */
    public static void demonstrateOptionalCreation() {
        System.out.println("=== Optional Creation ===");
        
        // Optional.of (value must not be null)
        Optional<String> optional1 = Optional.of("Hello");
        System.out.println("Optional.of: " + optional1);
        
        // Optional.ofNullable (can be null)
        Optional<String> optional2 = Optional.ofNullable(null);
        System.out.println("Optional.ofNullable(null): " + optional2);
        
        Optional<String> optional3 = Optional.ofNullable("World");
        System.out.println("Optional.ofNullable(value): " + optional3);
        
        // Optional.empty
        Optional<String> optional4 = Optional.empty();
        System.out.println("Optional.empty: " + optional4);
    }

    /**
     * Demonstrates isPresent and get
     */
    public static void demonstrateIsPresentAndGet() {
        System.out.println("\n=== isPresent and get ===");
        
        Optional<String> value = Optional.of("Java");
        Optional<String> empty = Optional.empty();
        
        if (value.isPresent()) {
            System.out.println("Value: " + value.get());
        }
        
        if (empty.isPresent()) {
            System.out.println("Empty has value");
        } else {
            System.out.println("Empty is empty");
        }
    }

    /**
     * Demonstrates orElse
     */
    public static void demonstrateOrElse() {
        System.out.println("\n=== orElse ===");
        
        Optional<String> value = Optional.of("Present");
        Optional<String> empty = Optional.empty();
        
        System.out.println("Value.orElse('default'): " + value.orElse("default"));
        System.out.println("Empty.orElse('default'): " + empty.orElse("default"));
    }

    /**
     * Demonstrates orElseGet
     */
    public static void demonstrateOrElseGet() {
        System.out.println("\n=== orElseGet ===");
        
        Optional<String> value = Optional.of("Present");
        Optional<String> empty = Optional.empty();
        
        System.out.println("Value.orElseGet: " + value.orElseGet(() -> "computed"));
        System.out.println("Empty.orElseGet: " + empty.orElseGet(() -> "computed"));
    }

    /**
     * Demonstrates orElseThrow
     */
    public static void demonstrateOrElseThrow() {
        System.out.println("\n=== orElseThrow ===");
        
        Optional<String> value = Optional.of("Present");
        
        try {
            String result = value.orElseThrow(() -> new RuntimeException("Not found"));
            System.out.println("Value: " + result);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        try {
            Optional<String> empty = Optional.empty();
            empty.orElseThrow(() -> new RuntimeException("Value not found!"));
        } catch (Exception e) {
            System.out.println("Caught: " + e.getMessage());
        }
    }

    /**
     * Demonstrates ifPresent
     */
    public static void demonstrateIfPresent() {
        System.out.println("\n=== ifPresent ===");
        
        Optional<String> value = Optional.of("Hello");
        Optional<String> empty = Optional.empty();
        
        value.ifPresent(v -> System.out.println("Value is: " + v));
        empty.ifPresent(v -> System.out.println("This won't print"));
    }

    /**
     * Demonstrates ifPresentOrElse
     */
    public static void demonstrateIfPresentOrElse() {
        System.out.println("\n=== ifPresentOrElse (Java 9+) ===");
        
        Optional<String> value = Optional.of("Present");
        Optional<String> empty = Optional.empty();
        
        value.ifPresentOrElse(
            v -> System.out.println("Value: " + v),
            () -> System.out.println("Empty")
        );
        
        empty.ifPresentOrElse(
            v -> System.out.println("Value: " + v),
            () -> System.out.println("Empty")
        );
    }

    /**
     * Demonstrates map on Optional
     */
    public static void demonstrateOptionalMap() {
        System.out.println("\n=== Optional Map ===");
        
        Optional<String> name = Optional.of("Alice");
        
        Optional<Integer> length = name.map(String::length);
        System.out.println("Length: " + length.orElse(0));
        
        Optional<String> upper = name.map(String::toUpperCase);
        System.out.println("Uppercase: " + upper.orElse(""));
    }

    /**
     * Demonstrates flatMap on Optional
     */
    public static void demonstrateOptionalFlatMap() {
        System.out.println("\n=== Optional FlatMap ===");
        
        Optional<String> userId = Optional.of("123");
        
        Optional<String> username = userId.flatMap(id -> findUsername(id));
        System.out.println("Username: " + username.orElse("Not found"));
        
        Optional<String> notFound = Optional.of("999").flatMap(id -> findUsername(id));
        System.out.println("Username for 999: " + notFound.orElse("Not found"));
    }

    static Optional<String> findUsername(String userId) {
        // Simulating database lookup
        if ("123".equals(userId)) {
            return Optional.of("Alice");
        }
        return Optional.empty();
    }

    /**
     * Demonstrates filter on Optional
     */
    public static void demonstrateOptionalFilter() {
        System.out.println("\n=== Optional Filter ===");
        
        Optional<Integer> age = Optional.of(25);
        
        Optional<Integer> adult = age.filter(a -> a >= 18);
        System.out.println("Adult age: " + adult.orElse(0));
        
        Optional<Integer> child = Optional.of(10).filter(a -> a >= 18);
        System.out.println("Child age: " + child.orElse(0));
    }

    /**
     * Practical example: User lookup
     */
    public static void demonstratePracticalExample() {
        System.out.println("\n=== Practical Example ===");
        
        List<User> users = Arrays.asList(
            new User("Alice", "alice@example.com", 25),
            new User("Bob", "bob@example.com", 30)
        );
        
        // Find user by name
        String searchName = "Alice";
        Optional<User> user = users.stream()
            .filter(u -> u.name.equals(searchName))
            .findFirst();
        
        user.ifPresent(u -> System.out.println("Found: " + u));
        
        // Get email with default
        String email = user.map(u -> u.email)
            .orElse("email@unknown.com");
        System.out.println("Email: " + email);
        
        // Chain operations
        String result = user
            .map(u -> u.name)
            .map(String::toUpperCase)
            .map(name -> "User: " + name)
            .orElse("User not found");
        System.out.println(result);
    }

    /**
     * Optional chaining example
     */
    public static void demonstrateOptionalChaining() {
        System.out.println("\n=== Optional Chaining ===");
        
        Optional<String> result = Optional.of("Hello World")
            .map(String::length)
            .filter(len -> len > 5)
            .map(len -> "Length is " + len)
            .or(() -> Optional.of("Default message"));
        
        System.out.println(result.orElse(""));
    }

    /**
     * Demonstrates stream and Optional
     */
    public static void demonstrateStreamAndOptional() {
        System.out.println("\n=== Stream and Optional ===");
        
        List<Optional<String>> optionalNames = Arrays.asList(
            Optional.of("Alice"),
            Optional.empty(),
            Optional.of("Bob"),
            Optional.empty(),
            Optional.of("Charlie")
        );
        
        // Get non-empty names
        List<String> names = optionalNames.stream()
            .flatMap(Optional::stream)
            .toList();
        
        System.out.println("Valid names: " + names);
    }

    public static void main(String[] args) {
        demonstrateOptionalCreation();
        demonstrateIsPresentAndGet();
        demonstrateOrElse();
        demonstrateOrElseGet();
        demonstrateOrElseThrow();
        demonstrateIfPresent();
        demonstrateIfPresentOrElse();
        demonstrateOptionalMap();
        demonstrateOptionalFlatMap();
        demonstrateOptionalFilter();
        demonstratePracticalExample();
        demonstrateOptionalChaining();
        demonstrateStreamAndOptional();
    }
}
