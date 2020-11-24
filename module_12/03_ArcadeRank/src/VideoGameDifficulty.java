
public enum VideoGameDifficulty {
    super_easy(1), easy(2), medium(3), expert(4), veteran(5);

    private int value;

    VideoGameDifficulty(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
