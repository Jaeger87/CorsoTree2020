Esercizio Mini Gestore prenotazioni 🛵

Scrivere un programma in grado di modellare la gestione delle prenotazioni di un ristorante. Il ristorante può ricevere 2 tipi di prenotazione: singola o di gruppo.
Progettare la classe GestorePrenotazioni costruito con due interi m e n che determinano rispettivamente il numero di posti disponibili all’interno e all’esterno nel ristorante.
Ad ogni Prenotazione sono associati un codice univoco. Una prenotazione singola può anche esprimere una preferenza tra interno ed esterno, La prenotazione di gruppo, invece, ha anche un attributo che specifica il numero di posti da riservare.

La classe prevede i seguenti metodi:

- prenota: data una Prenotazione p in input, se c’è posto nel ristorante viene accettata restituendo true (dando precedenza alla preferenza indicata), altrimenti viene rifiutata restituendo false
- terminaPrenotazione: data una Prenotazione p in input, termina la prenotazione eliminandola e liberando i posti associati.  
PLUS🏍: Se presenti prenotazioni singole la cui preferenza può ora essere soddisfatta in virtù dei nuovi posti liberi, modificare la prenotazione di conseguenza. Esempio: ci sono 2 posti disponibili all’esterno e 2 prenotazioni p1 e p2, entrambe da 2 persone all’esterno; nel momento in cui viene terminata la prenotazione p1, se p2 è ancora in corso, va spostata all’esterno.
- prenotazioniAttualiEsterno: ritorna un array con le attuali prenotazioni per l’esterno del ristorante
- prenotazioniAttualiInterno: ritorna un array con le attuali prenotazioni per l’interno del ristorante
  

Potete usare questo codice come test

```
MiniGestorePrenotazioni miniGestorePrenotazioni =
            new MiniGestorePrenotazioni(3, 5);
Prenotazione p1 = new PrenotazioneSingola("12", Preferenza.ESTERNO);
Prenotazione p2 = new PrenotazioneSingola("23", Preferenza.ESTERNO);
Prenotazione p3 = new PrenotazioneSingola("34", Preferenza.INTERNO);
Prenotazione p4 = new PrenotazioneSingola("56", Preferenza.ESTERNO);
miniGestorePrenotazioni.prenota(p1);
miniGestorePrenotazioni.prenota(p2);
miniGestorePrenotazioni.prenota(p3);
miniGestorePrenotazioni.prenota(p4);

Prenotazione[] prenotazioniInternoArray = miniGestorePrenotazioni.prenotazioniAttualiInterno();
Prenotazione[] prenotazioniEsternoArray = miniGestorePrenotazioni.prenotazioniAttualiEsterno();
int prenotazioniInterno = 0, prenotazioniEsterno = 0;
//contiamo e togliamo i null se presenti
for (int i = 0; i < prenotazioniInternoArray.length; i++)
    if (prenotazioniInternoArray[i] != null) {
        prenotazioniInterno++;
    }
for (int i = 0; i < prenotazioniEsternoArray.length; i++)
    if (prenotazioniEsternoArray[i] != null) {
        prenotazioniEsterno++;
    }
System.out.println(prenotazioniInterno == 1);
System.out.println(prenotazioniEsterno == 3);
Prenotazione p5 = new PrenotazioneGruppo("45", 2);
boolean a  = miniGestorePrenotazioni.prenota(p5);
prenotazioniInterno = 0;
prenotazioniEsterno = 0;
//contiamo e togliamo i null se presenti
for (int i = 0; i < prenotazioniInternoArray.length; i++)
    if (prenotazioniInternoArray[i] != null) {
        prenotazioniInterno++;
    }
for (int i = 0; i < prenotazioniEsternoArray.length; i++)
    if (prenotazioniEsternoArray[i] != null) {
        prenotazioniEsterno++;
    }
System.out.println(prenotazioniInterno + prenotazioniEsterno == 5);
//verifichiamo i posti effettivamente riservati
int postiTotali = 0;
for (int i = 0; i < prenotazioniInternoArray.length; i++)
    if (prenotazioniInternoArray[i] != null) {
        postiTotali += prenotazioniInternoArray[i].getnPosti();
    }
for (int i = 0; i < prenotazioniEsternoArray.length; i++)
    if (prenotazioniEsternoArray[i] != null) {
        postiTotali += prenotazioniEsternoArray[i].getnPosti();
}
System.out.println(postiTotali == 6);
Prenotazione p6 = new PrenotazioneSingola("67", Preferenza.ESTERNO);
boolean inserita = miniGestorePrenotazioni.prenota(p6);
System.out.println(inserita);
```

Suggerimento: usate l’ereditarietà

