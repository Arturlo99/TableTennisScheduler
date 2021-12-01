INSERT INTO T_USER (ID, EMAIL, PASSWORD, NAME, LAST_NAME, ROLE, CREATION_DATE)
VALUES (1, 'as@wp.pl', 'asadbadasd', 'user_name', 'user_last_name', 'user', NOW());

INSERT INTO T_USER (ID, EMAIL, PASSWORD, NAME, LAST_NAME, ROLE, CREATION_DATE)
VALUES (2, 'asd@wp.pl', 'asadbaddadasd', 'user_name1', 'user_last_name1', 'user', NOW());

INSERT INTO T_TOURNAMENT(ID, NAME, CITY, STREET, `DATE`, ORGANIZER, DESCRIPTION, MAX_PLAYERS)
VALUES (1, 'Amatorski Turniej Tenisa Stołowego', 'Wrocław', 'ul.Grunwaldzka 64a', '2021-01-29 16:00:00', 'Krzysztof Gwóźdź', 'Bardzo fajny turniej :)', 16);

INSERT INTO T_TOURNAMENT(ID, NAME, CITY, STREET, `DATE`, ORGANIZER, DESCRIPTION, MAX_PLAYERS)
VALUES (2, 'Turniej o puchar burmistrza2', 'Wrocław', 'ul.Gliwicka 43c', '2021-01-29 16:00:00', 'Jakub Brzęczyszczykiewicz', 'Naprawdę warto', 16);

INSERT INTO T_USER_TOURNAMENT(USER_ID, TOURNAMENT_ID)
VALUES (1, 1);

INSERT INTO T_MATCH(ID, FIRST_PLAYER_ID, SECOND_PLAYER_ID, FINAL_RESULT, SET_RESULTS, TOURNAMENT_ID)
VALUES (1, 1, 2, '3:0', '11:1;11:3;11:5', 1);