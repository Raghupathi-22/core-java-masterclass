package com.java.masterclass.basics;

public final class ControlFlowDemo {
    private ControlFlowDemo() {}

    public static String classifyNumber(int n) {
        if (n == 0) return "zero";
        if (n > 0) return "positive";
        return "negative";
    }
}
