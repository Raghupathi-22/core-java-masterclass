package com.java.masterclass.designpatterns;

public final class DecoratorPattern {
    private DecoratorPattern() {}

    public interface Message {
        String value();
    }

    public static final class PlainMessage implements Message {
        private final String text;

        public PlainMessage(String text) {
            this.text = text;
        }

        public String value() {
            return text;
        }
    }

    public static final class UppercaseDecorator implements Message {
        private final Message source;

        public UppercaseDecorator(Message source) {
            this.source = source;
        }

        public String value() {
            return source.value().toUpperCase();
        }
    }
}
