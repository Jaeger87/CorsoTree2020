# Progetto finale


<p align="center">
<img src="https://external-preview.redd.it/s_8Fc1DEpDB6xhsHGEWEaokYgKzrn2DdhgsA3rJBDRo.png?auto=webp&s=7d073e1bdc2c247eafa62f5aa5e7c9d634ca9e24"  class="center">
</p>


Come progetto finale, utilizzando [Spring framework](https://spring.io/), dovrete realizzare il lato backend di un'app Android da noi realizzata e consegnata a voi; questo applicativo è un gestionale di prenotazioni per evitare assembramenti in tempi di covid-19. Gli utenti possono registrarsi alla piattaforma, creare eventi, vedere gli eventi disponibili, iscriversi ad eventi, cancellarsi da eventi e vedere a quali eventi ci si è iscritti.


L'applicativo ha tutto ciò che gli serve lato frontend ma per poter funzionare ha bisogno degli endpoint del backend con cui interagire
## Endpoint backend

Tipo | Nome | Tipo Input | Input | Output | URI | Codice HTTP |Descrizione
------------|--------|--------|-------------|-------------|----------|--------|----------|
POST | signUpUser | Body Json | User { username, password, name, surname, gender, birthDate} | User | /user | 201 |Registra un utente alla piattaforma
GET | logIn | QueryString | [username, password] | User | /login?username={username}&password={password} | 200 | Verifica la corrispondenza di email e password e restituisce l'utente corrispondente
GET | getActiveEvents | | | List\<Event> | /events | 200 |Restituisce gli eventi disponibili a cui l'utente può registrarsi
POST | signToEvent | PathParam | [eventid] | Event | /join/{eventid} | 202 | Registra l'utente ad un evento
POST | createEvent | Body Json | Event {name, capacity, place, date} | Event | /event | 201 | Crea un evento sulla piattaforma
GET | getEventDetails | PathParam | [eventid] | Event | /event/{eventid} | 200 | Restituisce le informazioni dettagliate di un evento.
DELETE | cancelEvent | PathParam | [eventid] | Event | /event/{eventid} | 200 | Permette **solo** al creatore di un evento di annullarlo.
GET | getUserEvents | | | List\<Event> | /user/events | 200 | Restituisce una lista con gli eventi creati dall'utente e quelli a cui ha partecipato. Solo gli eventi futuri, non quelli passati

Questi endpoint inviano e ricevono i dati sotto forma di Json e la sessione con l'utente è gestita tramite cookie.\
Tutti gli endpoint devono far uso dei cookie per capire da quale utente sta arrivando la request.

&nbsp;
## Uno User è caratterizzato dai seguenti campi:

Campo | Tipo | Descrizione
------------ |-------- |-------------
username | String | Un sopranome univoco scelto dall'utente
name | String | Nome dell'utente
surname | String | Cognome dell'utente
birthDate | Date | Data di nascita
gender | Enum | [male, female, other]
password | String | Password dell'utente (non memorizzarle in chiaro)



&nbsp;
## Un Event è caratterizzato dai seguenti campi:

Campo | Tipo | Descrizione
------------ |-------- |-------------
eventid | UUID | ID univoco dell'evento
name | String | Nome dell'evento
date | Date | Data e ora di quando si svolgerà l'evento
place | String | Dove si svolgerà l'evento
capacity | Integer | Quante persone può accogliere l'evento

&nbsp;
## Ci sono una serie di requisiti che l'applicativo deve rispettare:

* Un utente non può creare un evento per una data passata.
* Non possono esistere due utenti con lo stesso username.
* Solo il creatore di un evento può annullarlo
* Un utente non può iscriversi ad un evento dove è stato raggiunto il tetto massimo di iscritti o l'evento è passato.
* Un utente che crea un evento automaticamente è un partecipante dell'evento



Il backend da voi realizzato dovrà esporre gli endpoint elencati come APIREST; per quanto riguarda i dati questi dovranno essere salvati su un database SQL. **Evitate di salvare le password in chiaro nel database.**
