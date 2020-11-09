package botspesa;

public class ItemSpesa {

    private String cosa;
    private int quantita;

    public ItemSpesa(String cosa, int quantita) {
        this.cosa = cosa;
        this.quantita = quantita;
    }

    public ItemSpesa(String cosa) {
        this.cosa = cosa;
        this.quantita = 1;
    }

    public String getCosa() {
        return cosa;
    }

    public int getQuantita() {
        return quantita;
    }
}
