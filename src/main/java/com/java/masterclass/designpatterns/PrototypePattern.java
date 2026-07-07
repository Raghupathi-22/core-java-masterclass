package com.java.masterclass.designpatterns;

public final class PrototypePattern {
    private PrototypePattern() {}

    public record Document(String title, String body) implements Cloneable {
        @Override
        public Document clone() {
            return new Document(title, body);
        }
    }
}
