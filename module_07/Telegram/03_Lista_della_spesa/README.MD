# Lista della spesa :motor_scooter:

<p align="center">
<img src="https://scontent-fco1-1.cdninstagram.com/v/t51.2885-15/e35/31997986_460118861109965_322486760426700800_n.jpg?_nc_ht=scontent-fco1-1.cdninstagram.com&_nc_cat=105&_nc_ohc=pXxzRkmk744AX8q58DE&tp=18&oh=430a5c15919925c10fcc5db5ef788faf&oe=5FC83369" height="520" class="center">
</p>

[@insta_della_spesa](https://www.instagram.com/insta_della_spesa/?hl=it)


Realizzate un bot che gestisca una lista della spesa e che abbia le seguenti funzionalità:

1. Quando l'utente invia il comando "/start", il bot risponde con un messaggio di benvenuto e un tastierino con le seguenti caratteristiche:
    
    1. La prima riga con un solo bottone con scritto "Lista della spesa"
    2. Seconda riga con un bottone con scritto "Aggiungi" e uno "Rimuovi" 
2. Cliccando sul tasto aggiungi l'utente può aggiungere un prodotto alla lista della spesa assieme alla quantità del prodotto nel formato di stringa "`<nomeprodotto>-<quantità>`" esempio: "Monster energy-5", se l'utente inserisce solo il nome prodotto, il bot capisce da solo che la quantità è 1.
3. Quando l'utente clicca su "Lista della spesa" il bot invia un messaggio con la lista della spesa, ogni elemento della spesa viene stampato con assieme al suo indice di posizione e alla quantità, esempio: 
> 0 Monster 50
>
> 1 Yogurt muller 1

4. Quando l'utente preme il tasto "Rimuovi", il bot chiede all'utente l'indice dell'elemento della lista da rimuovere.

Il bot deve permettere ad ogni utente di avere la propria lista, perciò la lista dei prodotti non è condivisa. Per ogni utente c'è solo una lista della spesa. :smiling_face_with_three_hearts:

Hint: Ogni utente ha il proprio identificativo telegram univoco.