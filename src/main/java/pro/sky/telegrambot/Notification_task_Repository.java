package pro.sky.telegrambot;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface Notification_task_Repository extends JpaRepository<Notification_task,Long> {


}
