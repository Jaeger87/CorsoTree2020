import binari.*;
import passeggeri.PasseggeroAffamato;
import passeggeri.PasseggeroAssonnato;
import passeggeri.PasseggeroSemplice;
import treni.FrecciaRossa;
import treni.Regionale;
import vagoni.VagoneLetto;
import vagoni.VagonePasseggero;
import vagoni.VagoneRistorante;

public class TestFerrovia {

    public static void main(String[] args) {

        FrecciaRossa frecciaRossa = new FrecciaRossa(8898, 50);

        frecciaRossa.addVagone(new VagonePasseggero(1, 10));
        frecciaRossa.addVagone(new VagoneRistorante(2, 10));
        frecciaRossa.addVagone(new VagoneRistorante(3, 10));
        frecciaRossa.addVagone(new VagoneLetto(4, 10));
        frecciaRossa.addVagone(new VagoneLetto(5, 10));


        frecciaRossa.addPasseggero(new PasseggeroSemplice("Mario", "AB123", 1, 15));
        frecciaRossa.addPasseggero(new PasseggeroSemplice("Lucia", "AB124", 1, 35));

        frecciaRossa.addPasseggero(new PasseggeroAffamato("Giulia", "AB125", 2, 35));
        frecciaRossa.addPasseggero(new PasseggeroAffamato("Federica", "AB126", 2, 15));

        frecciaRossa.addPasseggero(new PasseggeroAssonnato("Martina", "AB127", 4, 35));
        frecciaRossa.addPasseggero(new PasseggeroAssonnato("Genny", "AB128", 4, 35));


        Regionale regionale = new Regionale(2356, 20);
        regionale.addVagone(new VagonePasseggero(1, 10));
        regionale.addVagone(new VagonePasseggero(2, 10));

        regionale.addPasseggero(new PasseggeroSemplice("Mario", "AB1232", 1, 15));
        regionale.addPasseggero(new PasseggeroSemplice("Lucia", "AB1254", 1, 35));
        regionale.addPasseggero(new PasseggeroSemplice("Martina", "AB12123", 2, 15));
        regionale.addPasseggero(new PasseggeroSemplice("Federica", "AB1243", 2, 35));


        Binario binarioFreccia =
            new BinarioSemplice(
                new BinarioSemplice(
                        new BinarioScambio(
                                new BinarioCapolinea(3),
                                new BinarioSemaforo(2000,
                                        new BinarioStazione(15,
                                                new BinarioSemplice(
                                                        new BinarioCapolinea(35)
                                                )
                                        )
                                )
                        )
                )
            );

        Binario binarioRegionale = new BinarioSemplice(
                new BinarioSemplice(
                        new BinarioScambio(
                                new BinarioCapolinea(3),
                                new BinarioSemaforo(2000,
                                        new BinarioStazione(15,
                                                new BinarioSemplice(
                                                        new BinarioCapolinea(35)
                                                )
                                        )
                                )
                        )
                )
        );

        while (binarioFreccia != null || binarioRegionale != null){

            if (binarioFreccia != null){
                if (binarioFreccia instanceof BinarioScambio)
                    ((BinarioScambio)binarioFreccia).scambia();

                binarioFreccia = binarioFreccia.percorri(frecciaRossa);
            }

            if (binarioRegionale != null){
                if (binarioRegionale instanceof BinarioScambio)
                    ((BinarioScambio)binarioRegionale).scambia();

                binarioRegionale = binarioRegionale.percorri(regionale);
            }

        }



    }

}
