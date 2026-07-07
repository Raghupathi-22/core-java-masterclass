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
