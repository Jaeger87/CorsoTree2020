package vagoni;

import passeggeri.Passeggero;

import java.util.ArrayList;

public abstract class Vagone {

    private int id;
    private int capienza;
    private ArrayList<Passeggero> passeggeri;
    private ArrayList<Porta> porte;

    public Vagone(int id, int capienza) {
        this.id = id;
        this.capienza = capienza;
        this.passeggeri = new ArrayList<>();

        this.porte = new ArrayList<>();
        porte.add(new Porta());
        porte.add(new Porta());
        porte.add(new Porta());
        porte.add(new Porta());
    }

    public int getId() {
        return id;
    }

    public int getCapienza() {
        return capienza;
    }

    public ArrayList<Passeggero> getPasseggeri() {
        return passeggeri;
    }

    public boolean addPasseggero(Passeggero p){
        if (passeggeri.size() == capienza)
            return false;

        passeggeri.add(p);
        return true;
    }


    public boolean removePasseggero(Passeggero p){
        return passeggeri.remove(p);
    }

    public void apriPorte(){
        for (Porta p : porte)
            p.setStato(StatoPorta.APERTA);
    }

    public void chiudiPorte(){
        for (Porta p : porte)
            p.setStato(StatoPorta.CHIUSA);
    }

    public void faiScendere(int idStazione){
       passeggeri.removeAll(getPasseggeriByStazione(idStazione));
    }

    private ArrayList<Passeggero> getPasseggeriByStazione(int idStazione){
        ArrayList<Passeggero> passeggeriByStazione = new ArrayList<>();
        for (Passeggero p : passeggeri)
            if (p.getIdStazioneArrivo() == idStazione)
                passeggeriByStazione.add(p);

        return passeggeriByStazione;
    }

    public void faiScendere(){
        passeggeri = new ArrayList<>();
    }


    private class Porta{
        private StatoPorta stato;

        public Porta() {
            this.stato = StatoPorta.CHIUSA;
        }

        public StatoPorta getStato() {
            return stato;
        }

        public void setStato(StatoPorta stato) {
            if (stato != StatoPorta.GUASTA)
                this.stato = stato;
        }
    }


    private enum StatoPorta {
        APERTA, CHIUSA, GUASTA
    }


}
