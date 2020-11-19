# Ordinare i pixel di un'immagine... in parallelo :motorcycle:

GRIS è tornata!

In questo esercizio dovrete smontarla e rimontarla in ordine, cioè dovrete ordinare i suoi pixel dal più scuro al più lucente e creare una nuova immagine dove questi pixels compaiono da sinistra a destra, da su a giù. Ovviamente dovrete **sfruttare il parallelismo** per rendere efficente il programma.


Immagine di esempio input:
<p align="center">
<img src="https://raw.githubusercontent.com/Jaeger87/CorsoTree2020/master/module_11/02_From%20sequential%20to%20parallel/BordiSequenziale/gris.png"  class="center">
</p>

Immagine in output
<p align="center">
<img src="outputImage.png"  class="center">
</p>


Per definire se un pixel è più luminoso di un altro, basta sommare le sue tre componenti RGB e vedere se sono maggiori o minori dell'altro pixel; se sono maggiori il pixel è più luminoso, altrimenti è più scuro.


## Suggerimenti

Per realizzare questo programma pensate a un algoritmo che avete già visto che serve per ordinare elementi e immaginatelo su dei pixel e a come poterlo rendere parallelizzato.