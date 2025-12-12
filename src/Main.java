import model.Event;
import processor.*;
import services.*;

public class Main {

    public static void main(String[] args) {

        ConnectionPool pool = new ConnectionPool(2);
        Database db = new Database();
        SecurityMonitor monitor = new SecurityMonitor();

        EventProcessor processor = new EventProcessor(db, monitor);
        processor.addObserver(new Dashboard());
        processor.addObserver(new Logger());

        EventProcessorProxy proxy = new EventProcessorProxy(processor, pool);

        Event e1 = new Event("USER", "user-click");
        e1.setEncrypt(true);
        e1.setAddMetadata(true);
        e1.setMetadata("u=42");

        proxy.process(e1);

        Event e2 = new Event("SECURITY", "failed-login");
        e2.setCompress(true);

        proxy.process(e2);
    }
}
