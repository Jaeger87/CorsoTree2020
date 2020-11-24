import java.util.Map;
import java.util.stream.Collectors;

public class GlobalChart {
    private Map<User, Integer> scores;

    public GlobalChart(Map<User, Integer> scores) {
        this.scores = scores;
    }

    public Map<User, Integer> getScores() {
        return scores;
    }

    @Override
    public String toString() {
        return "GlobalChart scores:\n" + scores.entrySet()
                .stream()
                .map((k) -> k.getKey().getUsername() + ": " +k.getValue())
                .collect(Collectors.joining("\n"));
    }

}
