package com.java.masterclass.designpatterns;

public final class ProxyPattern {
    private ProxyPattern() {}

    public interface DataService {
        String fetch();
    }

    public static final class RealDataService implements DataService {
        public String fetch() {
            return "secure-data";
        }
    }

    public static final class AuthProxy implements DataService {
        private final DataService target = new RealDataService();
        private final boolean allowed;

        public AuthProxy(boolean allowed) {
            this.allowed = allowed;
        }

        public String fetch() {
            if (!allowed) {
                throw new IllegalStateException("Unauthorized");
            }
            return target.fetch();
        }
    }
}
