package com.java.masterclass.designpatterns;

public final class StrategyPattern {
    private StrategyPattern() {}

    public interface DiscountStrategy {
        double apply(double amount);
    }

    public static final class NoDiscount implements DiscountStrategy {
        public double apply(double amount) { return amount; }
    }

    public static final class FestivalDiscount implements DiscountStrategy {
        public double apply(double amount) { return amount * 0.9; }
    }

    public static double checkout(double amount, DiscountStrategy strategy) {
        return strategy.apply(amount);
    }
}
