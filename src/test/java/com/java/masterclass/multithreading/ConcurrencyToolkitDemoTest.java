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
