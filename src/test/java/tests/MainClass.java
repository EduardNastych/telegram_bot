package tests;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.updates.GetUpdates;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;

public class MainClass extends TelegramLongPollingBot {

    private String token;

    public MainClass(String token) {
        super();
        this.token = token;
    }

    @Override
    public void onUpdateReceived(Update update) {
        // process update
    }

    @Override
    public String getBotUsername() {
        return "my_bot_username";
    }

    @Override
    public String getBotToken() {
        return token;
    }

    public List<Update> getLatestUpdates(int limit) throws TelegramApiException {
        GetUpdates request = new GetUpdates();
        request.setLimit(limit);
        return execute(request);
    }

    public static void main(String[] args) {
        MainClass bot = new MainClass("6046897362:AAGphVAZpT2C5InFMoZ0reJnxHM3spL1mbw");

        try {
            List<Update> updates = bot.getLatestUpdates(1);
            Update lastUpdate = updates.get(0);
            String lastMessage = lastUpdate.getMessage().getText();
            System.out.println(lastMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
