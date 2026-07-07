package com.java.masterclass.designpatterns;

public final class SingletonPattern {
    private SingletonPattern() {}

    public enum ConfigManager {
        INSTANCE;

        public String value(String key) {
            return "value-for-" + key;
        }
    }
}
