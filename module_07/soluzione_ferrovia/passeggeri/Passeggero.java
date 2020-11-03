package passeggeri;

public abstract class Passeggero {
    private String nome;
    private String codiceBiglietto;
    private int idVagone;
    private int idStazioneArrivo;

    protected Passeggero(String nome, String codiceBiglietto, int idVagone, int idStazioneArrivo) {
        this.nome = nome;
        this.codiceBiglietto = codiceBiglietto;
        this.idVagone = idVagone;
        this.idStazioneArrivo = idStazioneArrivo;
    }

    public int getIdStazioneArrivo() {
        return idStazioneArrivo;
    }

    public int getIdVagone() {
        return idVagone;
    }

}
