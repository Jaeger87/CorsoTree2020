import java.util.*;

public class Post {

    private UUID id;
    private UUID author;
    private String text;
    private Set<UUID> likes;
    private Map<UUID, List<Comment>> comments;

    public Post(UUID author, String text) {
        id = UUID.randomUUID();
        this.author = author;
        this.text = text;
        likes = new HashSet<>();
        comments = new HashMap<>();
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

    public Set<UUID> getLikes() {
        return likes;
    }

    public Map<UUID, List<Comment>> getComments() {
        return comments;
    }

    public void addLike(UUID like){
        likes.add(like);
    }

    public void addComment(UUID author, String text){
        List<Comment> user_comments = comments.getOrDefault(author, new ArrayList<>());
        user_comments.add(new Comment(author, text));
        comments.put(author, user_comments);
    }


}
