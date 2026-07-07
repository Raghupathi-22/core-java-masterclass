package com.java.masterclass.filehandling;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public final class CsvProcessor {
    private CsvProcessor() {}

    public static List<String[]> read(Path path) {
        try {
            List<String[]> rows = new ArrayList<>();
            for (String line : Files.readAllLines(path, StandardCharsets.UTF_8)) {
                rows.add(line.split(","));
            }
            return rows;
        } catch (IOException e) {
            throw new IllegalStateException("Failed to read CSV", e);
        }
    }

    public static void write(Path path, List<String[]> rows) {
        List<String> lines = rows.stream().map(cols -> String.join(",", cols)).toList();
        try {
            Files.write(path, lines, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new IllegalStateException("Failed to write CSV", e);
        }
    }
}
