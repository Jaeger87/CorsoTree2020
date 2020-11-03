## Mini Amazon 🏍


Implementare un insieme di classi che modellano il funzionamento di un ecommerce tipo Amazon

Entità

Utente
* id (intero univoco)
* nome


Prodotto
* id (intero univoco)
* nome
* prezzo

ProdottoFisico
* peso
* volume
* quantità disponibile

ProdottoSoftware
* dimensione (KiloByte)
* versione (stringa)


Ordine
* id (intero univoco)
* idUtente - id dell'utente che ha fatto l'ordine
* lista di id prodotti - i prodotti all'interno dell'ordine
* data dell'ordine (usare LocalDateTime)
  

Magazzino
* id (intero univoco)
* lista di prodotti - solo prodotti fisici
* capienza (una capienza di 10 indica che il magazzino può contenere 10 unità di prodotti. tralasciare peso e volume dei prodotti)

SoftwareRepository
* id (intero univoco)
* lista di prodotti - solo prodotti software



Amazon
* lista di magazzini
* lista di SoftwareRepository
* lista di utenti
* lista di ordini


Di seguito i comportamenti che vogliamo modellare
Decidere quali metodi sono necessari per ogni comportamento, un singolo comportamento non necessariamente significa un singolo metodo.


* Registrare un utente
* Aggiungere un prodotto (sia fisico che software)
  * Un prodotto fisico deve essere aggiunto nel magazzino con il maggior spazio disponibile
* Creare un ordine, dato l'id di un utente e la lista degli id dei prodotti che vuole acquistare
* Ottenere la lista di ordini fatti da un utente, calcolando il costo di ogni ordine
* Dato l'id di un prodotto
  * Se è un prodotto fisico, voglio sapere in quale magazzino si trova. Se il prodotto è disponibile in più magazzini, restituire il magazzino con la maggior quantità di quel prodotto
  * Se è un prodotto software, voglio sapere in quale SoftwareRepository si trova.
* Dato l'id di un prodotto, quante unità sono state acquistate, oppure quanti download sono stati effettuati (1 acquisto = 1 download)
