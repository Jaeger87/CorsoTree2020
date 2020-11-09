package binari;

import treni.Treno;

public class BinarioStazione extends Binario {

    private int idStazione;

    public BinarioStazione(int idStazione, Binario successivo) {
        super(successivo);
        this.idStazione = idStazione;
    }

    @Override
    public Binario percorri(Treno t) {
        t.entraInStazione(idStazione);
        return super.percorri(t);
    }
}
