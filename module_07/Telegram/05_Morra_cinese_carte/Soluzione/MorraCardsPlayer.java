package cartamorra;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class MorraCardsPlayer {

    private List<MorraCinese> playerCards;
    private int score;
    public static Random random = new Random();

    public MorraCardsPlayer() {
        playerCards = new ArrayList<>();
        score = 0;
    }

    public void getHand(List<MorraCinese> playerCards) {
        this.playerCards = playerCards;
    }

    public int getScore() {
        return score;
    }

    public boolean addScore() {
        score++;
        return score >= 3;
    }

    public List<MorraCinese> getPlayerCards() {
        return playerCards;
    }

}
