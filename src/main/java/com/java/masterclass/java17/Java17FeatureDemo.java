package com.java.masterclass.java17;

public final class Java17FeatureDemo {
    private Java17FeatureDemo() {}

    public record EmployeeRecord(long id, String name) {}

    public sealed interface Payment permits CardPayment, UpiPayment {
        String process();
    }

    public record CardPayment(String cardNo) implements Payment {
        public String process() { return "card:" + cardNo; }
    }

    public record UpiPayment(String upiId) implements Payment {
        public String process() { return "upi:" + upiId; }
    }

    public static String describe(Object o) {
        return switch (o) {
            case Integer i -> "int:" + i;
            case String s -> "string:" + s;
            case null -> "null";
            default -> "other";
        };
    }
}
