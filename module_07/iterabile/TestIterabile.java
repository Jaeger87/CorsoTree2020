
public class TestIterabile {


    public static void main(String[] args) {

        int[] elementi = new int[]{5, 7};
        ListaDiInteri lista = new ListaDiInteri(elementi);

        checkLista(lista);
        lista.reset();
        checkLista(lista);


        String s = "ab";
        MiaStringa miaStringa = new MiaStringa(s);

        checkStringa(miaStringa);
        miaStringa.reset();
        checkStringa(miaStringa);
    }



    private static void checkStringa(Iterabile stringa){

        if (stringa.hasNext())
            System.out.println("OK");
        else
            System.out.println("ERRORE");


        if ((char)stringa.next() == 'a')
            System.out.println("OK");
        else
            System.out.println("ERRORE");


        if ((char)stringa.next() == 'b')
            System.out.println("OK");
        else
            System.out.println("ERRORE");


        if (!stringa.hasNext())
            System.out.println("OK");
        else
            System.out.println("ERRORE");
    }


    private static void checkLista(Iterabile lista){

        if (lista.hasNext())
            System.out.println("OK");
        else
            System.out.println("ERRORE");


        if ((int)lista.next() == 5)
            System.out.println("OK");
        else
            System.out.println("ERRORE");


        if ((int)lista.next() == 7)
            System.out.println("OK");
        else
            System.out.println("ERRORE");


        if (!lista.hasNext())
            System.out.println("OK");
        else
            System.out.println("ERRORE");
    }



}
