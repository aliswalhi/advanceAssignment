package services;

import model.Event;
import processor.observers.EventObserver;

public class Dashboard implements EventObserver {

    @Override
    public void update(Event e) {
        System.out.println("[Dashboard] metrics updated for " + e.getType());
    }
}

