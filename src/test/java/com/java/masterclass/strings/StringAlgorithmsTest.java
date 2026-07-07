package com.java.masterclass.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringAlgorithmsTest {

    @Test
    void shouldValidateAnagram() {
        assertTrue(StringAlgorithms.isAnagram("listen", "silent"));
        assertFalse(StringAlgorithms.isAnagram("listen", "silence"));
    }

    @Test
    void shouldValidatePalindrome() {
        assertTrue(StringAlgorithms.isPalindrome("level"));
        assertFalse(StringAlgorithms.isPalindrome("java"));
    }

    @Test
    void shouldFindFirstNonRepeatedCharacter() {
        assertEquals('w', StringAlgorithms.firstNonRepeatedChar("swiss"));
    }

    @Test
    void shouldFindLongestUniqueSubstringLength() {
        assertEquals(3, StringAlgorithms.longestUniqueSubstringLength("abcabcbb"));
    }
}
