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
