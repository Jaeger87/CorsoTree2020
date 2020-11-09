package cartamorra;

import java.util.List;

public class MorraCardsHumanPlayer extends MorraCardsPlayer{

    public MorraCardsHumanPlayer() {
        super();
    }

    public boolean removeCard(int index, MorraCinese mossa)
    {
        List<MorraCinese> cards = super.getPlayerCards();

        if(cards.get(index) == mossa)
        {
            cards.remove(index);
            return true;
        }
        return false;
    }


}
