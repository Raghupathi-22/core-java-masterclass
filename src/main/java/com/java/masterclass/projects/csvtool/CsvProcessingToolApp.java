package com.java.masterclass.projects.csvtool;

import com.java.masterclass.filehandling.CsvProcessor;

import java.nio.file.Path;
import java.util.List;

public final class CsvProcessingToolApp {
    private CsvProcessingToolApp() {}

    public static long rowCount(Path path) {
        List<String[]> rows = CsvProcessor.read(path);
        return rows.size();
    }
}
