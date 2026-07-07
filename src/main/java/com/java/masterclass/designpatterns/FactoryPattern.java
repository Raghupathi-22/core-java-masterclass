package com.java.masterclass.designpatterns;

public final class FactoryPattern {
    private FactoryPattern() {}

    public interface Notification {
        String send(String msg);
    }

    public static final class EmailNotification implements Notification {
        public String send(String msg) { return "email:" + msg; }
    }

    public static final class SmsNotification implements Notification {
        public String send(String msg) { return "sms:" + msg; }
    }

    public static Notification create(String type) {
        return switch (type.toLowerCase()) {
            case "email" -> new EmailNotification();
            case "sms" -> new SmsNotification();
            default -> throw new IllegalArgumentException("Unknown type: " + type);
        };
    }
}
