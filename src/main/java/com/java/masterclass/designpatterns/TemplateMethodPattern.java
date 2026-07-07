package com.java.masterclass.designpatterns;

public final class TemplateMethodPattern {
    private TemplateMethodPattern() {}

    public abstract static class DataPipeline {
        public final String execute() {
            return read() + "|" + transform() + "|" + write();
        }

        protected abstract String read();

        protected abstract String transform();

        protected abstract String write();
    }

    public static final class CsvPipeline extends DataPipeline {
        protected String read() {
            return "read-csv";
        }

        protected String transform() {
            return "transform-csv";
        }

        protected String write() {
            return "write-db";
        }
    }
}
