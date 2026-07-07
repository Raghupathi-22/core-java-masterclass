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
