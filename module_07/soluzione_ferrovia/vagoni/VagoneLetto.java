package vagoni;

import passeggeri.Passeggero;
import passeggeri.PasseggeroAssonnato;

public class VagoneLetto extends Vagone{

    public VagoneLetto(int id, int capienza) {
        super(id, capienza);
    }

    @Override
    public boolean addPasseggero(Passeggero p) {
        if (p instanceof PasseggeroAssonnato)
            return super.addPasseggero(p);

        return false;
    }
}
