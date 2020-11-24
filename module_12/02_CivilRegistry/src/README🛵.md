Esercizio Civil Registry 🛵

Scrivere un programma che permetta di gestire un ufficio dell'anagrafe. In particolare, bisogna
gestire una lista di persone, ognuna con nome, cognome, età, codice fiscale e indirizzo di residenza.
Inoltre, devono essere possibili le seguenti operazioni:

- inserisci persona: inserisce la persona nel sistema
- rimuovi persona da codice fiscale: rimuove una persona con il corrispondente codice fiscale dal sistema
- ottieni persone per nome: dato un nome, ritorna le persone che hanno un nome che corrisponde
 o inizia con quello in input
- ottieni le 3 persone più anziane: ritorna le 3 persone più anziane presenti nel sistema
- ottieni indirizzi per nome: dato un nome, ritorna l'indirizzo di tutte le persone con nome 
corrispondente a quello in input

PLUS 🏍: gestire, per ogni persona, la lista dei figli ed implementare un metodo getFigli(nome)
 che ritorna la lista di persone il cui genitore ha il nome che corrisponde o inizia con quello in input
 Esempio: 
 
 ```
 andrea rossi -> [cristina, giorgio]
 andrea bianchi -> [mario]
 getFigli("andrea") -> [cristina, giorgio, mario]
 ```
  