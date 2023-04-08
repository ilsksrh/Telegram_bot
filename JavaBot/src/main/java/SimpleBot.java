import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import java.io.File;


public class SimpleBot extends TelegramLongPollingBot {
    public String getBotUsername() {
        // TODO
        return "MealFoodBot";
    }

    @Override
    public String getBotToken() {
        // TODO
        return "6042932305:AAEWgAT_6VqW2ke1S1LER-uaE_IFA5uLKS0";
    }

    private void executeCommand(SendMessage resp) {
        try {
            execute(resp);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
    private void executePhoto(SendPhoto photo) {
        try {
            execute(photo);
        } catch (TelegramApiException E) {
            E.printStackTrace();
        }
    }
    @Override
    public void onUpdateReceived(Update update) {
        String command = update.getMessage().getText();
        SendMessage resp = new SendMessage();
        SendPhoto photo = new SendPhoto();
        photo.setChatId(update.getMessage().getChatId().toString());

        if (command.equals("/toyota")) {
            photo.setPhoto(new InputFile(new File("images/toyota.jpg")));
            executePhoto(photo);
            String message = "ToyotaGR86!! The price is 28,400$ ";
            resp.setChatId(update.getMessage().getChatId().toString());
            resp.setText(message);
            executeCommand(resp);
        }
        if (command.equals("/nissan")) {
            photo.setPhoto(new InputFile(new File("images/nissan.jpg")));
            executePhoto(photo);
            String message = "NissanZ!! The price is 39,990$ ";
            resp.setChatId(update.getMessage().getChatId().toString());
            resp.setText(message);
            executeCommand(resp);
        } else if (command.equals("/zhiguly")) {
            String message = "Zhiguly (Lada)!! The price is 2,000$";
            photo.setPhoto(new InputFile(new File("images/zhiguly.jpg")));
            executePhoto(photo);
            resp.setChatId(update.getMessage().getChatId().toString());
            resp.setText(message);
            executeCommand(resp);
        } else if (command.equals("/tesla")) {
            String message = "Tesla Model S Plaid!! The price is 239 990$";
            photo.setPhoto(new InputFile(new File("images/tesla.jpg")));
            executePhoto(photo);
            resp.setChatId(update.getMessage().getChatId().toString());
            resp.setText(message);
            executeCommand(resp);
        } else if (command.equals("/hyundai")) {
            String message = "Hyundai Sonata!! The price is 40,000$";
            photo.setPhoto(new InputFile(new File("images/hyundai.jpg")));
            executePhoto(photo);
            resp.setChatId(update.getMessage().getChatId().toString());
            resp.setText(message);
            executeCommand(resp);
        }
    }
}