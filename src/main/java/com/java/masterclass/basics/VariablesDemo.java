package com.java.masterclass.basics;

public final class VariablesDemo {
    private VariablesDemo() {}

    public static void run() {
        int age = 30;
        double salary = 105000.50;
        boolean active = true;
        char grade = 'A';
        String name = "Alex";

        System.out.printf("name=%s age=%d salary=%.2f active=%s grade=%s%n",
                name, age, salary, active, grade);
    }
}
