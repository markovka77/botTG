-- liquibase formatted sql

-- changeset markovka;1
CREATE TABLE notification_task (
   id SERIAL PRIMARY KEY NOT NULL,
    dateTime LOCAl DATE TIME NOT NULL
    items varchar NOT NULL
);