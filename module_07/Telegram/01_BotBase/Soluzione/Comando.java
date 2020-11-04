package botbase;

public enum Comando {

    SALUTA("ciao"),MONOPATTINO("\uD83D\uDEF4"),SCOOTER("\uD83D\uDEF5"), MOTO("\uD83C\uDFCD"), ERRORE(""),
    TASTIERA("tastiera");


    private String str;
    /**
     * Costruttore privato che costruisce l'enum da stringa
     * @param str
     */
    private Comando(String str)
    {
        this.str=str;
    }

    @Override
    public String toString()
    {
        return str;
    }
    /**
     * Metodo per poter costruire l'enum da Stringa
     * @param text
     * @return
     *
     */
    public static Comando fromString(String text) {
        if (text != null) {
            for (Comando c : Comando.values()) {
                if (text.equals(c.str)) {
                    return c;
                }
            }
        }
        return Comando.ERRORE;
    }
}
