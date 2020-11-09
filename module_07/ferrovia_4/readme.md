## Ferrovia 4  🏍

Estendere l'esercizio ferrovia implementando i binari

Un binario si costruisce a partire dal binario successivo e deve implementare i metodi
* getSuccessivo() che restituisce il binario successivo
* percorri(Treno t) che fa percorrere il binario al treno e restituisce il prossimo binario da percorrere
  
I binari possono essere di tipo

* BinarioSemplice
  * implementa il metodo percorri restituendo il prossimo binario

* BinarioStazione
  * dice al treno di trovarsi in stazione e gli fa eseguire le operazioni necessarie alla fermata in stazione e restituisce il prossimo binario da percorrere
  * ha un id stazione (int)
    * aggiungere alla classe passeggero il campo idStazioneDiArrivo e fare in modo che il passeggero scenda quando il treno arriva su un binario stazione con l'id uguale all'idStazioneDiArrivo del passeggero

* BinarioSemaforo
  * Si costruisce fornendo in aggiunta al prossimo binario anche il numero di millisecondi che indica la durata del semaforo rosso
  * il metodo percorri restituisce il prossimo binario se il treno è un FrecciaRossa oppure se il semaforo è verde
  * Il semaforo diventa verde dopo che il treno è rimasto al binario per una durata almeno pari alla durata del semaforo rosso
  * Se il semaforo è rosso il metodo percorri restituisce il binario attuale facendo rimanere fermo il treno

* BinarioScambio
  * Si costruisce con due binari invece di uno, il primo dei due binari è il prossimo binario, mentre il secondo deve rimanere memorizzato come binario alternativo
  * ha un metodo scambia() che scambia il prossimo binario con quello alternativo

* BinarioCapolinea
  * è una estensione del binario stazione
  * non ha un prossimo binario
  * deve avvertire il treno che è arrivato al capolinea e non deve permettere di andare avanti

