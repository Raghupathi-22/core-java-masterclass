package com.java.masterclass.designpatterns;

import java.util.ArrayList;
import java.util.List;

public final class ObserverPattern {
    private ObserverPattern() {}

    public interface Observer {
        void update(String message);
    }

    public static final class Subject {
        private final List<Observer> observers = new ArrayList<>();

        public void subscribe(Observer observer) {
            observers.add(observer);
        }

        public void notifyAllObservers(String message) {
            observers.forEach(o -> o.update(message));
        }
    }
}
