package cartamorra;

public class MorraCardsCPUPlayer extends MorraCardsPlayer{

    public MorraCinese giocaCarta()
    {
        return super.getPlayerCards().remove(super.random.nextInt(super.getPlayerCards().size()));
    }
}
