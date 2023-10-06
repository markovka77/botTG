-- liquibase formatted sql

-- changeset markovka;1
CREATE TABLE notification_task (
    id SERIAL PRIMARY KEY NOT NULL
    chatId Long NOT NULL
    dateTime LOCAl DATE TIME NOT NULL
    items varchar NOT NULL
);
-- changeset markovka;2
ALTER TABLE notification_task(
 DROP COLUMN content);