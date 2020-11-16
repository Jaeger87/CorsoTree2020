import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class User implements Comparable<User> {

    private UUID id;
    private String name;
    private String surname;
    private Instant signup;
    private Set<UUID> friends;

    public User(String name, String surname) {
        id = UUID.randomUUID();
        this.name = name;
        this.surname = surname;
        signup = Instant.now();
        friends = new HashSet<>();
    }

    public UUID getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Instant getSignup() {
        return signup;
    }

    public Set<UUID> getFriends() {
        return friends;
    }

    public void addFriend(UUID friend){
        friends.add(friend);
    }

    public void removeFriend(UUID friend){
        friends.remove(friend);
    }

    @Override
    public int compareTo(User o) {
        //this.signup.compareTo(o.getSignup());

        return o.getSignup().compareTo(this.getSignup());
    }
}
