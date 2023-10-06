package pro.sky.telegrambot.Model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Objects;


@Entity
public class Notification_task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    Long chatId;
    LocalDateTime dateTime;
    String item;


    public Notification_task(Long chatId, LocalDateTime dateTime, String item) {

        this.chatId = chatId;
        this.dateTime = dateTime;
        this.item = item;
    }

    public Notification_task() {

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

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Notification_task that = (Notification_task) o;
        return Objects.equals(id, that.id) && Objects.equals(chatId, that.chatId) && Objects.equals(dateTime, that.dateTime) && Objects.equals(item, that.item);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, chatId, dateTime, item);
    }

    @Override
    public String toString() {
        return "Notification_task{" +
                "id=" + id +
                ", chatId=" + chatId +
                ", dateTime=" + dateTime +
                ", item='" + item + '\'' +
                '}';
    }
}