# BoxBlur - Sfocare un'immagine :motor_scooter:

In questo esercizio dovrete applicare un effetto di sfocatura (Blurring) ad un'immagine di input


Un'immagine non è altro che una matrice di pixel:
<p align="left">
<img src="https://miro.medium.com/max/361/0*_klxuhghFqIcwp_0.png"  class="center">
</p>

Per sfocare un pixel **p**, nel caso del BoxBlur, l'operazione da fare è calcolare la media dei pixel intorno a **p** compreso **p** stesso.


Nell'esempio vogliamo calcolare il nuovo colore del pixel 5, quindi calcolo la media dei colori degli 8 pixel che lo circondano e del pixel 5. In questo caso si tratta di un blurring con raggio 1, perchè stiamo considerando i pixel distanti 1 pixel dal pixel 5
<p align="left">
<img src="https://miro.medium.com/max/700/1*os3aNloxOHqpuP5iWf1fKQ.png"  class="center">
</p>

Il raggio può essere aumentato, in quest'altro caso calcoliamo il blurring con raggio 2 del pixel 13
<p align="left">
<img src="https://miro.medium.com/max/700/1*12kvHXkXGLnLHslGn6pSxQ.png"  class="center">
</p>


Più è ampio il raggio e maggiore è l'effetto di sfocatura, ma allo stesso tempo diventa più lunga la computazione
<p align="left">
<img src="https://miro.medium.com/max/700/1*wCZ2HfnBJ70YqcBPVv9B-w.png"  class="center">
</p>

P.S. il calcolo della media va applicato a tutti i pixel, fare attenzione ai pixel vicino al bordo, non andate fuori dal range della matrice




# Task
Scrivere un metodo che dato il percorso su disco di un file immagine e un intero **r**, effettui il blur dell'immagine con raggio **r** tramite l'uso di Thread con un esecuzione parallela.