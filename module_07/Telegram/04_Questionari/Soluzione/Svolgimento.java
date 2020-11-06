package questionario;

import com.botticelli.bot.request.methods.MessageToSend;

public class Svolgimento {

    private Questionario questionario;
    private int score;
    private int indiceDomandaCorrente;


    public Svolgimento(Questionario questionario) {
        this.questionario = questionario;
        score = 0;
        indiceDomandaCorrente = 0;
    }

    public int getScore()
    {
        return score;
    }

    public boolean isPerfectScore()
    {
        return score == questionario.howManyQuestion();
    }

    public Domanda getDomandaAttuale()
    {
        Domanda attuale = questionario.getDomanda(indiceDomandaCorrente);
        return attuale;
    }

    public boolean checkRisposta(String answer)
    {
        Domanda attuale = getDomandaAttuale();
        boolean ok = attuale.rispostaEsatta(answer);
        if(ok)
            score++;
        indiceDomandaCorrente++;
        return ok;
    }
}
