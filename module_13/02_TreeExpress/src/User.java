import java.util.Objects;
import java.util.UUID;

public class User {
    private UUID uuid;
    private String name, lastname, address;

    public User(UUID uuid, String name, String lastname, String address) {
        this.uuid = uuid;
        this.name = name;
        this.lastname = lastname;
        this.address = address;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(uuid, user.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid);
    }
}
