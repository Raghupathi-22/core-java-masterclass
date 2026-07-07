# Java 22-26 Features

## 1. Theory

Java now ships every 6 months, so modern teams need version-aware development.
This guide tracks major features from Java 22 to Java 26 and marks whether each feature is final, preview, or incubator.

## 2. Notes

- Use final features by default in production.
- Use preview features only when your build/runtime pipeline explicitly enables preview flags.
- Keep language-level upgrades incremental and backed by tests.
- Separate syntax upgrades from behavioral refactors to reduce risk.

## 3. Example Code

- Source example: `src/main/java/com/java/masterclass/java26/Java26FeatureCatalog.java`

## 4. Feature Coverage (Java 22 -> Java 26)

### Java 22

- Unnamed Variables and Patterns (Preview)
- Statements before `super(...)` in constructors (Preview)
- Foreign Function and Memory API (Final)
- Structured Concurrency (Second Preview)
- Scoped Values (Second Preview)
- String Templates (Second Preview)
- Class-File API (Preview)
- Vector API (Incubator)

### Java 23

- Primitive types in patterns / `instanceof` / `switch` (Preview)
- Module Import Declarations (Preview)
- Markdown Documentation Comments (Preview)
- Structured Concurrency (Third Preview)
- Scoped Values (Preview)
- Stream Gatherers (Preview)
- Class-File API (Second Preview)
- Vector API (Incubator)

### Java 24

- Stream Gatherers (Final)
- Class-File API (Final)
- Scoped Values (Final)
- Structured Concurrency (Final)
- Primitive Patterns (Preview evolution)
- Key Derivation Function API (Preview)
- Quantum-Resistant Module-Lattice Crypto (Preview)

### Java 25

- Stable platform consolidation release (language, VM, and library improvements)
- Continued maturation of pattern matching family
- Ongoing performance and GC tuning updates

### Java 26

- Latest feature-release baseline for this repository
- Includes prior final features and updated preview/incubator pipeline
- Recommended for developers preparing for senior and architect interviews on modern Java

## 5. Practice Problems

1. Convert one service from platform threads to virtual-thread executors.
2. Replace callback-based async code with structured concurrency style.
3. Use scoped values to propagate request context without thread-locals.
4. Refactor a parser pipeline with stream gatherers.
5. Design a migration checklist from Java 17 to Java 26.
6. Implement a compatibility matrix for final vs preview features.

## 6. Interview Questions

1. How do you decide if a preview feature is safe for production?
2. What migration strategy do you use from Java 17/21 to Java 26?
3. Why are scoped values often safer than mutable thread-local context?
4. How does structured concurrency improve failure handling?
5. What are the trade-offs of fast feature-release adoption?

## 7. Interview Answers

1. Prefer final features for production; preview only behind strict CI checks, runtime flags, and rollback plans.
2. Upgrade JDK/toolchain first, run full tests, then adopt features in small, isolated PRs.
3. Scoped values support immutable context propagation and reduce accidental shared mutation.
4. Structured concurrency gives explicit task lifecycles, cancellation, and clear parent-child ownership.
5. You gain productivity and performance features quickly, but need disciplined release management.

## 8. Real-world Use Cases

- High-throughput APIs using virtual threads and structured concurrency
- Secure services adopting modern cryptography APIs
- Large codebases modernized incrementally with version-aware build pipelines
- Interview prep for modern Java language and platform evolution

