package processor;

import model.Event;

public abstract class AbstractEventProcessor {

    public final void process(Event e) {
        validate(e);
        String data = transform(e);
        persist(e, data);
        afterProcess(e);
    }

    protected abstract void validate(Event e);
    protected abstract String transform(Event e);
    protected abstract void persist(Event e, String data);
    protected abstract void afterProcess(Event e);
}
