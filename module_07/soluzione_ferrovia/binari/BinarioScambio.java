package binari;

public class BinarioScambio extends Binario {

    private Binario binarioAlternativo;

    public BinarioScambio(Binario successivo, Binario binarioAlternativo) {
        super(successivo);
        this.binarioAlternativo = binarioAlternativo;
    }

    public void scambia(){
        Binario temp = getSuccessivo();
        setSuccessivo(binarioAlternativo);
        binarioAlternativo = temp;
    }



}
