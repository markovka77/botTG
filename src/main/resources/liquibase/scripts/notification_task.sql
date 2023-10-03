-- liquibase formatted sql

-- changeset markovka;1
CREATE TABLE notification_task (
    chatId SERIAL,
    message TEXT,
    date DATE,
    key key
)