import java.util.UUID;

public class Comment {

    private UUID id;
    private UUID author;
    private String text;

    public Comment(UUID author, String text) {
        this.id = UUID.randomUUID();
        this.author = author;
        this.text = text;
    }

    public UUID getId() {
        return id;
    }

    public UUID getAuthor() {
        return author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
