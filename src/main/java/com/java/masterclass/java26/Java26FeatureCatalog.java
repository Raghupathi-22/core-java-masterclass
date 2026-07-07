package com.java.masterclass.java26;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Version-aware catalog of Java features from 22 through 26.
 * This class is intentionally plain Java so it can run as a lightweight verifier.
 */
public final class Java26FeatureCatalog {
    private Java26FeatureCatalog() {
    }

    public static String latestVersion() {
        return "Java 26";
    }

    public static Map<String, List<String>> featuresByVersion() {
        Map<String, List<String>> features = new LinkedHashMap<>();

        features.put("Java 22", List.of(
                "Unnamed Variables and Patterns (Preview)",
                "Statements before super(...) (Preview)",
                "Foreign Function and Memory API (Final)",
                "Structured Concurrency (Preview)",
                "Scoped Values (Preview)",
                "String Templates (Preview)"
        ));

        features.put("Java 23", List.of(
                "Primitive patterns in switch (Preview)",
                "Module Import Declarations (Preview)",
                "Markdown Documentation Comments (Preview)",
                "Stream Gatherers (Preview)",
                "Class-File API (Preview)",
                "Vector API (Incubator)"
        ));

        features.put("Java 24", List.of(
                "Stream Gatherers (Final)",
                "Class-File API (Final)",
                "Scoped Values (Final)",
                "Structured Concurrency (Final)",
                "Primitive Patterns (Preview evolution)",
                "Key Derivation Function API (Preview)"
        ));

        features.put("Java 25", List.of(
                "Platform consolidation and performance improvements",
                "Pattern matching family refinements",
                "GC and runtime tuning improvements"
        ));

        features.put("Java 26", List.of(
                "Latest feature release baseline",
                "Carries forward final features from 21-25",
                "Current preview/incubator pipeline updates"
        ));

        return features;
    }

    public static int totalFeatureItems() {
        return featuresByVersion().values().stream().mapToInt(List::size).sum();
    }

    public static List<String> allFeaturesFlat() {
        List<String> flattened = new ArrayList<>();
        for (List<String> list : featuresByVersion().values()) {
            flattened.addAll(list);
        }
        return flattened;
    }

    public static void main(String[] args) {
        System.out.println("Latest supported feature release: " + latestVersion());
        System.out.println("Total tracked feature items: " + totalFeatureItems());
        System.out.println("Tracked versions: " + featuresByVersion().keySet());
    }
}

