# Morra cinese con carte :motor_scooter: / :motorcycle:

<p align="center">
<img src="https://pm1.narvii.com/6515/1ae0aa126da8ab28a28d956992d82b2c357ed782_hq.jpg" class="center">
</p>

Realizzare un bot che simuli una versione riveduta della morra cinese.

In questa morra cinese non si gioca con i gesti ma si usano le carte; a inizio partita vengono generate 60 carte casuali che come valore possono avere i 3 simboli della morra cinese (sasso, carta forbice) e successivamente si comunica ai giocatori quante carte di ogni tipo sono state generate. Successivamente si danno tre carte ad ogni giocatore e questi dovranno scegliere una carta da giocare. Le carte scelte si scontrano con le regole della morra cinese, perciò se un giocatore ha giocato forbice e l'altro carta, il primo avrà vinto la manche, otterrà un punto e comincia una nuova manche con altre tre carte per ognuno. In caso di pareggio (stesso simbolo) si continua con le altre carte rimaste in mano fino a che non finiscono, a quel punto la mano è considerata para. Vince il primo giocatore che realizza 3 punti, se le carte del mazzo finiscono la partita è considerata un pareggio.


<p align="center">
<img src="https://scontent.ffco3-1.fna.fbcdn.net/v/t31.0-8/19984077_1636537016380444_8061355535848609364_o.jpg?_nc_cat=101&ccb=2&_nc_sid=9267fe&_nc_ohc=cPkiOclOyPMAX8cxWKG&_nc_ht=scontent.ffco3-1.fna&oh=648f06e3227f8131529ede5ea30ecdb4&oe=5FC88ACD" class="center">
</p>


Il bot permette ad un giocatore di sfidare il computer. Quando un giocatore scrive "nuova partita" il bot avvia la partita, genera le carte random e comunica al giocatore quante carte di ogni tipo sono state generate. Il bot quindi continua a simulare il gioco dando 3 di queste carte al giocatore e 3 al "giocatore simulato" dalla cpu. Le carte al giocatore sono mostrate su un tastierino di una sola riga e hanno sopra il simbolo(:punch:, :raised_hand_with_fingers_splayed:, :v:) e l'indice della carta nella mano (esempio: "1: :v:"); quando il giocatore gioca una carta la CPU seleziona casualmente una sua carta e la gioca, a quel punto il bot risolve la mano e da il punto oppure in caso di pareggio fa continuare la mano se ci sono ancora carte da giocare. Il bot controlla il punteggio della partita e quando un giocatore vince o le carte finiscono lo comunica all'utente e la partita finisce. Il bot deve permettere a più utenti di poter giocare contemporaneamente.


