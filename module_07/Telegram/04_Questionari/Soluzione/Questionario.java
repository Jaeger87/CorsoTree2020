package questionario;

import java.util.ArrayList;
import java.util.List;

public class Questionario {
    private String nome;
    private List<Domanda> domande;


    public Questionario(String nome) {
        this.nome = nome;
        domande = new ArrayList<>();
    }

    public boolean addDomanda(Domanda domanda)
    {
        return domande.add(domanda);
    }

    public String getNome() {
        return nome;
    }

    public Domanda getDomanda(int index)
    {
        if (index < 0 || index >= domande.size())
            return null;
        return domande.get(index);
    }

    public int howManyQuestion()
    {
        return domande.size();
    }


}
