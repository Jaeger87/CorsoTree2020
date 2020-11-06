package questionario;

public class Domanda {
    private String testoDomanda;
    private String[] risposte;
    private int indiceRispostaEsatta;

    public Domanda(String testoDomanda, int indiceRispostaEsatta, String... risposte)
    {
        this.testoDomanda = testoDomanda;
        this.indiceRispostaEsatta = indiceRispostaEsatta;
        this.risposte = risposte;
    }

    public String getTestoDomanda() {
        return testoDomanda;
    }

    public String[] getRisposte() {
        return risposte;
    }

    public boolean rispostaEsatta(String risposta)
    {
        int indexRisposta = -1;
        for (int i = 0; i < risposte.length; i++) {
            if(risposte[i].equals(risposta))
                indexRisposta = i;
        }
        return indexRisposta == indiceRispostaEsatta;
    }

}
