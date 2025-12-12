package model;

public class Event implements Cloneable {

    private String type;
    private String payload;
    private boolean encrypt, compress, addMetadata;
    private String metadata;
    private String id;

    public Event(String type, String payload) {
        this.type = type;
        this.payload = payload;
    }

    public String getType() { return type; }
    public String getPayload() { return payload; }

    public boolean isEncrypt() { return encrypt; }
    public boolean isCompress() { return compress; }
    public boolean isAddMetadata() { return addMetadata; }

    public void setEncrypt(boolean encrypt) { this.encrypt = encrypt; }
    public void setCompress(boolean compress) { this.compress = compress; }
    public void setAddMetadata(boolean addMetadata) { this.addMetadata = addMetadata; }

    public String getMetadata() { return metadata; }
    public void setMetadata(String metadata) { this.metadata = metadata; }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    @Override
    public Event clone() {
        try {
            return (Event) super.clone();
        } catch (Exception e) {
            return null;
        }
    }
}
