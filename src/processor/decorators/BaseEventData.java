package processor.decorators;

public class BaseEventData implements EventData {

    private String data;

    public BaseEventData(String data) {
        this.data = data;
    }

    @Override
    public String getData() {
        return data;
    }
}
