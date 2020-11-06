package cartamorra;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Partita {

    private long playerID;
    private List<MorraCinese> cards;
    private static Random random = new Random();
    private MorraCardsHumanPlayer humanPlayer;
    private MorraCardsCPUPlayer cpuPlayer;
    private static final int NUMEROCARTE = 60;

    private List<MorraCinese> playerCards;

    public Partita(long playerID) {
        this.playerID = playerID;
        humanPlayer = new MorraCardsHumanPlayer();
        cpuPlayer = new MorraCardsCPUPlayer();
        cards = new ArrayList<>();

        MorraCinese[] simboli = MorraCinese.values();

        for(int i = 0; i < NUMEROCARTE; i++)
            cards.add(simboli[random.nextInt(simboli.length)]);

    }

    public boolean giveCards()
    {
        if(cards.size() < 6)
            return false;
        List<MorraCinese> playerCards = new ArrayList<>();
        List<MorraCinese> CPUCards = new ArrayList<>();
        for(int i = 0; i < 3; i++)
        {
            MorraCinese cartaP = cards.remove(random.nextInt(cards.size()));
            MorraCinese cartaCPU = cards.remove(random.nextInt(cards.size()));
            playerCards.add(cartaP);
            CPUCards.add(cartaCPU);
        }

        humanPlayer.getHand(playerCards);
        cpuPlayer.getHand(CPUCards);

        return true;
    }

    public boolean controllaMano()
    {
        return humanPlayer.getPlayerCards().size() > 0;
    }

    public MorraCinese giocata(int cardIndex, MorraCinese mossa)
    {
        if (humanPlayer.removeCard(cardIndex, mossa))
            return cpuPlayer.giocaCarta();
        return null;
    }


    public long getPlayerID() {
        return playerID;
    }

    public List<MorraCinese> getHumanHand()
    {
        return humanPlayer.getPlayerCards();
    }

    public int[] getNumberRockPaperScissor()
    {
        int [] answer = new int[3];
        for(MorraCinese card : cards)
            answer[card.getValue()] += 1;
        return answer;
    }

    public enum EsitoMorra
    {
        UMANO, CPU, PAREGGIO, VITTORIAUMANO, VITTORIACPU;
    }

    public EsitoMorra checkMorra(MorraCinese umano, MorraCinese cpu)
    {
        EsitoMorra esito = checkInternoMorra(umano, cpu);
        switch (esito){
            case PAREGGIO:
                break;
            case UMANO:
                if(humanPlayer.addScore())
                    esito = EsitoMorra.VITTORIAUMANO;
                break;
            case CPU:
                if(cpuPlayer.addScore())
                    esito = EsitoMorra.VITTORIACPU;
                break;
        }
        return esito;
    }

    private static EsitoMorra checkInternoMorra(MorraCinese umano, MorraCinese cpu)
    {
        if(umano == cpu)
            return EsitoMorra.PAREGGIO;

        switch(umano){
            case CARTA:
                if(cpu == MorraCinese.FORBICE)
                    return EsitoMorra.CPU;
                else
                    return EsitoMorra.UMANO;
            case SASSO:
                if(cpu == MorraCinese.CARTA)
                    return EsitoMorra.CPU;
                else
                    return EsitoMorra.UMANO;
            case FORBICE:
                if(cpu == MorraCinese.SASSO)
                    return EsitoMorra.CPU;
                else
                    return EsitoMorra.UMANO;
        }

        return EsitoMorra.PAREGGIO;
    }

    public String getScore()
    {
        return "" + humanPlayer.getScore() + "-" + cpuPlayer.getScore();
    }


}
