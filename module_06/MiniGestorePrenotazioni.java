package module_06;

public class MiniGestorePrenotazioni {

    Prenotazione[] prenotazioniEsterno;
    Prenotazione[] prenotazioniInterno;
    int nPostiEsterno, nPostiInterno;

    public MiniGestorePrenotazioni(int nPostiEsterno, int nPostiInterno) {
        this.prenotazioniEsterno = new Prenotazione[nPostiEsterno];
        this.prenotazioniInterno = new Prenotazione[nPostiInterno];
        this.nPostiEsterno = nPostiEsterno;
        this.nPostiInterno = nPostiInterno;
    }

    public boolean prenota(Prenotazione p) {
        boolean prenotazioneInserita;
        if (p instanceof PrenotazioneSingola) {
            PrenotazioneSingola prenotazioneSingola = (PrenotazioneSingola) p;
            if (prenotazioneSingola.getPreferenza() == Preferenza.INTERNO) {
                prenotazioneInserita = inserisciPrenotazioneInterno(p);
                if(!prenotazioneInserita)
                    prenotazioneInserita = inserisciPrenotazioneEsterno(p);
            }
            else {
                prenotazioneInserita = inserisciPrenotazioneEsterno(p);
                if(!prenotazioneInserita)
                    prenotazioneInserita = inserisciPrenotazioneInterno(p);
            }
            return prenotazioneInserita;
        }
        else {
            prenotazioneInserita = inserisciPrenotazioneInterno(p);
            if(!prenotazioneInserita)
                prenotazioneInserita = inserisciPrenotazioneEsterno(p);
            return prenotazioneInserita;
        }

    }

    private boolean inserisciPrenotazioneInterno(Prenotazione p) {
        int prenotazioniInternoAttuali = postiOccupati(prenotazioniInterno);
        if (prenotazioniInternoAttuali < nPostiInterno) {
            for (int i = 0; i < prenotazioniInterno.length; i++)
                if (prenotazioniInterno[i] == null) {
                    prenotazioniInterno[i] = p;
                    return true;
                }
            return  false;
        }
        return false;
    }

    private boolean inserisciPrenotazioneEsterno(Prenotazione p) {
        int prenotazioniEsternoAttuali = postiOccupati(prenotazioniEsterno);
        if (prenotazioniEsternoAttuali < nPostiEsterno) {
            for (int i = 0; i < prenotazioniEsterno.length; i++)
                if (prenotazioniEsterno[i] == null) {
                    prenotazioniEsterno[i] = p;
                    return true;
                }
            return  false;
        }
        return false;
    }

    private int postiOccupati(Prenotazione[] prenotazioni) {
        int prenotazioniAttuali = 0;
        for(int i=0; i<prenotazioni.length; i++) {
            if(prenotazioni[i] != null)
                prenotazioniAttuali += prenotazioni[i].getnPosti();
        }
        return prenotazioniAttuali;
    }

    public boolean terminaPrenotazione(Prenotazione prenotazione) {
        boolean prenotazioneTrovata = false;
        for (int i = 0; i < prenotazioniInterno.length; i++)
            if (prenotazioniInterno[i].getCode().equals(prenotazione.getCode())) {
                prenotazioniInterno[i] = null;
                return true;
        }
        for (int i = 0; i < prenotazioniEsterno.length; i++)
            if (prenotazioniEsterno[i].getCode().equals(prenotazione.getCode())) {
                prenotazioniEsterno[i] = null;
                return true;
        }
        return false;
    }

    public Prenotazione[] prenotazioniAttualiInterno() {
        return prenotazioniInterno;
    }

    public Prenotazione[] prenotazioniAttualiEsterno() {
        return prenotazioniEsterno;
    }

    public static void main(String[] args) {
        MiniGestorePrenotazioni miniGestorePrenotazioni =
                new MiniGestorePrenotazioni(3, 5);
        Prenotazione p1 = new PrenotazioneSingola("12", Preferenza.ESTERNO);
        Prenotazione p2 = new PrenotazioneSingola("23", Preferenza.ESTERNO);
        Prenotazione p3 = new PrenotazioneSingola("34", Preferenza.INTERNO);
        Prenotazione p4 = new PrenotazioneSingola("56", Preferenza.ESTERNO);
        miniGestorePrenotazioni.prenota(p1);
        miniGestorePrenotazioni.prenota(p2);
        miniGestorePrenotazioni.prenota(p3);
        miniGestorePrenotazioni.prenota(p4);

        Prenotazione[] prenotazioniInternoArray = miniGestorePrenotazioni.prenotazioniAttualiInterno();
        Prenotazione[] prenotazioniEsternoArray = miniGestorePrenotazioni.prenotazioniAttualiEsterno();
        int prenotazioniInterno = 0, prenotazioniEsterno = 0;
        //contiamo e togliamo i null se presenti
        for (int i = 0; i < prenotazioniInternoArray.length; i++)
            if (prenotazioniInternoArray[i] != null) {
                prenotazioniInterno++;
            }
        for (int i = 0; i < prenotazioniEsternoArray.length; i++)
            if (prenotazioniEsternoArray[i] != null) {
                prenotazioniEsterno++;
            }
        System.out.println(prenotazioniInterno == 1);
        System.out.println(prenotazioniEsterno == 3);
        Prenotazione p5 = new PrenotazioneGruppo("45", 2);
        boolean a  = miniGestorePrenotazioni.prenota(p5);
        prenotazioniInterno = 0;
        prenotazioniEsterno = 0;
        //contiamo e togliamo i null se presenti
        for (int i = 0; i < prenotazioniInternoArray.length; i++)
            if (prenotazioniInternoArray[i] != null) {
                prenotazioniInterno++;
            }
        for (int i = 0; i < prenotazioniEsternoArray.length; i++)
            if (prenotazioniEsternoArray[i] != null) {
                prenotazioniEsterno++;
            }
        System.out.println(prenotazioniInterno + prenotazioniEsterno == 5);
        //verifichiamo i posti effettivamente riservati
        int postiTotali = 0;
        for (int i = 0; i < prenotazioniInternoArray.length; i++)
            if (prenotazioniInternoArray[i] != null) {
                postiTotali += prenotazioniInternoArray[i].getnPosti();
            }
        for (int i = 0; i < prenotazioniEsternoArray.length; i++)
            if (prenotazioniEsternoArray[i] != null) {
                postiTotali += prenotazioniEsternoArray[i].getnPosti();
        }
        System.out.println(postiTotali == 6);
        Prenotazione p6 = new PrenotazioneSingola("67", Preferenza.ESTERNO);
        boolean inserita = miniGestorePrenotazioni.prenota(p6);
        System.out.println(inserita);
    }

}

class Prenotazione {
    private String code;
    private int nPosti;

    public Prenotazione(String code, int nPosti) {
        this.code = code;
        this.nPosti = nPosti;
    }

    public String getCode() {
        return code;
    }

    public int getnPosti() {
        return nPosti;
    }

}

class PrenotazioneSingola extends Prenotazione {

    private Preferenza preferenza;
    public PrenotazioneSingola(String code, Preferenza preferenza) {
        super(code, 1);
        this.preferenza = preferenza;
    }

    public Preferenza getPreferenza() {
        return preferenza;
    }
}

class PrenotazioneGruppo extends Prenotazione {

    public PrenotazioneGruppo(String code, int nPosti) {
        super(code, nPosti);
    }

}

enum Preferenza {
    INTERNO, ESTERNO
}
