## Ferrovia 2 🛵

Estendere l'esercizio precedente aggiungendo i vagoni


Un treno
* ha una lista di vagoni
* può aggiungere e rimuovere vagoni se si trova in stazione e se il vagone da rimuovere è vuoto
* può far salire o scendere un passeggero in un determinato vagone se si trova in stazione 

Un treno regionale può avere solo vagoni di tipo Passeggero
Un FrecciaRossa può avere vagoni di qualsiasi tipo


I vagoni hanno le seguenti caratteristiche
* capienza massima
* numero di passeggeri a bordo
* Lista di porte
  * ogni porta mantiene lo stato della porta (aperta, chiusa o guasta)
  * deve poter cambiare stato in chiusa o aperta, a meno che non sia guasta


Un vagone deve poter
* azionare le porte
* far salire o scendere un passeggero

I vagoni sono di tipo
* VagonePasseggero
  * può far salire i passeggeri fino alla capienza totale del vagone
  
* VagoneRistorante
  * che deve avere una lista di tavoli (mantenere la coerenza con la capienza del vagone)
    * ogni tavolo ha una capienza e un numero di persone al tavolo
  
* VagoneLetto
  * deve sapere quanti letti ci sono (letti da 1 persona)