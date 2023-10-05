package pro.sky.telegrambot;


import com.pengrad.telegrambot.TelegramBot;

import javax.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;


@Entity
public class Notification_task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    Long chatId;
    LocalDateTime dateTime;
    String content;

//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name="taskId")
//    private TelegramBot telegramBot;

    public Notification_task(Long id, Long chatId,LocalDateTime dateTime, String content) {
        this.id = id;
        this.chatId = chatId;
        this.dateTime=dateTime;
        this.content = content;
    }

    public Notification_task(){

    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getChatId() {
        return chatId;
    }

    public void setChatId(Long chatId) {
        this.chatId = chatId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Notification_task that = (Notification_task) o;
        return Objects.equals(id, that.id) && Objects.equals(chatId, that.chatId) && Objects.equals(dateTime, that.dateTime) && Objects.equals(content, that.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, chatId, dateTime, content);
    }

    @Override
    public String toString() {
        return "Notification_task{" +
                "id=" + id +
                ", chatId=" + chatId +
                ", dateTime=" + dateTime +
                ", content='" + content + '\'' +
                '}';
    }
}