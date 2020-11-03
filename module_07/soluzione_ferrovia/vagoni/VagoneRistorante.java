package vagoni;

import passeggeri.Passeggero;
import passeggeri.PasseggeroAffamato;

import java.util.ArrayList;
import java.util.Random;

public class VagoneRistorante extends Vagone {

    private ArrayList<Tavolo> tavoli;

    public VagoneRistorante(int id, int capienza) {
        super(id, capienza);

        tavoli = new ArrayList<>();

        int totalePosti = 0;
        while (totalePosti < capienza){
            int capienzaTavolo = new Random().nextInt(8)+1;

            tavoli.add(new Tavolo(capienzaTavolo));

            totalePosti += capienzaTavolo;
        }

    }

    @Override
    public boolean removePasseggero(Passeggero p) {
        if (super.removePasseggero(p))
        {
            rimuoviUnoDaUnTavolo();
            return true;
        }

        return false;
    }

    private void rimuoviUnoDaUnTavolo(){
        for (Tavolo t : tavoli)
            if (t.removeUnPasseggeroDalTavolo())
                break;
    }

    @Override
    public boolean addPasseggero(Passeggero p) {
        if (p instanceof PasseggeroAffamato)
            if (!super.addPasseggero(p))
                return false;
            else
                for (Tavolo t : tavoli)
                    if (t.addUnPasseggeroAlTavolo())
                        break;

        return false;
    }


    private class Tavolo{

        private int capienza;
        private int passeggeriAlTavolo;

        public Tavolo(int capienza) {
            this.capienza = capienza;
            passeggeriAlTavolo = 0;
        }

        private boolean addUnPasseggeroAlTavolo(){
            if (passeggeriAlTavolo+1 > capienza)
                return false;

            passeggeriAlTavolo++;
            return true;
        }

        public boolean removeUnPasseggeroDalTavolo() {
            if (passeggeriAlTavolo == 0)
                return false;

            passeggeriAlTavolo--;
            return true;
        }
    }
}
