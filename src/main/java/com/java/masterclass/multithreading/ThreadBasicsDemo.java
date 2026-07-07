package com.java.masterclass.multithreading;

/**
 * Multithreading Basics Demonstrations
 * 
 * Covers:
 * - Thread creation (extend Thread)
 * - Thread creation (implement Runnable)
 * - Thread lifecycle
 * - Thread methods
 * - Naming threads
 */
public class ThreadBasicsDemo {

    /**
     * Method 1: Extend Thread class
     */
    static class MyThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + " - Count: " + i);
                try {
                    Thread.sleep(1000);  // Sleep 1 second
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Method 2: Implement Runnable
     */
    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + " - Value: " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Demonstrates creating and starting threads
     */
    public static void demonstrateThreadCreation() {
        System.out.println("=== Thread Creation ===");
        
        // Method 1: Extend Thread
        MyThread thread1 = new MyThread();
        thread1.setName("Thread-1");
        thread1.start();
        
        // Method 2: Implement Runnable
        Thread thread2 = new Thread(new MyRunnable(), "Thread-2");
        thread2.start();
        
        // Method 3: Lambda (Java 8+)
        Thread thread3 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Lambda Thread - Count: " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Thread-3");
        thread3.start();
    }

    /**
     * Demonstrates thread information
     */
    public static void demonstrateThreadInfo() {
        System.out.println("\n=== Thread Information ===");
        
        Thread currentThread = Thread.currentThread();
        System.out.println("Current thread name: " + currentThread.getName());
        System.out.println("Thread ID: " + currentThread.getId());
        System.out.println("Priority: " + currentThread.getPriority());
        System.out.println("Is alive: " + currentThread.isAlive());
        System.out.println("Is daemon: " + currentThread.isDaemon());
        System.out.println("State: " + currentThread.getState());
    }

    /**
     * Demonstrates thread priority
     */
    public static void demonstrateThreadPriority() {
        System.out.println("\n=== Thread Priority ===");
        
        Runnable task = () -> {
            for (int i = 0; i < 3; i++) {
                System.out.println(Thread.currentThread().getName() + 
                    " (P" + Thread.currentThread().getPriority() + ")");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        
        Thread highPriority = new Thread(task, "HighPriority");
        highPriority.setPriority(Thread.MAX_PRIORITY);
        
        Thread normalPriority = new Thread(task, "Normal");
        normalPriority.setPriority(Thread.NORM_PRIORITY);
        
        Thread lowPriority = new Thread(task, "LowPriority");
        lowPriority.setPriority(Thread.MIN_PRIORITY);
        
        lowPriority.start();
        normalPriority.start();
        highPriority.start();
    }

    /**
     * Demonstrates join()
     */
    public static void demonstrateJoin() throws InterruptedException {
        System.out.println("\n=== Thread Join ===");
        
        Thread thread1 = new Thread(() -> {
            System.out.println("Thread 1 started");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread 1 finished");
        }, "T1");
        
        Thread thread2 = new Thread(() -> {
            System.out.println("Thread 2 started");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread 2 finished");
        }, "T2");
        
        thread1.start();
        thread2.start();
        
        // Wait for threads to complete
        thread1.join();
        thread2.join();
        
        System.out.println("All threads completed");
    }

    /**
     * Demonstrates daemon threads
     */
    public static void demonstrateDaemonThreads() throws InterruptedException {
        System.out.println("\n=== Daemon Threads ===");
        
        Thread daemonThread = new Thread(() -> {
            while (true) {
                System.out.println("Daemon thread running");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "DaemonThread");
        
        // Must set before starting
        daemonThread.setDaemon(true);
        daemonThread.start();
        
        Thread mainThread = new Thread(() -> {
            try {
                Thread.sleep(2000);
                System.out.println("Main thread completed");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "MainThread");
        
        mainThread.start();
        mainThread.join();
        
        System.out.println("Program ended (daemon thread stopped automatically)");
    }

    /**
     * Demonstrates thread states
     */
    public static void demonstrateThreadStates() {
        System.out.println("\n=== Thread States ===");
        
        Thread thread = new Thread(() -> {
            System.out.println("Thread is RUNNING");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread finished");
        }, "StateThread");
        
        System.out.println("State before start: " + thread.getState());  // NEW
        
        thread.start();
        System.out.println("State after start: " + thread.getState());   // RUNNABLE
        
        try {
            Thread.sleep(100);
            System.out.println("State during execution: " + thread.getState());
            thread.join();
            System.out.println("State after completion: " + thread.getState());  // TERMINATED
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Demonstrates multiple concurrent threads
     */
    public static void demonstrateMultipleThreads() {
        System.out.println("\n=== Multiple Concurrent Threads ===");
        
        for (int i = 1; i <= 3; i++) {
            final int threadNum = i;
            Thread t = new Thread(() -> {
                System.out.println("Thread " + threadNum + " started");
                try {
                    Thread.sleep((long) (Math.random() * 2000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread " + threadNum + " finished");
            }, "Worker-" + i);
            
            t.start();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        demonstrateThreadCreation();
        demonstrateThreadInfo();
        demonstrateThreadPriority();
        demonstrateJoin();
        demonstrateDaemonThreads();
        demonstrateThreadStates();
        demonstrateMultipleThreads();
    }
}
