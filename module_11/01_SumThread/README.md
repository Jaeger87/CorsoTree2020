# Somma parallelizzata :kick_scooter:

Come tutti sapete, tra le proprietà della somma c'è l'associativa e cioè possiamo sostituire alcuni addendi con la loro somma. 

Realizzate un programma che genera un array di dieci milioni di numeri interi (nel range -10, 10), date quindi questo array a due thread, ognuno di questi farà la somma di metà degli elementi. il programma attende che i thread finiscano la loro esecuzione, prende i risultati, li somma e li stampa a schermo.