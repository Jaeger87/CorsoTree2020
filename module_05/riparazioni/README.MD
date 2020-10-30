# Ditta di Riparazioni

![Fix-it Felix](https://cdn.theatlantic.com/static/mt/assets/culture_test/wreck%20it%20urban%20615%20disney.png)

Una ditta di riparazioni di caldaie vuole gestire gli interventi a domicilio.
Progettare una classe Riparazione, che contiene l'indirizzo a cui recarsi, la priorità dell'intervento (es. un intero).
Progettare una classe Tecnico, che rappresenta il tecnico che si occuperà della riparazione.

Progettare quindi una classe DittaRiparazioni, che contiene un insieme di tecnici, che gestisce le seguenti funzioni:
* aggiungere una nuova riparazione da fare
* ottenere la lista delle riparazioni in attesa
* ottenere la prossima riparazione con la maggior priorità
* assegnare una riparazione ad un tecnico
* marcare una riparazione come conclusa (può essere identificata dal nome del tecnico che la sta effettuando)
* aggiungere un tecnico alla ditta
* mandare in ferie un insieme di tecnici (identificati per nome)

note: 
* dato che i tencici sono identificati per nome, non devono poter esistere due tecnici con lo stesso nome
* non bisogna assegnare la stessa riparazione a due tecnici