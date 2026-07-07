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
