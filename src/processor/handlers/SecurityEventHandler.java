package processor.handlers;

import model.Event;
import services.SecurityMonitor;

public class SecurityEventHandler implements EventHandler {

    private SecurityMonitor monitor;

    public SecurityEventHandler(SecurityMonitor monitor) {
        this.monitor = monitor;
    }

    @Override
    public void handle(Event e) {
        System.out.println("[SECURITY] extra analysis for " + e.getId());
        monitor.alert(e.getId());
    }
}
