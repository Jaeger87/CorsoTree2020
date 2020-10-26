import java.util.Arrays;

public class TestRiparazioni {

    public static void main(String[] args) {
        DittaRiparazioni ditta = new DittaRiparazioni();

        Tecnico t1 = new Tecnico("Luca");
        Tecnico t2 = new Tecnico("Mario");

        ditta.aggiungiTecnico(t1);
        ditta.aggiungiTecnico(t2);

        Riparazione r1 = new Riparazione("via roma", 3);
        Riparazione r2 = new Riparazione("via milano", 1);

        ditta.aggiungiRiparazione(r1);
        ditta.aggiungiRiparazione(r2);

        System.out.println(Arrays.toString(ditta.riparazioniInAttesa()));
        System.out.println(ditta.getRiparazioneMaxPriorita().getIndirizzo());

        ditta.assegnaProssimaRiparazione();
        ditta.setRiparazioneTerminata("Mario");
        System.out.println(Arrays.toString(ditta.riparazioniInAttesa()));


        System.out.println(Arrays.toString(ditta.getTecnici()));
        ditta.mandaTecniciInFerie(new String[]{"Luca"});
        System.out.println(Arrays.toString(ditta.getTecnici()));



    }

}
