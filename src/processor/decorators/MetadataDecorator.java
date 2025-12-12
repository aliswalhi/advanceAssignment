package processor.decorators;

public class MetadataDecorator extends EventDataDecorator {

    private String metadata;

    public MetadataDecorator(EventData wrappee, String metadata) {
        super(wrappee);
        this.metadata = metadata;
    }

    @Override
    public String getData() {
        return "META(" + metadata + ")::" + wrappee.getData();
    }
}

