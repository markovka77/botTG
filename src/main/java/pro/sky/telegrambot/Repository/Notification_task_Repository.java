package pro.sky.telegrambot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pro.sky.telegrambot.Model.Notification_task;

import java.time.LocalDateTime;


@Repository
public interface Notification_task_Repository extends JpaRepository<Notification_task,Long> {

    @Query(value = "select item  from  notification_task where chat_id = :chat_id and date_time = :date_time  ", nativeQuery = true)
    String findItemByChatId(@Param("chat_id")Long chat_id,@Param("date_time")LocalDateTime dateTime);

}
