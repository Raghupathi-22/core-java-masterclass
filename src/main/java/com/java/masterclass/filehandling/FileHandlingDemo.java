package com.java.masterclass.filehandling;

import java.io.*;
import java.nio.file.*;
import java.util.*;

/**
 * File Handling Demonstrations
 * 
 * Covers:
 * - File creation, reading, writing
 * - Directory operations
 * - File copying, moving, deleting
 * - Reading text files
 * - BufferedReader/Writer
 */
public class FileHandlingDemo {

    /**
     * Demonstrates File class basics
     */
    public static void demonstrateFileBasics() {
        System.out.println("=== File Basics ===");
        
        File file = new File("sample.txt");
        
        System.out.println("File name: " + file.getName());
        System.out.println("Absolute path: " + file.getAbsolutePath());
        System.out.println("Exists: " + file.exists());
        System.out.println("Is file: " + file.isFile());
        System.out.println("Is directory: " + file.isDirectory());
        System.out.println("Can read: " + file.canRead());
        System.out.println("Can write: " + file.canWrite());
    }

    /**
     * Demonstrates writing to file
     */
    public static void demonstrateFileWriting() {
        System.out.println("\n=== File Writing ===");
        
        String fileName = "output.txt";
        
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write("Hello, File I/O!\n");
            writer.write("This is the second line.\n");
            writer.write("Java file handling is easy.\n");
            System.out.println("File written successfully: " + fileName);
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }

    /**
     * Demonstrates reading from file
     */
    public static void demonstrateFileReading() {
        System.out.println("\n=== File Reading ===");
        
        String fileName = "output.txt";
        
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            System.out.println("File contents:");
            while ((line = reader.readLine()) != null) {
                System.out.println("  " + line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    /**
     * Demonstrates appending to file
     */
    public static void demonstrateFileAppending() {
        System.out.println("\n=== File Appending ===");
        
        String fileName = "output.txt";
        
        try (FileWriter writer = new FileWriter(fileName, true)) {  // true = append
            writer.write("This line is appended.\n");
            System.out.println("Content appended successfully");
        } catch (IOException e) {
            System.out.println("Error appending: " + e.getMessage());
        }
    }

    /**
     * Demonstrates directory operations
     */
    public static void demonstrateDirectoryOperations() {
        System.out.println("\n=== Directory Operations ===");
        
        String dirName = "myDirectory";
        File dir = new File(dirName);
        
        // Create directory
        if (!dir.exists()) {
            boolean created = dir.mkdir();
            System.out.println("Directory created: " + created);
        }
        
        // List contents
        File[] files = dir.listFiles();
        if (files != null) {
            System.out.println("Contents of " + dirName + ":");
            for (File file : files) {
                System.out.println("  - " + file.getName());
            }
        }
    }

    /**
     * Demonstrates NIO Files operations
     */
    public static void demonstrateNIOOperations() {
        System.out.println("\n=== NIO File Operations ===");
        
        try {
            // Create file with content
            Path filePath = Paths.get("nio_file.txt");
            Files.write(filePath, "Hello from NIO\n".getBytes());
            
            // Read file
            List<String> lines = Files.readAllLines(filePath);
            System.out.println("File contents: " + lines);
            
            // File size
            long size = Files.size(filePath);
            System.out.println("File size: " + size + " bytes");
            
            // Check existence
            System.out.println("File exists: " + Files.exists(filePath));
            
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Demonstrates copying and moving files
     */
    public static void demonstrateFileCopyMove() {
        System.out.println("\n=== File Copy and Move ===");
        
        try {
            Path source = Paths.get("nio_file.txt");
            Path copy = Paths.get("nio_file_copy.txt");
            Path moved = Paths.get("nio_file_moved.txt");
            
            // Copy file
            if (Files.exists(source)) {
                Files.copy(source, copy, StandardCopyOption.REPLACE_EXISTING);
                System.out.println("File copied");
                
                // Move file
                Files.move(copy, moved, StandardCopyOption.REPLACE_EXISTING);
                System.out.println("File moved");
            }
            
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Demonstrates deleting files
     */
    public static void demonstrateFileDelete() {
        System.out.println("\n=== File Delete ===");
        
        try {
            Path filePath = Paths.get("nio_file_moved.txt");
            
            if (Files.exists(filePath)) {
                boolean deleted = Files.deleteIfExists(filePath);
                System.out.println("File deleted: " + deleted);
            }
            
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Demonstrates reading file as stream
     */
    public static void demonstrateStreamReading() {
        System.out.println("\n=== Stream Reading ===");
        
        try {
            Path filePath = Paths.get("output.txt");
            
            if (Files.exists(filePath)) {
                Files.lines(filePath)
                    .forEach(line -> System.out.println("  " + line));
            }
            
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Demonstrates CSV file reading
     */
    public static void demonstrateCSVReading() {
        System.out.println("\n=== CSV File Reading ===");
        
        // Create sample CSV
        try (PrintWriter writer = new PrintWriter(new FileWriter("data.csv"))) {
            writer.println("Name,Age,City");
            writer.println("Alice,25,New York");
            writer.println("Bob,30,London");
            writer.println("Charlie,35,Paris");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        // Read CSV
        try (BufferedReader reader = new BufferedReader(new FileReader("data.csv"))) {
            String line;
            System.out.println("CSV Contents:");
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                System.out.println("  " + String.join(" | ", parts));
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Demonstrates object serialization
     */
    public static void demonstrateSerialization() {
        System.out.println("\n=== Serialization ===");
        
        try {
            // Write object
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("object.dat"));
            Person person = new Person("Alice", 25);
            oos.writeObject(person);
            oos.close();
            
            System.out.println("Object serialized");
            
            // Read object
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("object.dat"));
            Person readPerson = (Person) ois.readObject();
            ois.close();
            
            System.out.println("Object deserialized: " + readPerson);
            
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    static class Person implements Serializable {
        String name;
        int age;
        
        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
        
        @Override
        public String toString() {
            return name + " (" + age + ")";
        }
    }

    public static void main(String[] args) {
        demonstrateFileBasics();
        demonstrateFileWriting();
        demonstrateFileReading();
        demonstrateFileAppending();
        demonstrateDirectoryOperations();
        demonstrateNIOOperations();
        demonstrateFileCopyMove();
        demonstrateFileDelete();
        demonstrateStreamReading();
        demonstrateCSVReading();
        demonstrateSerialization();
    }
}
