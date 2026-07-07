package com.java.masterclass.designpatterns;

public final class FacadePattern {
    private FacadePattern() {}

    public static final class OrderFacade {
        public String placeOrder(String productId) {
            return "validated->paid->shipped:" + productId;
        }
    }
}
