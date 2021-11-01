DROP DATABASE IF EXISTS `TTS`;
CREATE DATABASE `TTS`;
USE `TTS`;

CREATE TABLE T_EVENT (
  ID        int NOT NULL AUTO_INCREMENT, 
  PLACE     varchar(255) NOT NULL, 
  `DATE`    date NOT NULL, 
  ORGANIZER varchar(255) NOT NULL, 
  PRIMARY KEY (ID));
  
CREATE TABLE T_MATCH (
  ID           int NOT NULL AUTO_INCREMENT, 
  FINAL_RESULT varchar(255) NOT NULL, 
  SET_RESULTS  varchar(255) NOT NULL, 
  EVENT_ID     int NOT NULL, 
  PRIMARY KEY (ID));
  
CREATE TABLE T_MATCH_USER (
  MATCH_ID int NOT NULL,
  USER_ID  int NOT NULL,
  PRIMARY KEY (MATCH_ID,
  USER_ID));
  
CREATE TABLE T_USER (
  ID            int NOT NULL AUTO_INCREMENT, 
  EMAIL         varchar(255) NOT NULL, 
  PASSWORD      varchar(255) NOT NULL, 
  NAME          varchar(255) NOT NULL, 
  LAST_NAME     varchar(255) NOT NULL, 
  RATING        float, 
  ROLE          varchar(255) NOT NULL, 
  CREATION_DATE date, 
  PRIMARY KEY (ID));
  
CREATE TABLE T_USER_EVENT (
  USER_ID  int NOT NULL, 
  EVENT_ID int NOT NULL, 
  PRIMARY KEY (USER_ID, 
  EVENT_ID));
  
ALTER TABLE T_MATCH_USER ADD CONSTRAINT FKT_MATCH_US798945 FOREIGN KEY (USER_ID) REFERENCES T_USER (ID);
ALTER TABLE T_MATCH_USER ADD CONSTRAINT FKT_MATCH_US26231 FOREIGN KEY (MATCH_ID) REFERENCES T_MATCH (ID);
ALTER TABLE T_MATCH ADD CONSTRAINT FKT_MATCH598277 FOREIGN KEY (EVENT_ID) REFERENCES T_EVENT (ID);
ALTER TABLE T_USER_EVENT ADD CONSTRAINT FKT_USER_EVE643402 FOREIGN KEY (EVENT_ID) REFERENCES T_EVENT (ID);
ALTER TABLE T_USER_EVENT ADD CONSTRAINT FKT_USER_EVE639301 FOREIGN KEY (USER_ID) REFERENCES T_USER (ID);