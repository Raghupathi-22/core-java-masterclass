package com.java.masterclass.designpatterns;

import java.util.ArrayDeque;
import java.util.Deque;

public final class CommandPattern {
    private CommandPattern() {}

    public interface Command {
        String execute();
    }

    public static final class CommandBus {
        private final Deque<String> history = new ArrayDeque<>();

        public String run(Command command) {
            String result = command.execute();
            history.push(result);
            return result;
        }

        public String latest() {
            return history.peek();
        }
    }
}
