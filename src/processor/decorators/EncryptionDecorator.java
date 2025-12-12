package processor.decorators;

public class EncryptionDecorator extends EventDataDecorator {

    public EncryptionDecorator(EventData wrappee) {
        super(wrappee);
    }

    @Override
    public String getData() {
        return "ENC(" + wrappee.getData() + ")";
    }
}
