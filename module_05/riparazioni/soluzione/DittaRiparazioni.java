public class DittaRiparazioni {

    private Tecnico[] tecnici;
    private int numTecnici;

    private Riparazione[] riparazioni;
    private int numRiparazioni;


    public DittaRiparazioni(){
        tecnici = new Tecnico[10];
        riparazioni = new Riparazione[10];
        numTecnici = 0;
        numRiparazioni = 0;
    }

    public Tecnico[] getTecnici(){
        return tecnici;
    }

    public boolean aggiungiRiparazione(Riparazione r){
        if (esisteRiparazioneDatoIndirizzo(r.getIndirizzo()))
            return false;

        riparazioni[numRiparazioni] = r;
        numRiparazioni++;
        return true;
    }


    private boolean esisteRiparazioneDatoIndirizzo(String indirizzo){
        for (int i = 0; i < numRiparazioni; i++) {
            if (riparazioni[i].getIndirizzo().equals(indirizzo))
                return true;
        }

        return false;
    }


    public boolean aggiungiTecnico(Tecnico t){
        if (esisteTecnicoDatoNome(t.getNome()))
            return false;

        if (numTecnici == tecnici.length-1)
            return false;

        tecnici[numTecnici] = t;
        numTecnici++;
        return true;
    }


    private boolean esisteTecnicoDatoNome(String nome){
        for (int i = 0; i < numTecnici; i++) {
            if (tecnici[i] == null)
                break;

            if (tecnici[i].getNome().equals(nome))
                return true;
        }

        return false;
    }



    public Riparazione[] riparazioniInAttesa(){
        Riparazione[] inAttesa = new Riparazione[riparazioni.length];
        int countInAttesa = 0;

        for (int i = 0; i < numRiparazioni; i++) {
            if (riparazioni[i].getStato().equals(StatoRiparazione.inAttesa))
            {
                inAttesa[countInAttesa] = riparazioni[i];
                countInAttesa++;
            }
        }

        return inAttesa;
    }


    public Riparazione getRiparazioneMaxPriorita(){
        Riparazione risultato = null;

        for (int i = 0; i < numRiparazioni; i++) {

            if (riparazioni[i].getStato().equals(StatoRiparazione.inAttesa))
            {
                if (risultato == null)
                    risultato = riparazioni[i];
                else if (riparazioni[i].getPriorita() > risultato.getPriorita())
                    risultato = riparazioni[i];
            }
        }

        return risultato;
    }



    public boolean assegnaProssimaRiparazione(){
        Tecnico tecnicoLibero = null;
        for (int i = 0; i < numTecnici; i++) {
            if (tecnici[i].getStato().equals(StatoTecnico.DISPONIBILE))
            {
                tecnicoLibero = tecnici[i];
                break;
            }
        }

        if (tecnicoLibero == null)
            return false;

        Riparazione maxPriorita = getRiparazioneMaxPriorita();

        maxPriorita.setStato(StatoRiparazione.inCorso);
        tecnicoLibero.setRiparazione(maxPriorita);

        return true;
    }


    public boolean setRiparazioneTerminata(String nomeTecnico) {
        Tecnico tecnico = cercaTecnicoPerNome(nomeTecnico);

        if (tecnico == null){
            System.out.println("nome tecnico non trovato");
            return false;
        }

        if (tecnico.getRiparazione() == null)
        {
            System.out.println("il tecnico specificato non ha una riparazione in corso");
            return false;
        }

        tecnico.getRiparazione().setStato(StatoRiparazione.terminata);
        tecnico.setRiparazione(null);

        return true;
    }

    private Tecnico cercaTecnicoPerNome(String nomeTecnico) {
        for (int i = 0; i < numTecnici; i++) {
            if (tecnici[i].getNome().equals(nomeTecnico))
                return tecnici[i];
        }

        return null;
    }

    public void mandaTecniciInFerie(String[] tecniciInFerie){

        for (int i = 0; i < numTecnici; i++) {

            for (String tecnicoInFerie : tecniciInFerie) {

                if (tecnici[i].getNome().equals(tecnicoInFerie))
                    tecnici[i].mettiInFerie();

            }

        }

    }


}
