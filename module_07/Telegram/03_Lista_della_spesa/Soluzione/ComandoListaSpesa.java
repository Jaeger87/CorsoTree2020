package botspesa;

public enum ComandoListaSpesa {
    LISTA("lista della spesa"), AGGIUNGI("aggiungi"), RIMUOVI("rimuovi"), ERRORE(""), START("/start");

    private String str;
    /**
     * Costruttore privato che costruisce l'enum da stringa
     * @param str
     */
    private ComandoListaSpesa(String str)
    {
        this.str=str;
    }

    @Override
    public String toString()
    {
        return str;
    }


    public static ComandoListaSpesa fromString(String text) {
        if (text != null) {
            for (ComandoListaSpesa c : ComandoListaSpesa.values()) {
                if (text.equals(c.str)) {
                    return c;
                }
            }
        }
        return ComandoListaSpesa.ERRORE;
    }
}
