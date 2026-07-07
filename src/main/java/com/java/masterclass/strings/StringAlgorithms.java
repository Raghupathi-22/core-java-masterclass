package com.java.masterclass.strings;

import java.util.HashMap;
import java.util.Map;

public final class StringAlgorithms {
    private StringAlgorithms() {}

    public static boolean isAnagram(String left, String right) {
        if (left == null || right == null) return false;
        String a = left.replaceAll("\s+", "").toLowerCase();
        String b = right.replaceAll("\s+", "").toLowerCase();
        if (a.length() != b.length()) return false;

        int[] count = new int[26];
        for (int i = 0; i < a.length(); i++) {
            count[a.charAt(i) - 'a']++;
            count[b.charAt(i) - 'a']--;
        }
        for (int c : count) {
            if (c != 0) return false;
        }
        return true;
    }

    public static boolean isPalindrome(String value) {
        if (value == null) return false;
        int l = 0;
        int r = value.length() - 1;
        while (l < r) {
            if (value.charAt(l++) != value.charAt(r--)) {
                return false;
            }
        }
        return true;
    }

    public static String reverse(String value) {
        if (value == null) return null;
        return new StringBuilder(value).reverse().toString();
    }

    public static Map<Character, Integer> characterCount(String value) {
        Map<Character, Integer> counts = new HashMap<>();
        if (value == null) return counts;
        for (char c : value.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }
        return counts;
    }

    public static Character firstNonRepeatedChar(String value) {
        if (value == null || value.isBlank()) return null;
        Map<Character, Integer> counts = characterCount(value);
        for (char c : value.toCharArray()) {
            if (counts.get(c) == 1) return c;
        }
        return null;
    }

    public static int longestUniqueSubstringLength(String value) {
        if (value == null || value.isEmpty()) return 0;
        int[] lastSeen = new int[256];
        for (int i = 0; i < lastSeen.length; i++) lastSeen[i] = -1;

        int start = 0;
        int best = 0;
        for (int i = 0; i < value.length(); i++) {
            int ch = value.charAt(i);
            if (lastSeen[ch] >= start) {
                start = lastSeen[ch] + 1;
            }
            lastSeen[ch] = i;
            best = Math.max(best, i - start + 1);
        }
        return best;
    }
}
