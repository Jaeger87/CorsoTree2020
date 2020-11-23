Esercizio Arcade Rank 🏍

Scrivere un programma per gestire le classifiche di una sala-giochi. In particolare, è necessario gestire
sia la classifica "locale" di ogni videogioco presente, che quella "globale". 
 Ogni videogioco ha un id univoco, un nome e un coefficiente di difficoltà  (da 1 a 5)
 Il piazzamento di un utente nella classifica globale è dato dalla somma del suo piazzamento in ciascun
  videogioco moltiplicato per il coefficiente di difficoltà del videogioco. Se l'utente non ha giocato ad un 
  videogioco x, il suo punteggio per x è 0.   
  Ogni utente ha un id univoco e uno username, usato per le classifiche.

Implementare le seguenti operazioni:
- inserisci utente: crea un utente
- inserisci videogioco: crea e inserisce un videogioco nel sistema
- inserisci partita: dato l'id di un utente, l'id di un videogioco e un punteggio, aggiorna la classifica
- classifica di un videogioco: dato un id, restituisce la classifica (top 3) del videogioco con quell'id in formato 
username:punteggio dei primi
- ultime N partite: restituisce le ultime N partite
PLUS  🏍 🏍 - classifica globale: restituisce la classifica globale (top 3) della sala-giochi

Potete assumere che la scala del punteggio sia uniforme per tutti i videogiochi 