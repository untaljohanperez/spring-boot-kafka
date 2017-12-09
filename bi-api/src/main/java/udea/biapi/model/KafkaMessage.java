package udea.biapi.model;

public class KafkaMessage {

    private String topic;
    private String message;

    public KafkaMessage(String topic, String message) {
        this.topic = topic;
        this.message = message;
    }

    public String getTopic() {
        return topic;
    }

    public String getMessage() {
        return message;
    }
}
