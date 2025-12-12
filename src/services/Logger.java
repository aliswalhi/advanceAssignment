package services;

import model.Event;
import processor.observers.EventObserver;

public class Logger implements EventObserver {

    @Override
    public void update(Event e) {
        System.out.println("[LOG] Logged event " + e.getId());
    }
}
