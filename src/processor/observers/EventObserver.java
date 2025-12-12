package processor.observers;

import model.Event;

public interface EventObserver {
    void update(Event event);
}
