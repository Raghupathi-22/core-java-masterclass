package com.java.masterclass.oops;

public final class CompositionDemo {
    private CompositionDemo() {}

    static class Engine {
        String start() { return "engine-started"; }
    }

    static class Car {
        private final Engine engine = new Engine();

        String drive() {
            return engine.start() + ":driving";
        }
    }

    public static String demo() {
        return new Car().drive();
    }
}
