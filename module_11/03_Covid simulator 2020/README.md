# Covid simulator 2020 :motor_scooter:


<p align="center">
<img src="https://img.trashitalianoapp.it/wp-content/uploads/2020/06/COVIDD.gif"  class="center">
</p>

E invece c'era...


In questa "simulazione", 3 milioni di italiani hanno partecipato ad un programma speciale per scoprire i positivi al covid. Ognuno di questi volontari ha fornito come dati personali la temperatura corporea, l'età, se hanno perso il senso del gusto, se hanno tosse, se si sentono deboli e infine la propria situazione clinica che può avere tre valori: Sotto controllo, cautela e critica. Questi dati sono divisi in 3 file di testo che rappresentano le tre macroaree dell'italia (nord, centro, sud); qui di seguito qualche riga di esempio del file:

```
78df8de7-7fa3-4f8a-b4ee-c6a5daeb231e;35.4;53;true;false;false;SOTTOCONTROLLO
d3b4f62e-1c66-4c0f-9460-20988ae6e3a9;35.2;59;false;false;false;CAUTELA
eeda7666-525b-4412-b14d-f00a15a9a03f;37.8;20;false;true;false;CAUTELA
7cdd8fd5-7071-4e9e-87c0-ae68d4c81b83;36.1;82;false;false;false;SOTTOCONTROLLO
51168c22-2dc2-4db8-a338-3be57e93ec52;35.5;33;false;false;true;SOTTOCONTROLLO
eef2b86a-5860-473c-8acf-b751de8ce335;37.1;60;false;false;false;CRITICA
1dca5590-8df0-4299-8a24-be2397fd2aae;35.4;42;false;false;false;SOTTOCONTROLLO

```

Ogni riga è composta da questi elementi:

Dato | Descrizione
------------ | -------------
Id utente | Un'id univoco del volontario
Temperatura| Temperatura corporea
Età | Quanti anni ha
Gusto | falso se non ha il sintomo di perdita del gusto, vero se ha perso il senso del gusto
Tosse | Vero se ha tosse
Debolezza | Vero se si sente debole
Situazione clinica | La sua situazione clinica con possibili valori [SOTTOCONTROLLO, CAUTELA, CRITICA]


Questi file sono scaricabili da [questo link MEGA](https://mega.nz/file/2tok2CJD#HPkjV30aa8KsKElhFZIvxeoOPVXGC22xRNNZV7z_fGM) (pesavano troppo per git) sotto forma di file zip.

Partendo da questi file vogliamo creare un nuovo File che contiene gli ID di tutti gli utenti a rischio covid; ci sono diversi indicatori per determinare se un utente è a rischio covid e sono:

1. L'utente ha una temperatura maggiore uguale a 40°
2. L'utente ha una temperatura maggiore uguale a 38° e ha tutti i sintomi
3. L'utente ha una situazione clinica critica e O ha una temperatura maggiore uguale a 38.5 o almeno un sintomo
4. L'utente ha almeno 50 anni e una temperatura di almeno 37°
5. L'utente ha almeno 60 anni e, o gli manca il gusto e ha una situazione clinica di "cautela" o ha la tosse e una situazione clinica critica.

Il programma **dovrà implementare** i thread per poter avere performance migliori.

Dentro la cartella soluzione trovate il file con gli id degli utenti a rischio covid, in modo così da poter verificare la vostra soluzione. Attenzione, visto che parliamo di programmazione parallela, l'ordinamento degli id del file che vi ho proposto potrebbe essere diverso da quello che producete voi; l'importante è che ci siano dentro gli stessi id senza ripetizioni.




Bonus: :motorcycle:

Gestendo la concorrenza, fate in modo che il file venga scritto mano a mano che scoprite gli utenti a rischio.