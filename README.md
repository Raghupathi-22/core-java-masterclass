# Core Java Masterclass (Java 26)

A production-oriented Core Java repository for:

- learning Java from scratch,
- interview preparation (beginner -> architect),
- coding practice with solutions,
- real-world project examples,
- clean coding and architecture practices.

## Tech Stack

- Java 26 (latest feature release)
- Maven
- JUnit 5
- Jackson (JSON examples)

## Learning Path

1. Java Basics -> OOP -> Collections
2. Exception Handling -> I/O/NIO -> Serialization
3. Generics -> Java 8 Streams/Lambdas -> Java 17/21/22/23/24/25/26 features
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
│   │   ├── java26/
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

## Java Version Notes

- `pom.xml` is set to Java 26.
- If your machine is on Java 21/17, install JDK 26 to build this branch.
- Optional fallback for local experimentation: temporarily lower `<maven.compiler.release>` to your local JDK.

## Contribution Rules

- Follow SOLID, DRY, KISS.
- Keep classes cohesive and methods small.
- Add tests for every new behavior.
- Prefer immutable data and explicit naming.
