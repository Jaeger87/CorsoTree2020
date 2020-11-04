package botspesa;

import com.botticelli.bot.Bot;
import com.botticelli.bot.request.methods.MessageToSend;
import com.botticelli.bot.request.methods.types.*;

import java.util.ArrayList;
import java.util.List;

public class BotSpesa extends Bot {

    List<ListaDellaSpesa> listeSpesa = new ArrayList<>();

    public BotSpesa(String token) {
        super(token);
    }

    @Override
    public void textMessage(Message message) {
        ListaDellaSpesa listaUtente = getUserListaSpesa(message.getFrom());
        switch (listaUtente.getStatoUtente())
        {
            case NORMALE:
                ComandoListaSpesa comandoListaSpesa = ComandoListaSpesa.fromString(message.getText().toLowerCase());

                switch (comandoListaSpesa) {
                    case START:
                        inviaMessaggioBenvenuto(message.getFrom());
                        break;
                    case LISTA:
                        sendMessage(new MessageToSend(message.getFrom().getId(), listaUtente.toString()));
                        break;
                    case AGGIUNGI:
                        listaUtente.setStatoUtente(StatoUtente.AGGIUNGIPRODOTTO);
                        sendMessage(new MessageToSend(message.getFrom().getId(), "Inviami quale prodotto aggiungere scrivendo nome prodotto-quantità oppure solo il prodotto"));
                        break;
                    case RIMUOVI:
                        listaUtente.setStatoUtente(StatoUtente.RIMUOVIPRODOTTO);
                        sendMessage(new MessageToSend(message.getFrom().getId(), "Scrivimi il numero di prodotto che vuoi rimuovere"));
                        break;
                    case ERRORE:
                        sendMessage(new MessageToSend(message.getFrom().getId(), "Comando non valido"));
                        break;
                }
                break;
            case AGGIUNGIPRODOTTO:
                String text = message.getText();
                String[] parametri = text.split("-");
                if (parametri.length == 1)
                    listaUtente.addItem(parametri[0]);
                else
                    listaUtente.addItem(parametri[0], Integer.valueOf(parametri[1]));
                sendMessage(new MessageToSend(message.getFrom().getId(), "Prodotto aggiunto!"));
                break;
            case RIMUOVIPRODOTTO:
                if(listaUtente.removeItem(Integer.valueOf(message.getText())))
                    sendMessage(new MessageToSend(message.getFrom().getId(), "Prodotto rimosso!"));
                else
                    sendMessage(new MessageToSend(message.getFrom().getId(), "Indice non valido"));
                break;
        }

    }

    private ListaDellaSpesa getUserListaSpesa(User user) {
        for (ListaDellaSpesa lds : listeSpesa)
            if (lds.getUserID() == user.getId())
                return lds;
        ListaDellaSpesa nuovaLista = new ListaDellaSpesa(user.getId());
        listeSpesa.add(nuovaLista);
        return nuovaLista;
    }

    private void inviaMessaggioBenvenuto(User user) {
        List<List<KeyboardButton>> keyboard = new ArrayList<>();
        List<KeyboardButton> line = new ArrayList<>();
        line.add(new KeyboardButton("Lista della spesa"));
        keyboard.add(line);
        line = new ArrayList<>();
        line.add(new KeyboardButton("Aggiungi"));
        line.add(new KeyboardButton("Rimuovi"));
        keyboard.add(line);
        ReplyKeyboardMarkupWithButtons replyKeyboard = new ReplyKeyboardMarkupWithButtons(keyboard);
        replyKeyboard.setResizeKeyboard(true);

        MessageToSend mts = new MessageToSend(user.getId(), "Benvenuto, usa questo bot per gestire la spesa");
        mts.setReplyMarkup(replyKeyboard);
        sendMessage(mts);
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
