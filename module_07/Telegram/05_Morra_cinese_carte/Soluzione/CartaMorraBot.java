package cartamorra;

import com.botticelli.bot.Bot;
import com.botticelli.bot.request.methods.MessageToSend;
import com.botticelli.bot.request.methods.types.*;

import java.util.ArrayList;
import java.util.List;

public class CartaMorraBot extends Bot {

    List<Partita> registroPartite;


    public CartaMorraBot(String token)
    {
        super(token);
        registroPartite = new ArrayList<>();
    }

    @Override
    public void textMessage(Message message) {
        Partita partitaUtente = getUserPartita(message.getFrom());

        if(partitaUtente == null)//l'utente non ha una partita corrente
        {
            if(message.getText().toLowerCase().equals("nuova partita"))
            {
                partitaUtente = new Partita(message.getFrom().getId());
                registroPartite.add(partitaUtente);

                sendCardsMessage(partitaUtente.getNumberRockPaperScissor(), message.getFrom());

                partitaUtente.giveCards();

                MessageToSend messageToSend = new MessageToSend(message.getFrom().getId(), "Gioca una carta!");
                messageToSend.setReplyMarkup(getHandKeyboard(partitaUtente.getHumanHand()));
                sendMessage(messageToSend);
                return;
            }

            sendMessage(new MessageToSend(message.getFrom().getId(),"Comando non riconosciuto"));

            sendMessage(new MessageToSend(message.getFrom().getId(),"Scrivi \"Nuova partita\" per iniziare una nuova partita"));
            return;
        }


        //Qui do per scontato che la stringa sia di tipo "indice:emoji". Bisognerebbe gestire la cosa, ma visto che non abbiamo ancora visto come gestire gli errori non la vedremo qui 😉
        String [] messaggioSmontato = message.getText().split(": ");
        MorraCinese mossaUmano = MorraCinese.fromString(messaggioSmontato[1]);
        MorraCinese mossaCPU = partitaUtente.giocata(Integer.parseInt(messaggioSmontato[0]) - 1, mossaUmano);

        if(mossaCPU == null)
            sendMessage(new MessageToSend(message.getFrom().getId(), "errore"));
        sendMessage(new MessageToSend(message.getFrom().getId(), mossaCPU.toString()));


        Partita.EsitoMorra esito = partitaUtente.checkMorra(mossaUmano, mossaCPU);

        switch(esito){
            case CPU:
                sendMessage(new MessageToSend(message.getFrom().getId(), "Un punto alla CPU! " + partitaUtente.getScore()));
                break;
            case PAREGGIO:
                sendMessage(new MessageToSend(message.getFrom().getId(), "Pareggio " + partitaUtente.getScore()));
                break;

            case UMANO:
                sendMessage(new MessageToSend(message.getFrom().getId(), "Un punto all'umano! "+ partitaUtente.getScore()));
                break;

            case VITTORIACPU:
                sendFinePartita(message.getFrom(), "Partita vinta dalla CPU");
                return;

            case VITTORIAUMANO:
                sendFinePartita(message.getFrom(), "Partita vinta dall'umano");
                return;
        }

        if(esito == Partita.EsitoMorra.PAREGGIO)
            if(partitaUtente.controllaMano())
            {
                MessageToSend messageToSend = new MessageToSend(message.getFrom().getId(), "Gioca una carta!");
                messageToSend.setReplyMarkup(getHandKeyboard(partitaUtente.getHumanHand()));
                sendMessage(messageToSend);
                return;
            }

        if (partitaUtente.giveCards()) {
            MessageToSend messageToSend = new MessageToSend(message.getFrom().getId(), "Ecco una nuova mano");
            messageToSend.setReplyMarkup(getHandKeyboard(partitaUtente.getHumanHand()));
            sendMessage(messageToSend);
        }
        else
            {
                sendFinePartita(message.getFrom(), "Partita terminata in pareggio, carte finite");
            }

    }

    private void sendFinePartita(User user, String message)
    {
        MessageToSend mts = new MessageToSend(user.getId(), message);
        mts.setReplyMarkup(new ReplyKeyboardRemove());
        sendMessage(mts);
        eliminaPartita(user);
    }

    private void sendCardsMessage(int[] cards, User user)
    {
        String message = "Ottimo, cominciamo una nuova partita!\n\n\n" +
                "Sono state sorteggiate:\n" +
                "\n" +
                cards[0] + " carte \uD83D\uDC4A\uD83C\uDFFB\n" +
                cards[1] +" carte \uD83D\uDD90\uD83C\uDFFB\n" +
                cards[2] +" carte ✌\uD83C\uDFFB";
        sendMessage(new MessageToSend(user.getId(), message));
    }

    private ReplyKeyboardMarkupWithButtons getHandKeyboard(List<MorraCinese> cards)
    {
            List<List<KeyboardButton>> keyboard = new ArrayList<>();
            List<KeyboardButton> line = new ArrayList<>();
            for(int i = 0; i < cards.size(); i++)
            {
                line.add(new KeyboardButton(""+ (i + 1) + ": " + cards.get(i).toString()));
            }
            keyboard.add(line);
            return new ReplyKeyboardMarkupWithButtons(keyboard);
    }

    private Partita getUserPartita(User user)
    {
        for(Partita p : registroPartite)
        {
            if (p.getPlayerID() == user.getId())
                return p;
        }
        return null;
    }

    private void eliminaPartita(User user)
    {
        for(int i = 0; i < registroPartite.size(); i++)
        {
            if (registroPartite.get(i).getPlayerID() == user.getId())
            {
                registroPartite.remove(i);
                return;
            }

        }
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
