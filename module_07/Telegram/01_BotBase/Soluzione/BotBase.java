package botbase;

import com.botticelli.bot.Bot;
import com.botticelli.bot.request.methods.MessageToSend;
import com.botticelli.bot.request.methods.StickerReferenceToSend;
import com.botticelli.bot.request.methods.types.*;

import java.util.ArrayList;
import java.util.List;

public class BotBase extends Bot {

    public BotBase(String token)
    {
        super(token);
    }

    @Override
    public void textMessage(Message message) {
        String text = message.getText().toLowerCase();
        MessageToSend mts;
        Comando c = Comando.fromString(text);
        switch (c)
        {
            case SALUTA:
                saluta(message.getFrom());
                break;
            case MONOPATTINO:
                mts = new MessageToSend(message.getFrom().getId(), "Esercizio Facile");
                sendMessage(mts);
                break;
            case SCOOTER:
                mts = new MessageToSend(message.getFrom().getId(), "Esercizio medio");
                sendMessage(mts);
                break;
            case MOTO:
                mts = new MessageToSend(message.getFrom().getId(), "Esercizio avanzato");
                sendMessage(mts);
                break;
            case TASTIERA:
                inviaMessaggioTastiera(message.getFrom());
                break;
            case ERRORE:
                mts = new MessageToSend(message.getFrom().getId(), "Comando non riconosciuto");
                sendMessage(mts);
                break;
        }

    }

    private void inviaMessaggioTastiera(User user)
    {
        List<List<KeyboardButton>> keyboard = new ArrayList<>();
        List<KeyboardButton> line = new ArrayList<>();
        line.add(new KeyboardButton("\uD83D\uDEF4"));
        line.add(new KeyboardButton("\uD83D\uDEF5"));
        line.add(new KeyboardButton("\uD83C\uDFCD"));
        keyboard.add(line);
        ReplyKeyboardMarkupWithButtons replyKeyboard = new ReplyKeyboardMarkupWithButtons(keyboard);
        replyKeyboard.setResizeKeyboard(true);

        MessageToSend mts = new MessageToSend(user.getId(), "Ecco la tastiera");
        mts.setReplyMarkup(replyKeyboard);
        sendMessage(mts);
    }

    private void saluta(User user)
    {
        String answer = "Ciao ";
        if(user.getUserName() != null)
            answer += "@" + user.getUserName();
        else
            answer += user.getFirstName();
        answer += ", come va?";
        MessageToSend mts = new MessageToSend(user.getId(), answer);
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
        System.out.println(message.getSticker().getFileID());
        MessageToSend mts = new MessageToSend(message.getFrom().getId(), "Bello sto sticker!\nGuarda questo invece");
        sendMessage(mts);
        StickerReferenceToSend stickerReferenceToSend = new StickerReferenceToSend(message.getFrom().getId(), "CAACAgIAAxkBAAM2X5sHDX8ony1BD8Qf0HkImS52OKIAAjsDAAK6wJUFv_rySjUNb74bBA");
        sendStickerbyReference(stickerReferenceToSend);
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
