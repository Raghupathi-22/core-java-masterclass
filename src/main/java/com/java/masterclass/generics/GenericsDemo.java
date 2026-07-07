package com.java.masterclass.generics;

import java.util.*;

/**
 * Generics Demonstrations
 * 
 * Covers:
 * - Generic classes
 * - Generic methods
 * - Bounded type parameters
 * - Wildcards
 * - Type erasure
 */
public class GenericsDemo {

    /**
     * Generic class example
     */
    static class Box<T> {
        private T value;
        
        Box(T value) {
            this.value = value;
        }
        
        T getValue() {
            return value;
        }
        
        void setValue(T value) {
            this.value = value;
        }
        
        @Override
        public String toString() {
            return "Box[" + value + "]";
        }
    }

    /**
     * Demonstrates generic classes
     */
    public static void demonstrateGenericClass() {
        System.out.println("=== Generic Classes ===");
        
        // String box
        Box<String> stringBox = new Box<>("Hello");
        System.out.println("String box: " + stringBox);
        System.out.println("Value: " + stringBox.getValue());
        
        // Integer box
        Box<Integer> intBox = new Box<>(42);
        System.out.println("Integer box: " + intBox);
        System.out.println("Value: " + intBox.getValue());
        
        // Double box
        Box<Double> doubleBox = new Box<>(3.14);
        System.out.println("Double box: " + doubleBox);
        System.out.println("Value: " + doubleBox.getValue());
    }

    /**
     * Generic method
     */
    static <T> void printArray(T[] array) {
        System.out.print("Array: ");
        for (T element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    /**
     * Generic method returning value
     */
    static <T extends Comparable<T>> T findMax(T[] array) {
        T max = array[0];
        for (T element : array) {
            if (element.compareTo(max) > 0) {
                max = element;
            }
        }
        return max;
    }

    /**
     * Demonstrates generic methods
     */
    public static void demonstrateGenericMethods() {
        System.out.println("\n=== Generic Methods ===");
        
        Integer[] intArray = {5, 2, 8, 1, 9};
        String[] strArray = {"Apple", "Banana", "Cherry"};
        Double[] doubleArray = {3.14, 2.71, 1.41};
        
        printArray(intArray);
        printArray(strArray);
        printArray(doubleArray);
        
        System.out.println("Max integer: " + findMax(intArray));
        System.out.println("Max string: " + findMax(strArray));
        System.out.println("Max double: " + findMax(doubleArray));
    }

    /**
     * Bounded type parameter (upper bound)
     */
    static class NumberBox<T extends Number> {
        private T value;
        
        NumberBox(T value) {
            this.value = value;
        }
        
        double doubleValue() {
            return value.doubleValue();
        }
        
        @Override
        public String toString() {
            return "NumberBox[" + value + "]";
        }
    }

    /**
     * Demonstrates bounded type parameters
     */
    public static void demonstrateBoundedTypes() {
        System.out.println("\n=== Bounded Type Parameters ===");
        
        NumberBox<Integer> intBox = new NumberBox<>(42);
        NumberBox<Double> doubleBox = new NumberBox<>(3.14);
        
        System.out.println("Int box: " + intBox);
        System.out.println("As double: " + intBox.doubleValue());
        
        System.out.println("Double box: " + doubleBox);
        System.out.println("As double: " + doubleBox.doubleValue());
        
        // This would not compile:
        // NumberBox<String> strBox = new NumberBox<>("Hello");  // String is not Number
    }

    /**
     * Demonstrates wildcards
     */
    public static void demonstrateWildcards() {
        System.out.println("\n=== Wildcards ===");
        
        List<Integer> intList = Arrays.asList(1, 2, 3);
        List<Double> doubleList = Arrays.asList(1.1, 2.2, 3.3);
        List<String> strList = Arrays.asList("A", "B", "C");
        
        // Unbounded wildcard
        printList(intList);
        printList(doubleList);
        printList(strList);
    }

    static void printList(List<?> list) {
        System.out.println("List contents:");
        for (Object element : list) {
            System.out.println("  " + element);
        }
    }

    /**
     * Upper bounded wildcard
     */
    static double sumNumbers(List<? extends Number> list) {
        double sum = 0;
        for (Number num : list) {
            sum += num.doubleValue();
        }
        return sum;
    }

    /**
     * Demonstrates bounded wildcards
     */
    public static void demonstrateBoundedWildcards() {
        System.out.println("\n=== Bounded Wildcards ===");
        
        List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5);
        List<Double> doubleList = Arrays.asList(1.5, 2.5, 3.5);
        
        System.out.println("Sum of integers: " + sumNumbers(intList));
        System.out.println("Sum of doubles: " + sumNumbers(doubleList));
    }

    /**
     * Generic pair class
     */
    static class Pair<K, V> {
        private K key;
        private V value;
        
        Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
        
        K getKey() { return key; }
        V getValue() { return value; }
        
        @Override
        public String toString() {
            return key + " -> " + value;
        }
    }

    /**
     * Demonstrates multiple type parameters
     */
    public static void demonstrateMultipleTypeParameters() {
        System.out.println("\n=== Multiple Type Parameters ===");
        
        Pair<String, Integer> pair1 = new Pair<>("Alice", 25);
        Pair<String, Double> pair2 = new Pair<>("Score", 95.5);
        Pair<Integer, String> pair3 = new Pair<>(1, "One");
        
        System.out.println("Pair 1: " + pair1);
        System.out.println("Pair 2: " + pair2);
        System.out.println("Pair 3: " + pair3);
    }

    /**
     * Demonstrates type erasure
     */
    public static void demonstrateTypeErasure() {
        System.out.println("\n=== Type Erasure ===");
        
        Box<String> stringBox = new Box<>("Hello");
        Box<Integer> intBox = new Box<>(42);
        
        System.out.println("String box class: " + stringBox.getClass());
        System.out.println("Integer box class: " + intBox.getClass());
        System.out.println("Are they the same class? " + 
            stringBox.getClass().equals(intBox.getClass()));
        
        System.out.println("(At runtime, generics are erased to raw types)");
    }

    /**
     * Demonstrates generic comparator
     */
    static class StringLengthComparator implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            return a.length() - b.length();
        }
    }

    /**
     * Demonstrates generics with collections
     */
    public static void demonstrateGenericsWithCollections() {
        System.out.println("\n=== Generics with Collections ===");
        
        List<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Kiwi");
        
        Collections.sort(list, new StringLengthComparator());
        System.out.println("Sorted by length: " + list);
        
        Set<Integer> set = new HashSet<>();
        set.add(5);
        set.add(2);
        set.add(8);
        System.out.println("Integer set: " + set);
    }

    public static void main(String[] args) {
        demonstrateGenericClass();
        demonstrateGenericMethods();
        demonstrateBoundedTypes();
        demonstrateWildcards();
        demonstrateBoundedWildcards();
        demonstrateMultipleTypeParameters();
        demonstrateTypeErasure();
        demonstrateGenericsWithCollections();
    }
}
