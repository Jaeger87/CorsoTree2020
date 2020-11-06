package questionario;

import com.botticelli.bot.Bot;
import com.botticelli.bot.request.methods.MessageToSend;
import com.botticelli.bot.request.methods.types.*;
import sun.awt.image.SunVolatileImage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class QuestionarioBot extends Bot {

    HashMap<Long, Svolgimento> registroUtenteQuestionario;
    List<Questionario> questionari;

    public QuestionarioBot(String token)
    {
        super(token);
        registroUtenteQuestionario = new HashMap<>();
        questionari = new ArrayList<>();

        Questionario javaQuest = new Questionario("Java test");
        javaQuest.addDomanda(new Domanda("Quale è la parola per richiamare il cotruttore della classe superiore?", 2,
                "Batman", "abstract", "super", "void"));
        javaQuest.addDomanda(new Domanda("Esiste un limite di classi per un unico progetto?", 1,
                "Vero", "Falso"));
        javaQuest.addDomanda(new Domanda("Quante altre classi può estendere una nuova classe?", 0,
                "Una", "nessuna", "centomila", "4"));
        javaQuest.addDomanda(new Domanda("Cosa succede se leggo una posizione di array sbagliata?", 1,
                "Il programma skippa", "Ho un errore", "Mi viene restituito un valore random", "Si spegne il computer"));
        javaQuest.addDomanda(new Domanda("Grazie al polimorfismo posso...", 3,
                "Creare interfacce", "Riempire un array di tutto quello che voglio", "Hackerare il pentagono", "Usare un oggetto senza conoscere la forma specifica"));
        javaQuest.addDomanda(new Domanda("Quale di queste keyword, NON gestisce la visibilità in Java?", 3,
                "private", "public", "protected", "interface"));



        Questionario videogameQuest = new Questionario("Videogame test");
        videogameQuest.addDomanda(new Domanda("Come si chiama l'autore della saga \"Metal gear solid\"?", 0,
                "Hideo Kojima", "Califano", "Shigeru Miyamoto", "Shinji Mikami"));
        videogameQuest.addDomanda(new Domanda("Quale è il nome della mossa super di Chun Li in Street fighter IV?", 1,
                "Hadouken", "Hosenka", "Spinning bird kick", "Sonic boom"));
        videogameQuest.addDomanda(new Domanda("La frase \"What a Horrible Night to Have a Curse\" in quale gioco viene detta?", 3,
                "Alone in the dark", "Silent Hill 3", "Resident evil 9", "Castlevania II: Simon's Quest"));
        videogameQuest.addDomanda(new Domanda("A quale genere appartiene l'indie \"Axiom Verge\"", 4,
                "Platform", "Avventura grafica", "Sparatutto", "Sportivo", "Metroidvania", "Visual novel", "Tower defense", "mmorpg"));
        videogameQuest.addDomanda(new Domanda("Quale di questi giochi NON è stato sviluppato dalla Sierra-online?", 3,
                "King's Quest: Quest for the Crown", "Gabriel knight", "Phantasmagoria", "Caesar III"));
        videogameQuest.addDomanda(new Domanda("Chi ha curato la colonna sonora di VA-11-HALL-A: Cyberpunk Bartender Action?", 2,
                "scntfc", "Califano",  "Garoad", "deadmau5","Nobuo Uematsu"));
        questionari.add(javaQuest);
        questionari.add(videogameQuest);

    }

    @Override
    public void textMessage(Message message) {
        if(!registroUtenteQuestionario.containsKey(message.getFrom().getId()))
        {
            Svolgimento s = startNewQuestionario(message.getText());//Controllo se il messaggio è uguale a uno dei questionari
            if(s != null) {
                //inizia un nuovo questionario
                registroUtenteQuestionario.put(message.getFrom().getId(), s);
                inviaDomanda(message.getFrom(), s.getDomandaAttuale());
            }
            else
            {
                MessageToSend messageToSend = new MessageToSend(message.getFrom().getId(), "Ciao, scegli quale questionario vuoi provare!");
                messageToSend.setReplyMarkup(getQuestionariKeyboard());
                sendMessage(messageToSend);

            }
            return;

        }
        Svolgimento svolgimento = registroUtenteQuestionario.get(message.getFrom().getId());
        svolgimento.checkRisposta(message.getText());
        Domanda attuale = svolgimento.getDomandaAttuale();
        if(attuale == null)
        {
            int score = svolgimento.getScore();
            if(svolgimento.isPerfectScore())
                sendMessage(new MessageToSend(message.getFrom().getId(), "Complimenti, hai fatto un perfect score di: " + score + " punti!"));
            else
                sendMessage(new MessageToSend(message.getFrom().getId(), "Hai totalizzato: " + score + " punti!"));
            registroUtenteQuestionario.remove(message.getFrom().getId());

            MessageToSend messageToSend = new MessageToSend(message.getFrom().getId(), "Vuoi rifare il questionario o provarne uno nuovo?");
            messageToSend.setReplyMarkup(getQuestionariKeyboard());
            sendMessage(messageToSend);

            return;
        }

        inviaDomanda(message.getFrom(), attuale);


    }

    private void inviaDomanda(User user, Domanda domanda)
    {
        MessageToSend messageToSend = new MessageToSend(user.getId(), domanda.getTestoDomanda());
        messageToSend.setReplyMarkup(getRisposteKeyboard(domanda.getRisposte()));
        sendMessage(messageToSend);
    }

    private Svolgimento startNewQuestionario(String nomeQuestionario)
    {
        for(Questionario questionario : questionari)
            if(questionario.getNome().equals(nomeQuestionario))
                return new Svolgimento(questionario);
        return null;
    }

    private ReplyKeyboardMarkupWithButtons getRisposteKeyboard(String[] risposte)
    {
        List<List<KeyboardButton>> keyboard = new ArrayList<>();

        for(String risposta: risposte)
        {
            List<KeyboardButton> line = new ArrayList<>();
            line.add(new KeyboardButton(risposta));
            keyboard.add(line);
        }

        return new ReplyKeyboardMarkupWithButtons(keyboard);
    }

    private ReplyKeyboardMarkupWithButtons getQuestionariKeyboard()
    {
        List<List<KeyboardButton>> keyboard = new ArrayList<>();

        for(Questionario q: questionari)
        {
            List<KeyboardButton> line = new ArrayList<>();
            line.add(new KeyboardButton(q.getNome()));
            keyboard.add(line);
        }

        return new ReplyKeyboardMarkupWithButtons(keyboard);
    }

    @Override
    public void audioMessage(Message message) {

    }

    @Override
    public void videoMessage(Message message) {

    }

    @Override
    public void voiceMessage(Message message) {

    }

    @Override
    public void stickerMessage(Message message) {

    }

    @Override
    public void documentMessage(Message message) {

    }

    @Override
    public void photoMessage(Message message) {

    }

    @Override
    public void contactMessage(Message message) {

    }

    @Override
    public void locationMessage(Message message) {

    }

    @Override
    public void venueMessage(Message message) {

    }

    @Override
    public void newChatMemberMessage(Message message) {

    }

    @Override
    public void newChatMembersMessage(Message message) {

    }

    @Override
    public void leftChatMemberMessage(Message message) {

    }

    @Override
    public void newChatTitleMessage(Message message) {

    }

    @Override
    public void newChatPhotoMessage(Message message) {

    }

    @Override
    public void groupChatPhotoDeleteMessage(Message message) {

    }

    @Override
    public void groupChatCreatedMessage(Message message) {

    }

    @Override
    public void inLineQuery(InlineQuery inlineQuery) {

    }

    @Override
    public void chose_inline_result(ChosenInlineResult chosenInlineResult) {

    }

    @Override
    public void callback_query(CallbackQuery callbackQuery) {

    }

    @Override
    public void gameMessage(Message message) {

    }

    @Override
    public void videoNoteMessage(Message message) {

    }

    @Override
    public void pinnedMessage(Message message) {

    }

    @Override
    public void preCheckOutQueryMessage(PreCheckoutQuery preCheckoutQuery) {

    }

    @Override
    public void shippingQueryMessage(ShippingQuery shippingQuery) {

    }

    @Override
    public void invoiceMessage(Message message) {

    }

    @Override
    public void successfulPaymentMessage(Message message) {

    }

    @Override
    public void routine() {

    }
}
