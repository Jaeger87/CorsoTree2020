public class Tecnico {

    private String nome;
    private boolean isDisponibile;
    private Riparazione riparazione;
    private StatoTecnico stato;

    public Tecnico(String nome) {
        this.nome = nome;
        stato = StatoTecnico.DISPONIBILE;
    }

    public String getNome() {
        return nome;
    }

    public boolean isDisponibile() {
        return isDisponibile;
    }

    public void setDisponibile(boolean disponibile) {
        isDisponibile = disponibile;
    }

    public Riparazione getRiparazione() {
        return riparazione;
    }

    public void setRiparazione(Riparazione riparazione) {
        this.riparazione = riparazione;

        if (riparazione == null)
            stato = StatoTecnico.DISPONIBILE;
        else
            stato = StatoTecnico.RIPARAZIONE;
    }

    public StatoTecnico getStato() {
        return stato;
    }

    public void mettiInFerie() {
        this.stato = StatoTecnico.FERIE;
    }




    @Override
    public String toString(){
        return nome+" "+stato;
    }
}
