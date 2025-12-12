package processor.decorators;

public class CompressionDecorator extends EventDataDecorator {

    public CompressionDecorator(EventData wrappee) {
        super(wrappee);
    }

    @Override
    public String getData() {
        return "CMP(" + wrappee.getData() + ")";
    }
}
