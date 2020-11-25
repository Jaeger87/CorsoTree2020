Esercizio TreeExpress 🛵

Creare un Web Service in grado di gestire un servizio di spedizione di pacchi. Ogni spedizione
 può avere 2 stati: in consegna e consegnata. Ogni utente possiede un nome, un cognome e
  un indirizzo.
  In particolare, devono essere esposte tramite API le seguenti operazioni:

- crea utente: crea un utente
- crea spedizione: crea una nuova spedizione a partire da un codice 
utente mittente, un codice utente destinatario e un peso. Inoltre, la mette in consegna. 
- annulla spedizione: rimuove una spedizione, se non è già stata consegnata 
- consegna spedizione: imposta una spedizione come consegnata
- spedizioni in transito: restituisce le spedizioni in transito 
- spedizioni in ingresso di un utente: dato un utente, ritorna la sua lista di spedizioni
 delle quali è destinatario

Ogni spedizione ha un codice, un peso, un mittente e un destinatario.

Utilizzate i giusti codici di stato per gestire ad esempio prodotti inesistenti, stock
terminato ecc.

Se avete difficoltà col formato JSON, chiamatemi e lo facciamo insieme