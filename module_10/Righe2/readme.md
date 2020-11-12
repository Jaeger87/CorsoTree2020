## Mappa di stringhe da file 🛴

Leggere il file righe2.txt usando le classi del package java.nio
Ogni riga segue la formattazione
k:v,v,v,v,v

Creare una Map<String, List<String>>

Per ogni riga del file, aggiungere la chiave col valore della stringa "k" associata ai valori "v,v,v,v,v" della riga

Es.
ciao:come,va,come,stai  ->  map.put("ciao", ["come", "va", "come", "stai"])