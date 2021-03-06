CREATE DATABASE TTS;
use tts;
CREATE TABLE T_MATCH
(
    ID               int        NOT NULL AUTO_INCREMENT,
    FIRST_PLAYER_ID  int        NOT NULL,
    SECOND_PLAYER_ID int        NOT NULL,
    FINAL_RESULT     varchar(3) NOT NULL,
    TOURNAMENT_ID    int        NOT NULL,
    PRIMARY KEY (ID)
);
CREATE TABLE T_ROLE
(
    ID   int         NOT NULL AUTO_INCREMENT,
    NAME varchar(30) NOT NULL UNIQUE,
    PRIMARY KEY (ID)
);
CREATE TABLE T_TOURNAMENT
(
    ID             int          NOT NULL AUTO_INCREMENT,
    NAME           varchar(255) NOT NULL,
    CITY           varchar(80)  NOT NULL,
    STREET         varchar(80)  NOT NULL,
    DATE           datetime     NOT NULL,
    DESCRIPTION    varchar(255) NOT NULL,
    MAX_PLAYERS    int          NOT NULL,
    PRESENTER_ID int          NOT NULL,
    PRIMARY KEY (ID)
);
CREATE TABLE T_USER
(
    ID        int          NOT NULL AUTO_INCREMENT,
    EMAIL     varchar(50)  NOT NULL UNIQUE,
    PASSWORD  varchar(255) NOT NULL,
    NAME      varchar(50)  NOT NULL,
    LAST_NAME varchar(50)  NOT NULL,
    ROLE_ID   int          NOT NULL,
    PRIMARY KEY (ID)
);
CREATE TABLE T_USER_TOURNAMENT
(
    USER_ID       int NOT NULL,
    TOURNAMENT_ID int NOT NULL,
    PRIMARY KEY (USER_ID,
                 TOURNAMENT_ID)
);
ALTER TABLE T_TOURNAMENT
    ADD CONSTRAINT FKT_TOURNAME132521 FOREIGN KEY (PRESENTER_ID) REFERENCES T_USER (ID);
ALTER TABLE T_USER
    ADD CONSTRAINT FKT_USER734442 FOREIGN KEY (ROLE_ID) REFERENCES T_ROLE (ID);
ALTER TABLE T_MATCH
    ADD CONSTRAINT FKT_MATCH81441 FOREIGN KEY (SECOND_PLAYER_ID) REFERENCES T_USER (ID);
ALTER TABLE T_MATCH
    ADD CONSTRAINT FKT_MATCH698110 FOREIGN KEY (FIRST_PLAYER_ID) REFERENCES T_USER (ID);
ALTER TABLE T_MATCH
    ADD CONSTRAINT FKT_MATCH62589 FOREIGN KEY (TOURNAMENT_ID) REFERENCES T_TOURNAMENT (ID);
ALTER TABLE T_USER_TOURNAMENT
    ADD CONSTRAINT FKT_USER_TOU412598 FOREIGN KEY (TOURNAMENT_ID) REFERENCES T_TOURNAMENT (ID);
ALTER TABLE T_USER_TOURNAMENT
    ADD CONSTRAINT FKT_USER_TOU615421 FOREIGN KEY (USER_ID) REFERENCES T_USER (ID)