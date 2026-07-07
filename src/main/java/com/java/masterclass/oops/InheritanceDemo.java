package com.java.masterclass.oops;

public final class InheritanceDemo {
    private InheritanceDemo() {}

    static class Animal {
        String speak() { return "sound"; }
    }

    static class Dog extends Animal {
        @Override
        String speak() { return "bark"; }
    }

    public static String demo() {
        Animal a = new Dog();
        return a.speak();
    }
}
