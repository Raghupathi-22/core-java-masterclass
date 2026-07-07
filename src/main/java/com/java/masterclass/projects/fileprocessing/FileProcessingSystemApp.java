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
