
public class TestLista {

    public static void main(String[] args) {

        ListaDiInteri lista = new ListaDiInteri();

        checkListaInteri(lista);


        MiaStringa stringa = new MiaStringa();
        checkMiaStringa(stringa);

    }


    private static void checkMiaStringa(Lista stringa){
        System.out.println(stringa.size() == 0 ? "OK" : "ERRORE");

        stringa.add('a');
        System.out.println(stringa.size() == 1 ? "OK" : "ERRORE");

        System.out.println((char)stringa.get(0) == 'a' ? "OK" : "ERRORE");

        stringa.add('b');
        stringa.add('c');

        System.out.println(stringa.remove(0) ? "OK" : "ERRORE");

        System.out.println(stringa.contains('b') ? "OK" : "ERRORE");
        System.out.println(!stringa.contains('d') ? "OK" : "ERRORE");

        stringa.clear();

        System.out.println(stringa.size() == 0 ? "OK" : "ERRORE");

        System.out.println(!stringa.contains('a') ? "OK" : "ERRORE");
    }

    private static void checkListaInteri(Lista lista){
        System.out.println(lista.size() == 0 ? "OK" : "ERRORE");

        lista.add(5);
        System.out.println(lista.size() == 1 ? "OK" : "ERRORE");

        System.out.println((int)lista.get(0) == 5 ? "OK" : "ERRORE");

        lista.add(10);
        lista.add(40);

        System.out.println(lista.remove(1) ? "OK" : "ERRORE");

        System.out.println(lista.contains(40) ? "OK" : "ERRORE");
        System.out.println(!lista.contains(56) ? "OK" : "ERRORE");

        lista.clear();

        System.out.println(lista.size() == 0 ? "OK" : "ERRORE");

        System.out.println(!lista.contains(5) ? "OK" : "ERRORE");
    }

}
//get contains size add remove clear
