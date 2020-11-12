## Share2Go 🛵/🏍


Progettare un sistema di gestione di un'app di carsharing


Sull'app è possibile 
* registrare un utente
* prenotare automobili o furgoni
* lasciare l'automobile sia parcheggiata in strada che all'interno di un parcheggio convenzionato Share2Go

Un utente deve mantenere come dati: email, credito in euro (non possono esistere più utenti con la stessa email)

Una vettura è identificata dalla sua targa e deve mantenere le informazioni relative ai posti disponibili, al livello di carburante attuale e al prezzo al minuto del noleggio

Una vettura può essere noleggiata solo se l'utente non ha un altro noleggio in corso e se la vettura è disponibile (quindi non è già noleggiata da un altro utente)

Un parcheggio convenzionato ha un massimo di posti disponibili, quindi posso lasciare la macchina al parcheggio solo se il parcheggio non è pieno

Implementare le seguenti funzioni
* Permettere ad un utente di noleggiare una vettura
* Dato un utente, ottenere lo storico dei noleggi effettuati
* Stampare su console per ogni vettura il suo stato
  * Noleggio in corso, se l'auto è noleggiata al momento
  * La sua posizione, se è parcheggiata
* Dati un utente ed una vettura, per quanti minuti l'utente può noleggiare la vettura, in base al prezzo del noleggio e al credito dell'utente




