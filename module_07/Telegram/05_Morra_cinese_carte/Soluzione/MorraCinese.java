package cartamorra;

public enum MorraCinese {
    SASSO(0, "\uD83D\uDC4A\uD83C\uDFFB"), CARTA(1,"\uD83D\uDD90\uD83C\uDFFB"), FORBICE(2, "✌\uD83C\uDFFB");

    private final int value;
    private String emoji;

    private MorraCinese(int value, String emoji) {
        this.value = value;
        this.emoji = emoji;
    }

    public int getValue() {
        return value;
    }


    @Override
    public String toString() {
        return emoji;
    }

    public static MorraCinese fromString(String text) {
        if (text != null) {
            for (MorraCinese m : MorraCinese.values()) {
                if (text.equals(m.emoji)) {
                    return m;
                }
            }
        }
        return null;
    }
}
