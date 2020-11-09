package botspesa;

import java.util.ArrayList;
import java.util.List;

public class ListaDellaSpesa {
    private long userID;
    private StatoUtente statoUtente;
    private List<ItemSpesa> listaSpesa;

    public ListaDellaSpesa(long userID) {
        this.userID = userID;
        this.listaSpesa = new ArrayList<>();
        statoUtente = StatoUtente.NORMALE;
    }

    public boolean addItem(String cosa, int quantita){
        statoUtente = StatoUtente.NORMALE;
        return listaSpesa.add(new ItemSpesa(cosa, quantita));
    }

    public boolean addItem(String cosa){
        statoUtente = StatoUtente.NORMALE;
        return listaSpesa.add(new ItemSpesa(cosa));
    }

    public boolean removeItem(int index){

        statoUtente = StatoUtente.NORMALE;
        if(index >= listaSpesa.size() || index < 0)
            return false;
        listaSpesa.remove(index);
        return true;
    }

    @Override
    public String toString() {
        if(listaSpesa.isEmpty())
            return "Non hai nessun prodotto in lista";
        StringBuilder listString = new StringBuilder();
        for (int i = 0; i < listaSpesa.size(); i++)
        {
            listString.append(i);
            listString.append(" " + listaSpesa.get(i).getCosa());
            listString.append(" " + listaSpesa.get(i).getQuantita());
            listString.append('\n');
        }
        listString.deleteCharAt(listString.length() - 1);
        return listString.toString();
    }

    public void setStatoUtente(StatoUtente statoUtente)
    {
        this.statoUtente = statoUtente;
    }

    public StatoUtente getStatoUtente() {
        return statoUtente;
    }

    public long getUserID() {
        return userID;
    }
}
