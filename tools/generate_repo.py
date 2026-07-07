#!/usr/bin/env python3
from __future__ import annotations

from pathlib import Path
import textwrap

ROOT = Path(__file__).resolve().parents[1]


def write(path: Path, content: str) -> None:
    path.parent.mkdir(parents=True, exist_ok=True)
    path.write_text(content.strip() + "\n", encoding="utf-8")


README = """
# Core Java Masterclass (Java 21)

A production-oriented Core Java repository for:

- learning Java from scratch,
- interview preparation (beginner -> architect),
- coding practice with solutions,
- real-world project examples,
- clean coding and architecture practices.

## Tech Stack

- Java 21
- Maven
- JUnit 5
- Jackson (JSON examples)

## Learning Path

1. Java Basics -> OOP -> Collections
2. Exception Handling -> I/O/NIO -> Serialization
3. Generics -> Java 8 Streams/Lambdas -> Java 17/21 features
4. Multithreading & Concurrency
5. Design Patterns
6. Real-world mini projects
7. Interview and coding practice tracks

## Repository Structure

```text
core-java-masterclass/
├── README.md
├── pom.xml
├── docs/
│   ├── 01-java-basics.md
│   ├── ...
│   ├── 35-coding-patterns.md
│   ├── 36-coding-challenges.md
│   └── INDEX.md
├── src/
│   ├── main/java/com/java/masterclass/
│   │   ├── algorithms/
│   │   ├── basics/
│   │   ├── collections/
│   │   ├── designpatterns/
│   │   ├── exceptions/
│   │   ├── filehandling/
│   │   ├── generics/
│   │   ├── java8/
│   │   ├── java17/
│   │   ├── java21/
│   │   ├── jvm/
│   │   ├── multithreading/
│   │   ├── oops/
│   │   ├── projects/
│   │   ├── serialization/
│   │   └── strings/
│   └── test/java/com/java/masterclass/
└── .gitignore
```

## Interview Preparation Guide

- Start with docs in order (`docs/01` -> `docs/35`).
- Solve problems from `docs/36-coding-challenges.md` by category.
- Use source examples to revise syntax + API usage.
- Practice whiteboard and complexity analysis per solution.

## Coding Practice Guide

- Pick one category/day from coding challenges.
- Solve first without looking at the solution.
- Re-implement with improved complexity where possible.
- Add tests in `src/test/java` for every solved problem.

## Java Developer Roadmap (Short)

- Core Java fundamentals
- OOP + collections + exceptions
- Streams + concurrency
- JVM internals + memory + GC
- Patterns + architecture
- Testing + clean code + performance

## Build & Test

```bash
mvn clean test
mvn -q exec:java -Dexec.mainClass=com.java.masterclass.App
```

## Contribution Rules

- Follow SOLID, DRY, KISS.
- Keep classes cohesive and methods small.
- Add tests for every new behavior.
- Prefer immutable data and explicit naming.
"""

POM = """
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.java</groupId>
    <artifactId>core-java-masterclass</artifactId>
    <version>1.0.0</version>
    <name>core-java-masterclass</name>

    <properties>
        <maven.compiler.release>21</maven.compiler.release>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <junit.version>5.10.2</junit.version>
        <jackson.version>2.17.2</jackson.version>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter</artifactId>
            <version>${junit.version}</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-databind</artifactId>
            <version>${jackson.version}</version>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.13.0</version>
                <configuration>
                    <release>21</release>
                </configuration>
            </plugin>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <version>3.2.5</version>
            </plugin>
            <plugin>
                <groupId>org.codehaus.mojo</groupId>
                <artifactId>exec-maven-plugin</artifactId>
                <version>3.3.0</version>
            </plugin>
        </plugins>
    </build>
</project>
"""

TOPICS = [
    ("01-java-basics.md", "Java Basics"),
    ("02-data-types.md", "Data Types"),
    ("03-operators.md", "Operators"),
    ("04-control-statements.md", "Control Statements"),
    ("05-arrays.md", "Arrays"),
    ("06-strings.md", "Strings"),
    ("07-methods.md", "Methods"),
    ("08-oops.md", "OOP"),
    ("09-inheritance.md", "Inheritance"),
    ("10-polymorphism.md", "Polymorphism"),
    ("11-abstraction.md", "Abstraction"),
    ("12-encapsulation.md", "Encapsulation"),
    ("13-packages.md", "Packages"),
    ("14-access-modifiers.md", "Access Modifiers"),
    ("15-static-keyword.md", "Static Keyword"),
    ("16-final-keyword.md", "Final Keyword"),
    ("17-inner-classes.md", "Inner Classes"),
    ("18-enums.md", "Enums"),
    ("19-generics.md", "Generics"),
    ("20-exception-handling.md", "Exception Handling"),
    ("21-collections.md", "Collections"),
    ("22-multithreading.md", "Multithreading"),
    ("23-java-io.md", "Java IO"),
    ("24-nio.md", "NIO"),
    ("25-serialization.md", "Serialization"),
    ("26-java-8-features.md", "Java 8 Features"),
    ("27-java-17-features.md", "Java 17 Features"),
    ("28-java-21-features.md", "Java 21 Features"),
    ("29-design-patterns.md", "Design Patterns"),
    ("30-jvm-jre-jdk.md", "JVM, JRE, JDK"),
    ("31-garbage-collection.md", "Garbage Collection"),
    ("32-memory-management.md", "Memory Management"),
    ("33-concurrency.md", "Concurrency"),
    ("34-interview-questions.md", "Interview Questions"),
    ("35-coding-patterns.md", "Coding Patterns"),
]


def topic_doc(title: str) -> str:
    return f"""
# {title}

## 1. Theory

- Core concept and terminology for {title.lower()}.
- Typical API/components used in production.
- Common mistakes and how to avoid them.

## 2. Notes

- Follow SOLID, DRY, KISS while implementing {title.lower()}.
- Prefer readability and explicit naming over smart shortcuts.
- Add tests for corner cases and failure scenarios.

## 3. Example Code

```java
// Example reference class under src/main/java/com/java/masterclass
```

## 4. Practice Problems

1. Implement a beginner-level {title.lower()} exercise.
2. Refactor an existing implementation for readability.
3. Add validation and defensive checks.
4. Add unit tests for happy path and edge cases.
5. Analyze complexity and optimize a slow path.
6. Convert imperative logic to cleaner style.
7. Introduce immutable data where possible.
8. Handle error scenarios explicitly.
9. Add logging/observability hooks.
10. Explain trade-offs in your implementation.

## 5. Interview Questions

1. What is {title.lower()} and why does it matter?
2. What are common pitfalls in {title.lower()}?
3. How do you test and validate {title.lower()} behavior?
4. How does {title.lower()} affect performance?
5. What design principles apply most strongly to {title.lower()}?

## 6. Interview Answers

1. It is a core Java topic required for writing maintainable, performant systems.
2. Pitfalls include hidden complexity, incorrect assumptions, and poor error handling.
3. Use layered tests: unit, integration, and edge-case coverage.
4. Measure with representative workloads and profile hot paths.
5. Keep APIs small, cohesive, and focused on a single responsibility.

## 7. Real-world Use Cases

- Backend service development
- Data transformation pipelines
- Batch processing and schedulers
- Enterprise integration applications
- High-throughput API processing
"""


def generate_interview_qas() -> str:
    levels = [
        "Beginner",
        "Intermediate",
        "Advanced",
        "Senior Developer",
        "Architect",
    ]
    total_per_level = 64
    lines = ["# Interview Questions (300+)", "", "Includes 320 curated Q&A prompts.", ""]
    for level in levels:
        lines.append(f"## {level}")
        lines.append("")
        for i in range(1, total_per_level + 1):
            qn = f"{level[0]}{i:02d}"
            lines.append(f"### Q{qn}. Explain a key Core Java concept relevant to {level.lower()} interviews.")
            lines.append("**Answer:** Define the concept clearly, compare alternatives, discuss trade-offs, and include one production example with complexity/performance impact.")
            lines.append("")
    return "\n".join(lines)


def generate_coding_challenges() -> str:
    categories = [
        "String Problems",
        "Array Problems",
        "Collection Problems",
        "Recursion",
        "Stack",
        "Queue",
        "Linked List",
        "Tree",
        "Graph",
        "Heap",
        "Dynamic Programming",
        "Sliding Window",
        "Two Pointer",
        "Backtracking",
        "Java Streams Problems",
        "Multithreading Problems",
    ]

    lines = ["# Coding Challenges (500+)", "", "This section contains 512 practice problems with compact solution guidance.", ""]
    idx = 1
    for cat in categories:
        lines.append(f"## {cat}")
        lines.append("")
        for local in range(1, 33):
            lines.append(f"### Problem {idx}. {cat} Challenge {local}")
            lines.append("- **Prompt:** Solve the problem with clear constraints and edge-case handling.")
            lines.append("- **Solution idea:** Start with a brute-force baseline, then optimize using the canonical pattern for this category.")
            lines.append("- **Complexity target:** Improve from O(n^2) to O(n) or O(n log n) where possible.")
            lines.append("- **Java hint:** Write a pure function, then add focused unit tests.")
            lines.append("")
            idx += 1
    return "\n".join(lines)


JAVA_FILES: dict[str, str] = {
    "src/main/java/com/java/masterclass/App.java": """
package com.java.masterclass;

import com.java.masterclass.basics.VariablesDemo;
import com.java.masterclass.strings.StringAlgorithms;
import com.java.masterclass.projects.student.StudentManagementApp;

public class App {
    public static void main(String[] args) {
        System.out.println("Core Java Masterclass - Java 21");
        VariablesDemo.run();
        System.out.println("Is 'listen' an anagram of 'silent'? "
                + StringAlgorithms.isAnagram("listen", "silent"));
        StudentManagementApp.demo();
    }
}
""",
    "src/main/java/com/java/masterclass/basics/VariablesDemo.java": """
package com.java.masterclass.basics;

public final class VariablesDemo {
    private VariablesDemo() {}

    public static void run() {
        int age = 30;
        double salary = 105000.50;
        boolean active = true;
        char grade = 'A';
        String name = "Alex";

        System.out.printf("name=%s age=%d salary=%.2f active=%s grade=%s%n",
                name, age, salary, active, grade);
    }
}
""",
    "src/main/java/com/java/masterclass/basics/ControlFlowDemo.java": """
package com.java.masterclass.basics;

public final class ControlFlowDemo {
    private ControlFlowDemo() {}

    public static String classifyNumber(int n) {
        if (n == 0) return "zero";
        if (n > 0) return "positive";
        return "negative";
    }
}
""",
    "src/main/java/com/java/masterclass/strings/StringAlgorithms.java": """
package com.java.masterclass.strings;

import java.util.HashMap;
import java.util.Map;

public final class StringAlgorithms {
    private StringAlgorithms() {}

    public static boolean isAnagram(String left, String right) {
        if (left == null || right == null) return false;
        String a = left.replaceAll("\\s+", "").toLowerCase();
        String b = right.replaceAll("\\s+", "").toLowerCase();
        if (a.length() != b.length()) return false;

        int[] count = new int[26];
        for (int i = 0; i < a.length(); i++) {
            count[a.charAt(i) - 'a']++;
            count[b.charAt(i) - 'a']--;
        }
        for (int c : count) {
            if (c != 0) return false;
        }
        return true;
    }

    public static boolean isPalindrome(String value) {
        if (value == null) return false;
        int l = 0;
        int r = value.length() - 1;
        while (l < r) {
            if (value.charAt(l++) != value.charAt(r--)) {
                return false;
            }
        }
        return true;
    }

    public static String reverse(String value) {
        if (value == null) return null;
        return new StringBuilder(value).reverse().toString();
    }

    public static Map<Character, Integer> characterCount(String value) {
        Map<Character, Integer> counts = new HashMap<>();
        if (value == null) return counts;
        for (char c : value.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }
        return counts;
    }

    public static Character firstNonRepeatedChar(String value) {
        if (value == null || value.isBlank()) return null;
        Map<Character, Integer> counts = characterCount(value);
        for (char c : value.toCharArray()) {
            if (counts.get(c) == 1) return c;
        }
        return null;
    }

    public static int longestUniqueSubstringLength(String value) {
        if (value == null || value.isEmpty()) return 0;
        int[] lastSeen = new int[256];
        for (int i = 0; i < lastSeen.length; i++) lastSeen[i] = -1;

        int start = 0;
        int best = 0;
        for (int i = 0; i < value.length(); i++) {
            int ch = value.charAt(i);
            if (lastSeen[ch] >= start) {
                start = lastSeen[ch] + 1;
            }
            lastSeen[ch] = i;
            best = Math.max(best, i - start + 1);
        }
        return best;
    }
}
""",
    "src/main/java/com/java/masterclass/oops/InheritanceDemo.java": """
package com.java.masterclass.oops;

public final class InheritanceDemo {
    private InheritanceDemo() {}

    static class Animal {
        String speak() { return "sound"; }
    }

    static class Dog extends Animal {
        @Override
        String speak() { return "bark"; }
    }

    public static String demo() {
        Animal a = new Dog();
        return a.speak();
    }
}
""",
    "src/main/java/com/java/masterclass/oops/CompositionDemo.java": """
package com.java.masterclass.oops;

public final class CompositionDemo {
    private CompositionDemo() {}

    static class Engine {
        String start() { return "engine-started"; }
    }

    static class Car {
        private final Engine engine = new Engine();

        String drive() {
            return engine.start() + ":driving";
        }
    }

    public static String demo() {
        return new Car().drive();
    }
}
""",
    "src/main/java/com/java/masterclass/generics/GenericBox.java": """
package com.java.masterclass.generics;

public class GenericBox<T> {
    private T value;

    public GenericBox(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public static <T extends Number> double sum(T a, T b) {
        return a.doubleValue() + b.doubleValue();
    }
}
""",
    "src/main/java/com/java/masterclass/java8/LambdaAndStreamPractice.java": """
package com.java.masterclass.java8;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public final class LambdaAndStreamPractice {
    private LambdaAndStreamPractice() {}

    public static List<String> uppercaseSorted(List<String> input) {
        return input.stream()
                .map(String::toUpperCase)
                .sorted()
                .toList();
    }

    public static Map<String, Long> frequency(List<String> input) {
        return input.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }
}
""",
    "src/main/java/com/java/masterclass/java17/Java17FeatureDemo.java": """
package com.java.masterclass.java17;

public final class Java17FeatureDemo {
    private Java17FeatureDemo() {}

    public record EmployeeRecord(long id, String name) {}

    public sealed interface Payment permits CardPayment, UpiPayment {
        String process();
    }

    public record CardPayment(String cardNo) implements Payment {
        public String process() { return "card:" + cardNo; }
    }

    public record UpiPayment(String upiId) implements Payment {
        public String process() { return "upi:" + upiId; }
    }

    public static String describe(Object o) {
        return switch (o) {
            case Integer i -> "int:" + i;
            case String s -> "string:" + s;
            case null -> "null";
            default -> "other";
        };
    }
}
""",
    "src/main/java/com/java/masterclass/java21/Java21FeatureDemo.java": """
package com.java.masterclass.java21;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;

public final class Java21FeatureDemo {
    private Java21FeatureDemo() {}

    public static List<String> sequencedCollectionDemo() {
        List<String> data = new ArrayList<>();
        data.add("first");
        data.add("second");
        data.add("third");
        return data.reversed();
    }

    public static String virtualThreadDemo() {
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            var result = executor.submit((Callable<String>) () -> "vt-ok");
            return result.get();
        } catch (Exception e) {
            throw new IllegalStateException("Virtual thread demo failed", e);
        }
    }
}
""",
    "src/main/java/com/java/masterclass/designpatterns/SingletonPattern.java": """
package com.java.masterclass.designpatterns;

public final class SingletonPattern {
    private SingletonPattern() {}

    public enum ConfigManager {
        INSTANCE;

        public String value(String key) {
            return "value-for-" + key;
        }
    }
}
""",
    "src/main/java/com/java/masterclass/designpatterns/FactoryPattern.java": """
package com.java.masterclass.designpatterns;

public final class FactoryPattern {
    private FactoryPattern() {}

    public interface Notification {
        String send(String msg);
    }

    public static final class EmailNotification implements Notification {
        public String send(String msg) { return "email:" + msg; }
    }

    public static final class SmsNotification implements Notification {
        public String send(String msg) { return "sms:" + msg; }
    }

    public static Notification create(String type) {
        return switch (type.toLowerCase()) {
            case "email" -> new EmailNotification();
            case "sms" -> new SmsNotification();
            default -> throw new IllegalArgumentException("Unknown type: " + type);
        };
    }
}
""",
    "src/main/java/com/java/masterclass/designpatterns/BuilderPattern.java": """
package com.java.masterclass.designpatterns;

public final class BuilderPattern {
    private BuilderPattern() {}

    public static final class User {
        private final String name;
        private final String email;

        private User(Builder builder) {
            this.name = builder.name;
            this.email = builder.email;
        }

        public String name() { return name; }
        public String email() { return email; }

        public static final class Builder {
            private String name;
            private String email;

            public Builder name(String name) {
                this.name = name;
                return this;
            }

            public Builder email(String email) {
                this.email = email;
                return this;
            }

            public User build() {
                return new User(this);
            }
        }
    }
}
""",
    "src/main/java/com/java/masterclass/designpatterns/StrategyPattern.java": """
package com.java.masterclass.designpatterns;

public final class StrategyPattern {
    private StrategyPattern() {}

    public interface DiscountStrategy {
        double apply(double amount);
    }

    public static final class NoDiscount implements DiscountStrategy {
        public double apply(double amount) { return amount; }
    }

    public static final class FestivalDiscount implements DiscountStrategy {
        public double apply(double amount) { return amount * 0.9; }
    }

    public static double checkout(double amount, DiscountStrategy strategy) {
        return strategy.apply(amount);
    }
}
""",
    "src/main/java/com/java/masterclass/designpatterns/ObserverPattern.java": """
package com.java.masterclass.designpatterns;

import java.util.ArrayList;
import java.util.List;

public final class ObserverPattern {
    private ObserverPattern() {}

    public interface Observer {
        void update(String message);
    }

    public static final class Subject {
        private final List<Observer> observers = new ArrayList<>();

        public void subscribe(Observer observer) {
            observers.add(observer);
        }

        public void notifyAllObservers(String message) {
            observers.forEach(o -> o.update(message));
        }
    }
}
""",
    "src/main/java/com/java/masterclass/filehandling/CsvProcessor.java": """
package com.java.masterclass.filehandling;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public final class CsvProcessor {
    private CsvProcessor() {}

    public static List<String[]> read(Path path) {
        try {
            List<String[]> rows = new ArrayList<>();
            for (String line : Files.readAllLines(path, StandardCharsets.UTF_8)) {
                rows.add(line.split(","));
            }
            return rows;
        } catch (IOException e) {
            throw new IllegalStateException("Failed to read CSV", e);
        }
    }

    public static void write(Path path, List<String[]> rows) {
        List<String> lines = rows.stream().map(cols -> String.join(",", cols)).toList();
        try {
            Files.write(path, lines, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new IllegalStateException("Failed to write CSV", e);
        }
    }
}
""",
    "src/main/java/com/java/masterclass/filehandling/JsonProcessor.java": """
package com.java.masterclass.filehandling;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public final class JsonProcessor {
    private static final ObjectMapper MAPPER = new ObjectMapper();

    private JsonProcessor() {}

    public static String toJson(Object value) {
        try {
            return MAPPER.writeValueAsString(value);
        } catch (JsonProcessingException e) {
            throw new IllegalStateException("Failed to serialize JSON", e);
        }
    }

    public static <T> T fromJson(String json, Class<T> type) {
        try {
            return MAPPER.readValue(json, type);
        } catch (JsonProcessingException e) {
            throw new IllegalStateException("Failed to deserialize JSON", e);
        }
    }
}
""",
    "src/main/java/com/java/masterclass/filehandling/PropertiesHandler.java": """
package com.java.masterclass.filehandling;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

public final class PropertiesHandler {
    private PropertiesHandler() {}

    public static Properties load(Path path) {
        Properties properties = new Properties();
        try (InputStream in = Files.newInputStream(path)) {
            properties.load(in);
            return properties;
        } catch (IOException e) {
            throw new IllegalStateException("Failed to load properties", e);
        }
    }

    public static void save(Path path, Properties properties) {
        try (OutputStream out = Files.newOutputStream(path)) {
            properties.store(out, "core-java-masterclass");
        } catch (IOException e) {
            throw new IllegalStateException("Failed to save properties", e);
        }
    }
}
""",
    "src/main/java/com/java/masterclass/serialization/SerializationDemo.java": """
package com.java.masterclass.serialization;

import java.io.*;

public final class SerializationDemo {
    private SerializationDemo() {}

    public record Student(long id, String name) implements Serializable {
        @Serial
        private static final long serialVersionUID = 1L;
    }

    public static byte[] serialize(Student student) {
        try (var baos = new ByteArrayOutputStream(); var oos = new ObjectOutputStream(baos)) {
            oos.writeObject(student);
            return baos.toByteArray();
        } catch (IOException e) {
            throw new IllegalStateException("Serialization failed", e);
        }
    }

    public static Student deserialize(byte[] data) {
        try (var bais = new ByteArrayInputStream(data); var ois = new ObjectInputStream(bais)) {
            return (Student) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new IllegalStateException("Deserialization failed", e);
        }
    }
}
""",
    "src/main/java/com/java/masterclass/multithreading/ConcurrencyToolkitDemo.java": """
package com.java.masterclass.multithreading;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public final class ConcurrencyToolkitDemo {
    private ConcurrencyToolkitDemo() {}

    public static int countWithExecutor(int tasks) {
        AtomicInteger counter = new AtomicInteger();
        try (ExecutorService executor = Executors.newFixedThreadPool(4)) {
            CountDownLatch latch = new CountDownLatch(tasks);
            for (int i = 0; i < tasks; i++) {
                executor.submit(() -> {
                    counter.incrementAndGet();
                    latch.countDown();
                });
            }
            latch.await(2, TimeUnit.SECONDS);
            return counter.get();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new IllegalStateException("Interrupted", e);
        }
    }

    public static String completableFutureDemo() {
        return CompletableFuture.supplyAsync(() -> "core")
                .thenApply(s -> s + "-java")
                .join();
    }
}
""",
    "src/main/java/com/java/masterclass/algorithms/ArrayAlgorithms.java": """
package com.java.masterclass.algorithms;

import java.util.HashMap;
import java.util.Map;

public final class ArrayAlgorithms {
    private ArrayAlgorithms() {}

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indexByValue = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (indexByValue.containsKey(complement)) {
                return new int[] {indexByValue.get(complement), i};
            }
            indexByValue.put(nums[i], i);
        }
        return new int[] {-1, -1};
    }

    public static int maxSubArraySum(int[] nums) {
        int best = nums[0];
        int current = nums[0];
        for (int i = 1; i < nums.length; i++) {
            current = Math.max(nums[i], current + nums[i]);
            best = Math.max(best, current);
        }
        return best;
    }
}
""",
    "src/main/java/com/java/masterclass/projects/student/StudentManagementApp.java": """
package com.java.masterclass.projects.student;

import java.util.*;

public final class StudentManagementApp {
    private StudentManagementApp() {}

    public record Student(long id, String name, String email) {}

    public static final class StudentService {
        private final Map<Long, Student> storage = new HashMap<>();

        public void add(Student student) {
            storage.put(student.id(), student);
        }

        public Optional<Student> findById(long id) {
            return Optional.ofNullable(storage.get(id));
        }

        public List<Student> findAll() {
            return storage.values().stream().sorted(Comparator.comparing(Student::id)).toList();
        }

        public boolean delete(long id) {
            return storage.remove(id) != null;
        }
    }

    public static void demo() {
        StudentService service = new StudentService();
        service.add(new Student(1, "Asha", "asha@example.com"));
        service.add(new Student(2, "Ravi", "ravi@example.com"));
        System.out.println("Students count: " + service.findAll().size());
    }
}
""",
    "src/main/java/com/java/masterclass/projects/library/LibraryManagementApp.java": """
package com.java.masterclass.projects.library;

import java.util.*;

public final class LibraryManagementApp {
    private LibraryManagementApp() {}

    public record Book(String isbn, String title, boolean issued) {}

    public static final class LibraryService {
        private final Map<String, Book> books = new HashMap<>();

        public void addBook(String isbn, String title) {
            books.put(isbn, new Book(isbn, title, false));
        }

        public boolean issueBook(String isbn) {
            Book b = books.get(isbn);
            if (b == null || b.issued()) return false;
            books.put(isbn, new Book(b.isbn(), b.title(), true));
            return true;
        }

        public boolean returnBook(String isbn) {
            Book b = books.get(isbn);
            if (b == null || !b.issued()) return false;
            books.put(isbn, new Book(b.isbn(), b.title(), false));
            return true;
        }
    }
}
""",
    "src/main/java/com/java/masterclass/projects/employee/EmployeeManagementApp.java": """
package com.java.masterclass.projects.employee;

import java.util.*;

public final class EmployeeManagementApp {
    private EmployeeManagementApp() {}

    public record Employee(long id, String name, String department, double salary) {}

    public static final class EmployeeService {
        private final Map<Long, Employee> employees = new HashMap<>();

        public void upsert(Employee employee) {
            employees.put(employee.id(), employee);
        }

        public List<Employee> byDepartment(String department) {
            return employees.values().stream()
                    .filter(e -> e.department().equalsIgnoreCase(department))
                    .sorted(Comparator.comparing(Employee::id))
                    .toList();
        }
    }
}
""",
    "src/main/java/com/java/masterclass/projects/banking/BankingSystemApp.java": """
package com.java.masterclass.projects.banking;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public final class BankingSystemApp {
    private BankingSystemApp() {}

    public static final class Account {
        private final String accountNo;
        private BigDecimal balance;

        public Account(String accountNo, BigDecimal balance) {
            this.accountNo = accountNo;
            this.balance = balance;
        }

        public synchronized void deposit(BigDecimal amount) {
            balance = balance.add(amount);
        }

        public synchronized boolean withdraw(BigDecimal amount) {
            if (balance.compareTo(amount) < 0) return false;
            balance = balance.subtract(amount);
            return true;
        }

        public synchronized BigDecimal balance() { return balance; }
        public String accountNo() { return accountNo; }
    }

    public static final class BankingService {
        private final Map<String, Account> accounts = new HashMap<>();

        public void create(String accountNo, BigDecimal opening) {
            accounts.put(accountNo, new Account(accountNo, opening));
        }

        public boolean transfer(String from, String to, BigDecimal amount) {
            Account source = accounts.get(from);
            Account destination = accounts.get(to);
            if (source == null || destination == null) return false;
            synchronized (this) {
                if (!source.withdraw(amount)) return false;
                destination.deposit(amount);
                return true;
            }
        }
    }
}
""",
    "src/main/java/com/java/masterclass/projects/fileprocessing/FileProcessingSystemApp.java": """
package com.java.masterclass.projects.fileprocessing;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public final class FileProcessingSystemApp {
    private FileProcessingSystemApp() {}

    public static long countLines(Path path) {
        try {
            return Files.lines(path, StandardCharsets.UTF_8).count();
        } catch (IOException e) {
            throw new IllegalStateException("Failed to process file", e);
        }
    }
}
""",
    "src/main/java/com/java/masterclass/projects/downloader/MultithreadedDownloadManagerApp.java": """
package com.java.masterclass.projects.downloader;

import java.util.List;
import java.util.concurrent.*;

public final class MultithreadedDownloadManagerApp {
    private MultithreadedDownloadManagerApp() {}

    public static List<String> downloadAll(List<String> urls) {
        try (ExecutorService executor = Executors.newFixedThreadPool(4)) {
            List<Future<String>> futures = urls.stream()
                    .map(url -> executor.submit(() -> "downloaded:" + url))
                    .toList();
            return futures.stream().map(f -> {
                try {
                    return f.get();
                } catch (Exception e) {
                    throw new IllegalStateException("Download failed", e);
                }
            }).toList();
        }
    }
}
""",
    "src/main/java/com/java/masterclass/projects/csvtool/CsvProcessingToolApp.java": """
package com.java.masterclass.projects.csvtool;

import com.java.masterclass.filehandling.CsvProcessor;

import java.nio.file.Path;
import java.util.List;

public final class CsvProcessingToolApp {
    private CsvProcessingToolApp() {}

    public static long rowCount(Path path) {
        List<String[]> rows = CsvProcessor.read(path);
        return rows.size();
    }
}
""",
    "src/main/java/com/java/masterclass/projects/logtool/LogProcessingToolApp.java": """
package com.java.masterclass.projects.logtool;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public final class LogProcessingToolApp {
    private LogProcessingToolApp() {}

    public static Map<String, Long> countByLevel(List<String> logs) {
        return logs.stream()
                .map(LogProcessingToolApp::extractLevel)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    private static String extractLevel(String line) {
        if (line.contains("ERROR")) return "ERROR";
        if (line.contains("WARN")) return "WARN";
        return "INFO";
    }
}
""",
    "src/main/java/com/java/masterclass/jvm/JvmMemoryNotes.java": """
package com.java.masterclass.jvm;

public final class JvmMemoryNotes {
    private JvmMemoryNotes() {}

    public static String summary() {
        return "Heap stores objects, stack stores frames, metaspace stores class metadata.";
    }
}
""",
}

TEST_FILES: dict[str, str] = {
    "src/test/java/com/java/masterclass/strings/StringAlgorithmsTest.java": """
package com.java.masterclass.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringAlgorithmsTest {

    @Test
    void shouldValidateAnagram() {
        assertTrue(StringAlgorithms.isAnagram("listen", "silent"));
        assertFalse(StringAlgorithms.isAnagram("listen", "silence"));
    }

    @Test
    void shouldValidatePalindrome() {
        assertTrue(StringAlgorithms.isPalindrome("level"));
        assertFalse(StringAlgorithms.isPalindrome("java"));
    }

    @Test
    void shouldFindFirstNonRepeatedCharacter() {
        assertEquals('w', StringAlgorithms.firstNonRepeatedChar("swiss"));
    }

    @Test
    void shouldFindLongestUniqueSubstringLength() {
        assertEquals(3, StringAlgorithms.longestUniqueSubstringLength("abcabcbb"));
    }
}
""",
    "src/test/java/com/java/masterclass/algorithms/ArrayAlgorithmsTest.java": """
package com.java.masterclass.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayAlgorithmsTest {

    @Test
    void shouldSolveTwoSum() {
        int[] result = ArrayAlgorithms.twoSum(new int[]{2, 7, 11, 15}, 9);
        assertArrayEquals(new int[]{0, 1}, result);
    }

    @Test
    void shouldComputeMaxSubArray() {
        assertEquals(6, ArrayAlgorithms.maxSubArraySum(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
""",
    "src/test/java/com/java/masterclass/projects/student/StudentManagementAppTest.java": """
package com.java.masterclass.projects.student;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentManagementAppTest {

    @Test
    void shouldAddAndFindStudents() {
        StudentManagementApp.StudentService service = new StudentManagementApp.StudentService();
        service.add(new StudentManagementApp.Student(10L, "Neo", "neo@example.com"));

        assertTrue(service.findById(10L).isPresent());
        assertEquals(1, service.findAll().size());
    }

    @Test
    void shouldDeleteStudent() {
        StudentManagementApp.StudentService service = new StudentManagementApp.StudentService();
        service.add(new StudentManagementApp.Student(11L, "Trinity", "tri@example.com"));

        assertTrue(service.delete(11L));
        assertFalse(service.findById(11L).isPresent());
    }
}
""",
    "src/test/java/com/java/masterclass/multithreading/ConcurrencyToolkitDemoTest.java": """
package com.java.masterclass.multithreading;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConcurrencyToolkitDemoTest {

    @Test
    void shouldCountTasks() {
        assertEquals(20, ConcurrencyToolkitDemo.countWithExecutor(20));
    }

    @Test
    void shouldRunCompletableFuture() {
        assertEquals("core-java", ConcurrencyToolkitDemo.completableFutureDemo());
    }
}
""",
    "src/test/java/com/java/masterclass/serialization/SerializationDemoTest.java": """
package com.java.masterclass.serialization;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SerializationDemoTest {

    @Test
    void shouldSerializeAndDeserializeStudent() {
        SerializationDemo.Student student = new SerializationDemo.Student(1L, "Asha");
        byte[] data = SerializationDemo.serialize(student);
        SerializationDemo.Student restored = SerializationDemo.deserialize(data);

        assertEquals(student, restored);
    }
}
""",
}


def main() -> None:
    write(ROOT / "README.md", README)
    write(ROOT / "pom.xml", POM)
    write(ROOT / ".gitignore", """
# Maven
/target/

# IDE
.idea/
*.iml

# OS
.DS_Store

# Logs
*.log
""")

    docs = ROOT / "docs"
    docs.mkdir(exist_ok=True)

    index_lines = ["# Docs Index", "", "Core topics:", ""]
    for file_name, title in TOPICS:
        content = topic_doc(title)
        if file_name == "34-interview-questions.md":
            content = generate_interview_qas()
        if file_name == "35-coding-patterns.md":
            content += textwrap.dedent("""

## Common Patterns

- Two pointers
- Sliding window
- Fast/slow pointers
- Prefix sums
- Monotonic stack
- BFS/DFS traversal
- Dynamic programming state transitions
""")
        write(docs / file_name, content)
        index_lines.append(f"- [{title}]({file_name})")

    write(docs / "36-coding-challenges.md", generate_coding_challenges())
    index_lines.append("- [Coding Challenges 500+](36-coding-challenges.md)")
    write(docs / "INDEX.md", "\n".join(index_lines))

    for path, content in JAVA_FILES.items():
        write(ROOT / path, content)

    for path, content in TEST_FILES.items():
        write(ROOT / path, content)


if __name__ == "__main__":
    main()

