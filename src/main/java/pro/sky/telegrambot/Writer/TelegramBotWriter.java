package pro.sky.telegrambot.Writer;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.SendResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import pro.sky.telegrambot.Model.Notification_task;
import pro.sky.telegrambot.Repository.Notification_task_Repository;
import pro.sky.telegrambot.listener.TelegramBotUpdatesListener;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TelegramBotWriter {

    private Logger logger = LoggerFactory.getLogger(TelegramBotUpdatesListener.class);

    @Autowired
    private TelegramBot telegramBot;

    public TelegramBotWriter() {

    }

    @Autowired
    private Notification_task_Repository notification_task_repository;

    public TelegramBotWriter(Notification_task_Repository notificationTaskRepository) {
        this.notification_task_repository = notificationTaskRepository;
    }

    @Scheduled(cron = "0 0/1 * * * *")
    public String writeAnswer() {

        LocalDateTime dateTime = LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES);
        List<Notification_task> notificationTask = notification_task_repository.findAll();
        List<Long> chatId = notificationTask.stream()
                .filter(noty -> noty.getDateTime().equals(dateTime))
                .map(Notification_task::getChatId)
                .collect(Collectors.toList());
        System.out.println(chatId);

        for (Long chat_Id : chatId) {
            String item = notification_task_repository.findItemByChatId(chat_Id, dateTime);
            System.out.println(item);
            System.out.println(chat_Id);
            SendResponse response = telegramBot.execute(new SendMessage(chat_Id, item));
        }
        return null;
    }


}
