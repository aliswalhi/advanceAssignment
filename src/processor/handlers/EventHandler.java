package processor.handlers;

import model.Event;

public interface EventHandler {
    void handle(Event e);
}
