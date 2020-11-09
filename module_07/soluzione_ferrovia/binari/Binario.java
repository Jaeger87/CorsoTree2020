package binari;

import treni.Treno;

public abstract class Binario {

    private Binario successivo;

    public Binario(Binario successivo) {
        this.successivo = successivo;
    }

    protected Binario getSuccessivo(){
        return successivo;
    }

    protected void setSuccessivo(Binario successivo){
        this.successivo = successivo;
    }

    public Binario percorri(Treno t){
        System.out.println(t.getClass().getSimpleName()+" ----- " + this.getClass().getSimpleName());
        return getSuccessivo();
    }
}
