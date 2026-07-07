package com.java.masterclass.filehandling;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

public final class PropertiesHandler {
    private PropertiesHandler() {}

    public static Properties load(Path path) {
        Properties properties = new Properties();
        try (InputStream in = Files.newInputStream(path)) {
            properties.load(in);
            return properties;
        } catch (IOException e) {
            throw new IllegalStateException("Failed to load properties", e);
        }
    }

    public static void save(Path path, Properties properties) {
        try (OutputStream out = Files.newOutputStream(path)) {
            properties.store(out, "core-java-masterclass");
        } catch (IOException e) {
            throw new IllegalStateException("Failed to save properties", e);
        }
    }
}
