package treni;

public class FrecciaRossa extends Treno {

    private static final int MAX_VAGONI = 20;

    public FrecciaRossa(int codice, int maxPasseggeri) {
        super(codice, MAX_VAGONI, maxPasseggeri);
    }

    @Override
    public void entraInStazione() {
        super.entraInStazione();
        apriPorte();
    }
}
