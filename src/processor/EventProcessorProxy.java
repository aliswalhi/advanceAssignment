package processor;

import model.Event;
import services.ConnectionPool;

public class EventProcessorProxy {

    private EventProcessor processor;
    private ConnectionPool pool;

    public EventProcessorProxy(EventProcessor processor, ConnectionPool pool) {
        this.processor = processor;
        this.pool = pool;
    }

    public void process(Event e) {
        Object conn = pool.acquire();
        long start = System.currentTimeMillis();
        try {
            processor.process(e);
        } finally {
            pool.release(conn);
            System.out.println("[Proxy] Event processed in " +
                    (System.currentTimeMillis() - start) + "ms");
        }
    }
}
