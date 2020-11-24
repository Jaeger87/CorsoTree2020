
import java.util.Objects;
import java.util.UUID;

public class VideoGame {
    private UUID uuid;
    private String name;
    private VideoGameDifficulty difficulty;

    public VideoGame(UUID uuid, String name, VideoGameDifficulty difficulty) {
        this.uuid = uuid;
        this.name = name;
        this.difficulty = difficulty;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public VideoGameDifficulty getDifficulty() {
        return difficulty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VideoGame videoGame = (VideoGame) o;
        return Objects.equals(uuid, videoGame.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid);
    }
}
