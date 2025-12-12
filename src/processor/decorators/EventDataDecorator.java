package processor.decorators;

public abstract class EventDataDecorator implements EventData {

    protected EventData wrappee;

    public EventDataDecorator(EventData wrappee) {
        this.wrappee = wrappee;
    }
}
