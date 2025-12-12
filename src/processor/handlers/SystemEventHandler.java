package processor.handlers;

import model.Event;

public class SystemEventHandler implements EventHandler {

    @Override
    public void handle(Event e) {
        System.out.println("[SYSTEM] system audit log " + e.getId());
    }
}
