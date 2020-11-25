import java.util.Objects;
import java.util.UUID;

public class Delivery {
    private UUID id;
    private User sender;
    private User receiver;
    private double weight;
    private DeliveryType deliveryType;

    public Delivery(UUID id, User sender, User receiver, double weight, DeliveryType deliveryType) {
        this.id = id;
        this.sender = sender;
        this.receiver = receiver;
        this.weight = weight;
        this.deliveryType = deliveryType;
    }

    public UUID getId() {
        return id;
    }

    public User getSender() {
        return sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public double getWeight() {
        return weight;
    }

    public DeliveryType getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(DeliveryType deliveryType) {
        this.deliveryType = deliveryType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Delivery delivery = (Delivery) o;
        return Objects.equals(id, delivery.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
