package com.java.masterclass.exceptions;

import java.io.*;

/**
 * Exception Handling Demonstrations
 * 
 * Covers:
 * - Checked vs Unchecked exceptions
 * - Try-catch-finally
 * - Try-with-resources
 * - Custom exceptions
 * - Exception propagation
 */
public class ExceptionHandlingDemo {

    /**
     * Demonstrates basic try-catch
     */
    public static void demonstrateBasicTryCatch() {
        System.out.println("=== Basic Try-Catch ===");
        
        try {
            String text = "Hello";
            int number = Integer.parseInt(text);  // Will throw exception
        } catch (NumberFormatException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }
        
        System.out.println("Program continues...");
    }

    /**
     * Demonstrates multiple catch blocks
     */
    public static void demonstrateMultipleCatch() {
        System.out.println("\n=== Multiple Catch Blocks ===");
        
        try {
            int[] arr = {1, 2, 3};
            System.out.println(arr[5]);  // ArrayIndexOutOfBoundsException
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array index out of bounds: " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("Null pointer exception: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("General exception: " + e.getMessage());
        }
    }

    /**
     * Demonstrates try-catch-finally
     */
    public static void demonstrateTryCatchFinally() {
        System.out.println("\n=== Try-Catch-Finally ===");
        
        try {
            int result = 10 / 0;  // ArithmeticException
        } catch (ArithmeticException e) {
            System.out.println("Caught: Division by zero");
        } finally {
            System.out.println("Finally block always executes");
        }
    }

    /**
     * Demonstrates try-with-resources (auto-close)
     */
    public static void demonstrateTryWithResources() {
        System.out.println("\n=== Try-With-Resources ===");
        
        String fileName = "test.txt";
        
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line = reader.readLine();
            System.out.println("Read: " + line);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        } catch (IOException e) {
            System.out.println("IO Error: " + e.getMessage());
        }
        // Resource automatically closed
    }

    /**
     * Demonstrates exception propagation
     */
    public static void demonstrateExceptionPropagation() {
        System.out.println("\n=== Exception Propagation ===");
        
        try {
            methodThatThrows();
        } catch (CustomException e) {
            System.out.println("Caught in main: " + e.getMessage());
        }
    }

    static void methodThatThrows() throws CustomException {
        System.out.println("In method that throws");
        throw new CustomException("This is a custom error");
    }

    /**
     * Demonstrates checked vs unchecked exceptions
     */
    public static void demonstrateExceptionTypes() {
        System.out.println("\n=== Checked vs Unchecked ===");
        
        // Checked exception - must catch or declare
        try {
            Thread.sleep(100);  // Checked exception
            System.out.println("Slept for 100ms");
        } catch (InterruptedException e) {
            System.out.println("Sleep interrupted");
        }
        
        // Unchecked exception - optional
        try {
            int x = Integer.parseInt("abc");
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format");
        }
    }

    /**
     * Demonstrates nested exceptions
     */
    public static void demonstrateNestedExceptions() {
        System.out.println("\n=== Nested Exceptions ===");
        
        try {
            try {
                throw new RuntimeException("Inner exception");
            } catch (RuntimeException e) {
                System.out.println("Caught inner: " + e.getMessage());
                throw new CustomException("Wrapped: " + e.getMessage());
            }
        } catch (CustomException e) {
            System.out.println("Caught outer: " + e.getMessage());
        }
    }

    /**
     * Demonstrates exception chain (cause)
     */
    public static void demonstrateExceptionChain() {
        System.out.println("\n=== Exception Chain ===");
        
        try {
            try {
                int x = Integer.parseInt("invalid");
            } catch (NumberFormatException e) {
                throw new CustomException("Failed to parse number", e);
            }
        } catch (CustomException e) {
            System.out.println("Exception: " + e.getMessage());
            System.out.println("Caused by: " + e.getCause().getMessage());
        }
    }

    /**
     * Demonstrates finally always executes
     */
    public static void demonstrateFinallySemantic() {
        System.out.println("\n=== Finally Semantics ===");
        
        System.out.println(methodWithFinally());
    }

    static String methodWithFinally() {
        try {
            System.out.println("In try block");
            return "Returning from try";
        } finally {
            System.out.println("Finally block (executes before return)");
        }
    }

    /**
     * Custom exception class
     */
    static class CustomException extends Exception {
        CustomException(String message) {
            super(message);
        }
        
        CustomException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    /**
     * Demonstrates creating custom exceptions
     */
    public static void demonstrateCustomException() {
        System.out.println("\n=== Custom Exception ===");
        
        try {
            validateAge(15);
        } catch (InvalidAgeException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    static void validateAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Age must be at least 18, got: " + age);
        }
    }

    static class InvalidAgeException extends Exception {
        InvalidAgeException(String message) {
            super(message);
        }
    }

    /**
     * Demonstrates stack trace
     */
    public static void demonstrateStackTrace() {
        System.out.println("\n=== Stack Trace ===");
        
        try {
            level3();
        } catch (Exception e) {
            e.printStackTrace();  // Prints full stack trace
        }
    }

    static void level1() throws Exception {
        throw new Exception("Error at level 1");
    }

    static void level2() throws Exception {
        level1();
    }

    static void level3() throws Exception {
        level2();
    }

    public static void main(String[] args) {
        demonstrateBasicTryCatch();
        demonstrateMultipleCatch();
        demonstrateTryCatchFinally();
        demonstrateTryWithResources();
        demonstrateExceptionPropagation();
        demonstrateExceptionTypes();
        demonstrateNestedExceptions();
        demonstrateExceptionChain();
        demonstrateFinallySemantic();
        demonstrateCustomException();
        demonstrateStackTrace();
    }
}
