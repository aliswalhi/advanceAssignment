package processor;

import model.Event;
import processor.decorators.*;
import processor.handlers.*;
import processor.observers.EventObserver;
import services.*;

import java.util.*;

public class EventProcessor extends AbstractEventProcessor {

    private Database database;
    private Map<String, EventHandler> handlers = new HashMap<>();
    private List<EventObserver> observers = new ArrayList<>();

    public EventProcessor(Database db, SecurityMonitor monitor) {
        this.database = db;
        handlers.put("USER", new UserEventHandler());
        handlers.put("SYSTEM", new SystemEventHandler());
        handlers.put("SECURITY", new SecurityEventHandler(monitor));
    }

    public void addObserver(EventObserver observer) {
        observers.add(observer);
    }

    @Override
    protected void validate(Event e) {
        if (e.getPayload() == null || e.getPayload().isEmpty())
            throw new RuntimeException("Invalid event");
    }

    @Override
    protected String transform(Event e) {
        EventData data = new BaseEventData(e.getPayload());

        if (e.isEncrypt()) data = new EncryptionDecorator(data);
        if (e.isCompress()) data = new CompressionDecorator(data);
        if (e.isAddMetadata()) data = new MetadataDecorator(data, e.getMetadata());

        return data.getData();
    }

    @Override
    protected void persist(Event e, String data) {
        e.setId(System.currentTimeMillis() + "-" + Math.abs(data.hashCode()));
        database.save(e.getId(), data);
    }

    @Override
    protected void afterProcess(Event e) {
        for (EventObserver o : observers) o.update(e);
        EventHandler handler = handlers.get(e.getType());
        if (handler != null) handler.handle(e);
    }
}
