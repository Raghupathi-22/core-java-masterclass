package com.java.masterclass.collections;

import java.util.*;

/**
 * Queue Interface Demonstrations
 * 
 * Covers:
 * - Queue operations (FIFO)
 * - Priority Queue (priority-based)
 * - Deque (double-ended queue)
 * - LinkedList and ArrayDeque implementations
 */
public class QueueDemo {

    /**
     * Demonstrates Queue basics (FIFO)
     */
    public static void demonstrateQueueBasics() {
        System.out.println("=== Queue Basics (FIFO) ===");
        
        Queue<String> taskQueue = new LinkedList<>();
        
        // Add elements
        taskQueue.offer("Task1");  // or add()
        taskQueue.offer("Task2");
        taskQueue.offer("Task3");
        taskQueue.offer("Task4");
        
        System.out.println("Queue: " + taskQueue);
        
        // Peek (view front without removing)
        System.out.println("Front task: " + taskQueue.peek());
        
        // Poll (remove from front)
        String task = taskQueue.poll();
        System.out.println("Processed: " + task);
        System.out.println("Queue after poll: " + taskQueue);
        
        // Process all tasks
        System.out.println("Processing remaining tasks:");
        while (!taskQueue.isEmpty()) {
            System.out.println("  Processing: " + taskQueue.poll());
        }
    }

    /**
     * Demonstrates Priority Queue
     */
    public static void demonstratePriorityQueue() {
        System.out.println("\n=== Priority Queue ===");
        
        Queue<Integer> priorityQueue = new PriorityQueue<>();
        
        priorityQueue.offer(30);
        priorityQueue.offer(10);
        priorityQueue.offer(50);
        priorityQueue.offer(20);
        priorityQueue.offer(40);
        
        System.out.println("Adding: 30, 10, 50, 20, 40");
        
        System.out.println("Processing by priority (min-heap):");
        while (!priorityQueue.isEmpty()) {
            System.out.println("  " + priorityQueue.poll());
        }
    }

    /**
     * Demonstrates Priority Queue with custom comparator
     */
    public static void demonstratePriorityQueueCustom() {
        System.out.println("\n=== Priority Queue (Max-Heap) ===");
        
        Queue<Integer> maxHeap = new PriorityQueue<>(
            (a, b) -> b - a  // Reverse order (max-heap)
        );
        
        maxHeap.offer(30);
        maxHeap.offer(10);
        maxHeap.offer(50);
        maxHeap.offer(20);
        maxHeap.offer(40);
        
        System.out.println("Processing by priority (max-heap):");
        while (!maxHeap.isEmpty()) {
            System.out.println("  " + maxHeap.poll());
        }
    }

    /**
     * Demonstrates Deque (Double-Ended Queue)
     */
    public static void demonstrateDeque() {
        System.out.println("\n=== Deque (Double-Ended Queue) ===");
        
        Deque<String> deque = new LinkedList<>();
        
        // Add at both ends
        deque.addFirst("First");
        deque.addLast("Last");
        deque.addFirst("Second");
        deque.addLast("Third");
        
        System.out.println("Deque: " + deque);
        
        // Remove from both ends
        System.out.println("Remove first: " + deque.removeFirst());
        System.out.println("Remove last: " + deque.removeLast());
        System.out.println("Deque: " + deque);
    }

    /**
     * Demonstrates Deque as Stack
     */
    public static void demonstrateDequeAsStack() {
        System.out.println("\n=== Deque as Stack (LIFO) ===");
        
        Deque<Integer> stack = new LinkedList<>();
        
        // Push
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("After pushes: " + stack);
        
        // Pop
        System.out.println("Pop: " + stack.pop());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Stack after pops: " + stack);
    }

    /**
     * Demonstrates ArrayDeque (more efficient than LinkedList)
     */
    public static void demonstrateArrayDeque() {
        System.out.println("\n=== ArrayDeque ===");
        
        Deque<String> arrayDeque = new ArrayDeque<>();
        
        arrayDeque.addFirst("A");
        arrayDeque.addLast("B");
        arrayDeque.addFirst("C");
        arrayDeque.addLast("D");
        
        System.out.println("ArrayDeque: " + arrayDeque);
        System.out.println("First: " + arrayDeque.getFirst());
        System.out.println("Last: " + arrayDeque.getLast());
    }

    /**
     * Demonstrates practical Queue usage: Task processing
     */
    public static void demonstrateTaskProcessing() {
        System.out.println("\n=== Task Processing System ===");
        
        Queue<Task> taskQueue = new LinkedList<>();
        
        taskQueue.offer(new Task(1, "Login user"));
        taskQueue.offer(new Task(2, "Validate request"));
        taskQueue.offer(new Task(3, "Process data"));
        taskQueue.offer(new Task(4, "Send response"));
        
        System.out.println("Processing tasks:");
        while (!taskQueue.isEmpty()) {
            Task task = taskQueue.poll();
            System.out.println("  [" + task.id + "] " + task.description);
        }
    }

    /**
     * Demonstrates practical Priority Queue usage: Job scheduling
     */
    public static void demonstrateJobScheduling() {
        System.out.println("\n=== Job Scheduling (Priority Queue) ===");
        
        Queue<Job> jobQueue = new PriorityQueue<>(
            (a, b) -> a.priority - b.priority  // Lower number = higher priority
        );
        
        jobQueue.offer(new Job("Email notification", 3));
        jobQueue.offer(new Job("Critical bug fix", 1));
        jobQueue.offer(new Job("Feature request", 2));
        jobQueue.offer(new Job("Documentation", 4));
        
        System.out.println("Processing jobs by priority:");
        while (!jobQueue.isEmpty()) {
            Job job = jobQueue.poll();
            System.out.println("  [P" + job.priority + "] " + job.name);
        }
    }

    /**
     * Demonstrates Queue performance comparison
     */
    public static void demonstrateQueuePerformance() {
        System.out.println("\n=== Queue Performance ===");
        
        int n = 100000;
        
        // LinkedList as Queue
        long start = System.nanoTime();
        Queue<Integer> linkedQueue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            linkedQueue.offer(i);
        }
        for (int i = 0; i < n; i++) {
            linkedQueue.poll();
        }
        long linkedTime = System.nanoTime() - start;
        
        // ArrayDeque as Queue
        start = System.nanoTime();
        Deque<Integer> arrayQueue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            arrayQueue.offer(i);
        }
        for (int i = 0; i < n; i++) {
            arrayQueue.poll();
        }
        long arrayTime = System.nanoTime() - start;
        
        System.out.println("LinkedList Queue: " + linkedTime + " ns");
        System.out.println("ArrayDeque Queue: " + arrayTime + " ns");
        System.out.println("ArrayDeque is " + (linkedTime/arrayTime) + "x faster");
    }

    static class Task {
        int id;
        String description;
        
        Task(int id, String description) {
            this.id = id;
            this.description = description;
        }
    }

    static class Job implements Comparable<Job> {
        String name;
        int priority;  // 1 = highest, higher number = lower priority
        
        Job(String name, int priority) {
            this.name = name;
            this.priority = priority;
        }
        
        @Override
        public int compareTo(Job other) {
            return this.priority - other.priority;
        }
    }

    public static void main(String[] args) {
        demonstrateQueueBasics();
        demonstratePriorityQueue();
        demonstratePriorityQueueCustom();
        demonstrateDeque();
        demonstrateDequeAsStack();
        demonstrateArrayDeque();
        demonstrateTaskProcessing();
        demonstrateJobScheduling();
        demonstrateQueuePerformance();
    }
}
