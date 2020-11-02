## Ferrovia 3 🛵

Estendere l'esercizio precedente aggiungendo i passeggeri

Un passeggero ha
* nome
* codice biglietto
* idVagone - l'id del vagone nel quale deve sedersi

Modificare la classe vagone
* aggiungere un id vagone
* aggingere una lista di passeggeri
* Deve verificare che un passeggero con idVagone=2 stia salendo sul vagone con id 2, altrimenti non lo fa salire

Un passeggero può essere
* PasseggeroSemplice
  * sale e scende dai vagoni passeggero

* PasseggeroAffamato
  * può salire sia sui vagoni passeggero che sui vagoni ristorante

* PasseggeroAssonnato
  * può salire sui vagoni passeggero e sui vagoni letto

Modificare VagoneRistorante in modo che possano salire solo passeggeri affamati
Modificare VagoneLetto in modo che possano salire solo passeggeri assonati
