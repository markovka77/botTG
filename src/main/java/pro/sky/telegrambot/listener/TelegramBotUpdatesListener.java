package pro.sky.telegrambot.listener;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.SendResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pro.sky.telegrambot.Model.Notification_task;
import pro.sky.telegrambot.Repository.Notification_task_Repository;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class TelegramBotUpdatesListener implements UpdatesListener {

    private Logger logger = LoggerFactory.getLogger(TelegramBotUpdatesListener.class);

    @Autowired
    private TelegramBot telegramBot;
    @Autowired
    private final Notification_task_Repository notificationTaskRepository;

    public TelegramBotUpdatesListener(Notification_task_Repository notificationTaskRepository) {
        this.notificationTaskRepository = notificationTaskRepository;
    }

    @PostConstruct
    public void init() {
        telegramBot.setUpdatesListener(this);
    }


    @Override
    public int process(List<Update> updates) {

        updates.forEach(update -> {
            logger.info("Processing update: {}", update);


            Long chatID = update.message().chat().id();
            if (update.message().text().equals("/start")) {
                SendMessage message = new SendMessage(chatID, "Hello, how are you?");
                SendResponse response = telegramBot.execute(message);

            }
            Pattern pattern = Pattern.compile("([0-9\\.\\:\\s]{16})(\\s)([\\w+]+)");
            Matcher matcher = pattern.matcher(update.message().text());
            String date = null;
            String item = null;

            if (matcher.matches()) {
                date = matcher.group(1);
                item = matcher.group(3);
                System.out.println(date);
                System.out.println(item);
            }

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
            if (date != null) {
                LocalDateTime dateTime = LocalDateTime.parse(date, formatter);


                notificationTaskRepository.save(new Notification_task(update.message().chat().id(), dateTime, item));
            }


        });
        return UpdatesListener.CONFIRMED_UPDATES_ALL;

    }


}
