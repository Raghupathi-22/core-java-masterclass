package com.java.masterclass.java26;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Java26FeatureCatalogTest {

    @Test
    void shouldExposeLatestVersion() {
        assertEquals("Java 26", Java26FeatureCatalog.latestVersion());
    }

    @Test
    void shouldContainFeatureListsForAllTrackedVersions() {
        var features = Java26FeatureCatalog.featuresByVersion();
        assertTrue(features.containsKey("Java 22"));
        assertTrue(features.containsKey("Java 23"));
        assertTrue(features.containsKey("Java 24"));
        assertTrue(features.containsKey("Java 25"));
        assertTrue(features.containsKey("Java 26"));
    }

    @Test
    void shouldHaveNonZeroFeatureItemCount() {
        assertTrue(Java26FeatureCatalog.totalFeatureItems() > 0);
    }
}

