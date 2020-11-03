package binari;

import treni.Treno;

public class BinarioCapolinea extends BinarioStazione {

    public BinarioCapolinea(int idStazione) {
        super(idStazione, null);
    }

    @Override
    public Binario percorri(Treno t) {
        t.arrivatoAlCapolinea();
        return super.percorri(t);
    }
}
