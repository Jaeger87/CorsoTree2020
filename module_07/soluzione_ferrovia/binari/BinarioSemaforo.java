package binari;

import treni.FrecciaRossa;
import treni.Treno;

public class BinarioSemaforo extends Binario {

    private int durata;
    private Long trenoInAttesa;


    public BinarioSemaforo(int durata, Binario successivo) {
        super(successivo);
        this.durata = durata;
    }

    @Override
    public Binario percorri(Treno t) {
        if (t instanceof FrecciaRossa)
            return super.percorri(t);

        if (trenoInAttesa == null)
            trenoInAttesa = System.currentTimeMillis();

        if (System.currentTimeMillis() > trenoInAttesa+durata){
            trenoInAttesa = null;
            return super.percorri(t);
        }

        return this;
    }
}
