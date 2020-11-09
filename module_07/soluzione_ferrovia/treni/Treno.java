package treni;

import passeggeri.Passeggero;
import vagoni.Vagone;

import java.util.ArrayList;

public abstract class Treno {

    private int codice;
    private int velocitaAttuale;
    private int maxVagoni;
    private int maxPasseggeri;
    private ArrayList<Vagone> vagoni;
    private boolean inStazione;

    protected Treno(int codice, int maxVagoni, int maxPasseggeri) {
        this.codice = codice;
        this.velocitaAttuale = 0;
        this.maxVagoni = maxVagoni;
        this.maxPasseggeri = maxPasseggeri;
        vagoni = new ArrayList<>();
        inStazione = true;
    }

    public void parti(){
        velocitaAttuale = 100;
        inStazione = false;
    }

    public void ferma(){
        velocitaAttuale = 0;
    }

    public void entraInStazione(){
        ferma();
        inStazione = true;
    }

    public void entraInStazione(int idStazione){
        entraInStazione();

        for (Vagone v : vagoni)
            v.faiScendere(idStazione);
    }


    public boolean addVagone(Vagone v){
        if (vagoni.size() == maxVagoni || !inStazione)
            return false;

        vagoni.add(v);
        return true;
    }

    public boolean removeVagone(Vagone v){
        if (vagoni.isEmpty() || !inStazione)
            return false;

        vagoni.remove(v);
        return true;
    }

    public boolean removeVagone(int v){
        if (vagoni.isEmpty() || !inStazione)
            return false;

        vagoni.remove(v);
        return true;
    }

    public boolean addPasseggero(Passeggero p){
        Vagone vagone = getVagoneByID(p.getIdVagone());

        if (vagone == null)
            return false;

        return vagone.addPasseggero(p);
    }

    private Vagone getVagoneByID(int idVagone){
        for (Vagone v : vagoni)
            if (v.getId() == idVagone)
                return v;

        return null;
    }

    public boolean removePasseggero(Passeggero p){
        Vagone vagone = getVagoneByID(p.getIdVagone());

        if (vagone == null)
            return false;

        return vagone.removePasseggero(p);
    }

    public boolean apriPorte(){

        if (!inStazione)
            return false;

        for (Vagone v : vagoni)
            v.apriPorte();

        return true;
    }


    public boolean chiudiPorte(){

        if (!inStazione)
            return false;

        for (Vagone v : vagoni)
            v.chiudiPorte();

        return true;
    }


    public void arrivatoAlCapolinea(){
        for (Vagone v : vagoni)
            v.faiScendere();

    }
}
