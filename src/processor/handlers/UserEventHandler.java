package processor.handlers;

import model.Event;

public class UserEventHandler implements EventHandler {

    @Override
    public void handle(Event e) {
        System.out.println("[USER] user-specific step for " + e.getId());
    }
}
