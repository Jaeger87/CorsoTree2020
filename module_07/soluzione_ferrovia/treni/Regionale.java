package treni;

import vagoni.Vagone;
import vagoni.VagonePasseggero;

public class Regionale extends Treno {

    private static final int MAX_VAGONI = 15;

    public Regionale(int codice, int maxPasseggeri) {
        super(codice, MAX_VAGONI, maxPasseggeri);
    }

    @Override
    public boolean addVagone(Vagone v) {
        if (v instanceof VagonePasseggero)
            return super.addVagone(v);

        return false;
    }
}
