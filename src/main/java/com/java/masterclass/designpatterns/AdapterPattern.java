package com.java.masterclass.designpatterns;

public final class AdapterPattern {
    private AdapterPattern() {}

    public interface ModernPrinter {
        String print(String content);
    }

    public static final class LegacyPrinter {
        public String legacyPrint(String content) {
            return "legacy:" + content;
        }
    }

    public static final class LegacyPrinterAdapter implements ModernPrinter {
        private final LegacyPrinter legacyPrinter = new LegacyPrinter();

        @Override
        public String print(String content) {
            return legacyPrinter.legacyPrint(content);
        }
    }
}
