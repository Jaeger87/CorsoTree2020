
public class Game {
    private VideoGame videoGame;
    private User user;
    private int score;

    public Game(VideoGame videoGame, User user, int score) {
        this.videoGame = videoGame;
        this.user = user;
        this.score = score;
    }

    public VideoGame getVideoGame() {
        return videoGame;
    }

    public User getUser() {
        return user;
    }

    public int getScore() {
        return score;
    }
}
