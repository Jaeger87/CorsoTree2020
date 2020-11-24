import java.util.Map;
import java.util.stream.Collectors;

public class VideoGameChart {
    private VideoGame videoGame;
    private Map<User, Integer> scores;

    public VideoGameChart(VideoGame videoGame, Map<User, Integer> scores) {
        this.videoGame = videoGame;
        this.scores = scores;
    }

    public VideoGame getVideoGame() {
        return videoGame;
    }

    public Map<User, Integer> getScores() {
        return scores;
    }

    @Override
    public String toString() {
        return "LocalChart scores:\n" + scores.entrySet()
                .stream()
                .map((k) -> k.getKey().getUsername() + ": " +k.getValue())
                .collect(Collectors.joining("\n"));
    }

}
