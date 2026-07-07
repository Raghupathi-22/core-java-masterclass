package com.java.masterclass.java8;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public final class LambdaAndStreamPractice {
    private LambdaAndStreamPractice() {}

    public static List<String> uppercaseSorted(List<String> input) {
        return input.stream()
                .map(String::toUpperCase)
                .sorted()
                .toList();
    }

    public static Map<String, Long> frequency(List<String> input) {
        return input.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }
}
