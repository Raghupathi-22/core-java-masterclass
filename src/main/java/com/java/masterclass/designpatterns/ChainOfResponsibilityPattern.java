package com.java.masterclass.designpatterns;

public final class ChainOfResponsibilityPattern {
    private ChainOfResponsibilityPattern() {}

    public interface Handler {
        String handle(String request);
    }

    public static final class AuthHandler implements Handler {
        private final Handler next;

        public AuthHandler(Handler next) {
            this.next = next;
        }

        public String handle(String request) {
            if (request.startsWith("token:")) {
                return next.handle(request);
            }
            return "auth-failed";
        }
    }

    public static final class BusinessHandler implements Handler {
        public String handle(String request) {
            return "processed:" + request;
        }
    }
}
