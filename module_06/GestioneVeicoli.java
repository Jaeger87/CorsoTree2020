package module_06;

public class GestioneVeicoli {

    public static void main(String[] args) {
        AutoMobile automobile = new AutoMobile("cf123rm", 4, 4);
        AutoCarro autoCarro = new AutoCarro("ca133sm", 4, 2);
    }

}

class Veicolo {
    private String targa;
    private int nposti;

    public Veicolo(String targa, int nposti) {
        this.targa = targa;
        this.nposti = nposti;
    }

    public String getTarga() {
        return targa;
    }

}

class AutoMobile extends Veicolo {

    private int nporte;

    public AutoMobile(String targa, int nposti, int nporte) {
        super(targa, nposti);
        this.nporte = nporte;
    }

    public int getNporte() {
        return nporte;
    }

    @Override
    public String toString() {
        return getTarga() + ": " + getNporte();
    }
}

class AutoCarro extends Veicolo {

    private int maxCapacity;

    public AutoCarro(String targa, int nposti, int maxCapacity) {
        super(targa, nposti);
        this.maxCapacity = maxCapacity;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }


    @Override
    public String toString() {
        return getTarga() + ":" + getMaxCapacity();
    }
}