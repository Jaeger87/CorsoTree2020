package randommedia;

import com.botticelli.bot.Bot;
import com.botticelli.bot.request.methods.AudioReferenceToSend;
import com.botticelli.bot.request.methods.PhotoReferenceToSend;
import com.botticelli.bot.request.methods.VoiceReferenceToSend;
import com.botticelli.bot.request.methods.types.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomMediaBot extends Bot {


    private List<String> immagini;
    private List<String> noteAudio;
    private List<String> canzoni;
    private Random random;

    public RandomMediaBot(String token)
    {
        super(token);
        immagini = new ArrayList<>();
        noteAudio = new ArrayList<>();
        canzoni = new ArrayList<>();
        random = new Random();
    }

    @Override
    public void textMessage(Message message) {

    }

    @Override
    public void audioMessage(Message message) {
        canzoni.add(message.getAudio().getFileID());
        int canzoneCasualeIndex = random.nextInt(canzoni.size());
        sendAudiobyReference(new AudioReferenceToSend(message.getFrom().getId(),canzoni.get(canzoneCasualeIndex)));
    }

    @Override
    public void videoMessage(Message message) {

    }

    @Override
    public void voiceMessage(Message message) {
        noteAudio.add(message.getVoice().getFileID());
        int notaAudioCasualeIndex = random.nextInt(noteAudio.size());
        sendVoicebyReference(new VoiceReferenceToSend(message.getFrom().getId(),noteAudio.get(notaAudioCasualeIndex)));
    }

    @Override
    public void stickerMessage(Message message) {
    }

    @Override
    public void documentMessage(Message message) {

    }

    @Override
    public void photoMessage(Message message) {
        System.out.println(message.getFrom().getId());
        System.out.println(message.getFrom().getFirstName());
        System.out.println(message.getFrom().getLastName());
        System.out.println(message.getFrom().getUserName());
        System.out.println(message.getPhoto().get(0).getFileID());
        immagini.add(message.getPhoto().get(0).getFileID());

        int immagineCasualeIndex = random.nextInt(immagini.size());
        sendPhotobyReference(new PhotoReferenceToSend(message.getFrom().getId(),immagini.get(immagineCasualeIndex)));

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
