package tests;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.updates.GetUpdates;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import java.math.BigInteger;

public class MyTelegramBot extends TelegramLongPollingBot {

    private final String BOT_TOKEN = "6161930810:AAGYrzHFYnBrw_ZLeT-LSGkcfyqQ4rtrsXo";
    BigInteger CHAT_ID = new BigInteger("-1001891473243");
    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText() && update.getMessage().getChatId().equals(CHAT_ID)) {
            Message message = update.getMessage();
            System.out.println(message.getText());
        }
    }

    public void retrieveAllMessages() {
        GetUpdates request = new GetUpdates();
        request.setLimit(1000);

        try {
            while (true) {
                for (Update update : execute(request)) {
                    onUpdateReceived(update);
                }
                request.setOffset(getLatestMessageId() + 1);
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getLatestMessageId() {
        GetUpdates request = new GetUpdates();
        request.setLimit(1);

        try {
            var updates = execute(request);
            if (updates != null && updates.size() > 0) {
                return updates.get(0).getUpdateId();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public String getBotUsername() {
        return "YourBotUsername";
    }

    @Override
    public String getBotToken() {
        return BOT_TOKEN;
    }
    public static void main(String[] args) {
        MyTelegramBot bot = new MyTelegramBot();
        bot.retrieveAllMessages();
    }
}




