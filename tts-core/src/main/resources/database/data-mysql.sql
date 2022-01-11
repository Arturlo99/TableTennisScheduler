-- TEST DATA
-- T_USER
insert into T_USER (id, email, password, name, last_name, role_id) values (1, 'ewenger0@wsj.com', 'c32de767d42a0d2cc9e13fc4b716173554841fc4a1077d833ee4134d474d76d8', 'Eugine', 'Wenger', 2);
insert into T_USER (id, email, password, name, last_name, role_id) values (2, 'dormonde1@who.int', 'dcd9128e9856a8a700e1972b6c7224ee7596e285756db0b04fc69272af6a4b0d', 'Diann', 'Ormonde', 2);
insert into T_USER (id, email, password, name, last_name, role_id) values (3, 'bmayow2@netvibes.com', '10107fc976c4f17d84f9dd75bea5f17cc4ad0735ab75496a062f2806061e7ffd', 'Bran', 'Mayow', 2);
insert into T_USER (id, email, password, name, last_name, role_id) values (4, 'hdebeauchamp3@zdnet.com', 'b825ae814686d1cf2c7bc1c16d433eee5aff978d8d0a105629f6015500305912', 'Hank', 'De Beauchamp', 2);
insert into T_USER (id, email, password, name, last_name, role_id) values (5, 'tmellish4@hostgator.com', '9f1e9735c9644cacd1d7b3b34560f5f22af451ddfbf667975596d6d782baffa3', 'Tore', 'Mellish', 2);
insert into T_USER (id, email, password, name, last_name, role_id) values (6, 'fbalaizot5@opera.com', 'd637afde36faf4561485f500aa3d08db2d946f36767f385ad26306ec56866c0d', 'Faustine', 'Balaizot', 2);
insert into T_USER (id, email, password, name, last_name, role_id) values (7, 'vgathercoal6@tmall.com', 'b36a49cdc62e07774e5de2c9c7c88f3116e61d89012128471a11f281eceed217', 'Vern', 'Gathercoal', 2);
insert into T_USER (id, email, password, name, last_name, role_id) values (8, 'aridder7@prlog.org', '0422eb369d83652d815ecfcf376a526b7d0d4a6c3be6e803fd7e50ffd3b2f7f7', 'Alex', 'Ridder', 2);
insert into T_USER (id, email, password, name, last_name, role_id) values (9, 'peastment8@geocities.com', '288f9eff6e8301933607aa5d9d8f7d15de731fb5ba89fcf1dc5c6c24f359a971', 'Pedro', 'Eastment', 2);
insert into T_USER (id, email, password, name, last_name, role_id) values (10, 'jforeman9@smh.com.au', '9d407664607f2af27a6562e16aae4d5c2590db97ce7228eb9846a5a2b1a9afc7', 'Jacquelynn', 'Foreman', 2);
insert into T_USER (id, email, password, name, last_name, role_id) values (11, 'kosannea@yandex.ru', '0ff2a7f6c97ee8dcd6f945a6c46d5072b9e77406c847d6dbaf1a06b88ae9e300', 'Kalil', 'Osanne', 2);
insert into T_USER (id, email, password, name, last_name, role_id) values (12, 'akowalikb@twitter.com', 'f857dfdf6ea1413f4f278f78ac739a65e509e5b5cf85cca0a08246e2d22606af', 'Annalise', 'Kowalik', 2);
insert into T_USER (id, email, password, name, last_name, role_id) values (13, 'gleijsc@cnet.com', '840e2da237f095e5f1a4ce8ccd1d3b62ed5328288b15a1ca48ad683e1af2d7b0', 'Grace', 'Leijs', 2);
insert into T_USER (id, email, password, name, last_name, role_id) values (14, 'awilcocked@oaic.gov.au', 'a80e09042645129d9480eea1b57267f97e5abcf2da1eaa3437aacbb0a56c64d6', 'Atlanta', 'Wilcocke', 2);
insert into T_USER (id, email, password, name, last_name, role_id) values (15, 'adewhurste@google.cn', '757854bc11f01f473f591549a19a69f4d194f28b6ea885db6d77d0bb57e9ce3b', 'Arvy', 'Dewhurst', 2);
insert into T_USER (id, email, password, name, last_name, role_id) values (16, 'gpointingf@apache.org', '25b290fc352174ec442718bbc6ebbd91ae4ecfc6930ca480abeb766c0c3da987', 'Gilli', 'Pointing', 2);
insert into T_USER (id, email, password, name, last_name, role_id) values (17, 'udalstong@vkontakte.ru', '9d4c1016a2a456cc82eae1d3be82649d81cec7832e7041e4a436f9549e460143', 'Ulrikaumeko', 'Dalston', 2);
insert into T_USER (id, email, password, name, last_name, role_id) values (18, 'jgloyh@yale.edu', '302b7229acf456a8a3101e0ae387f806c14828614b92759e6bbff7cac8915a93', 'Jayme', 'Gloy', 2);
insert into T_USER (id, email, password, name, last_name, role_id) values (19, 'ebuntaini@alexa.com', '6bdbf4cad64784a047587c9617862116514db1828ab38ebb95f996c0f48bf41d', 'Erv', 'Buntain', 2);
insert into T_USER (id, email, password, name, last_name, role_id) values (20, 'kmontaguej@phoca.cz', '986f862325b6cd45e2bcfe6fc1499eed3559efc7f8b8aa93e60825bce3a1a813', 'Kilian', 'Montague', 2);

-- T_TOURNAMENT
insert into T_TOURNAMENT (id, name, city, street, date, description, max_players, organizer_id) values (1, 'Amateur table tennis tournament', 'Rio de Moinhos', 'Independence', '2022-06-25 13:40:13', 'Entry fee: 5$. It is mandatory to have sports footwear in the sports hall.', 8, 1);
insert into T_TOURNAMENT (id, name, city, street, date, description, max_players, organizer_id) values (2, 'Amateur table tennis tournament', 'Cuenca', 'Knutson', '2022-01-09 20:31:48', 'Entry fee: 5$. It is mandatory to have sports footwear in the sports hall.', 8, 1);
insert into T_TOURNAMENT (id, name, city, street, date, description, max_players, organizer_id) values (3, 'Amateur table tennis tournament', 'Carnaxide', 'Merry', '2022-03-25 16:34:46', 'Entry fee: 5$. It is mandatory to have sports footwear in the sports hall.', 8, 1);
insert into T_TOURNAMENT (id, name, city, street, date, description, max_players, organizer_id) values (4, 'Amateur table tennis tournament', 'Ya’ngan', 'Talmadge', '2022-03-25 10:08:07', 'Entry fee: 5$. It is mandatory to have sports footwear in the sports hall.', 8, 1);
insert into T_TOURNAMENT (id, name, city, street, date, description, max_players, organizer_id) values (5, 'Amateur table tennis tournament', 'Cabinda', 'Coolidge', '2022-02-11 06:40:43', 'Entry fee: 5$. It is mandatory to have sports footwear in the sports hall.', 8, 1);
insert into T_TOURNAMENT (id, name, city, street, date, description, max_players, organizer_id) values (6, 'Amateur table tennis tournament', 'Lezhu', 'Tennyson', '2022-08-08 03:57:06', 'Entry fee: 5$. It is mandatory to have sports footwear in the sports hall.', 8, 1);
insert into T_TOURNAMENT (id, name, city, street, date, description, max_players, organizer_id) values (7, 'Amateur table tennis tournament', 'Shchelkovo', 'Spaight', '2022-06-14 17:33:59', 'Entry fee: 5$. It is mandatory to have sports footwear in the sports hall.', 8, 1);
insert into T_TOURNAMENT (id, name, city, street, date, description, max_players, organizer_id) values (8, 'Amateur table tennis tournament', 'Qaram Qōl', 'Brickson Park', '2022-02-27 03:50:16', 'Entry fee: 5$. It is mandatory to have sports footwear in the sports hall.', 8, 1);
insert into T_TOURNAMENT (id, name, city, street, date, description, max_players, organizer_id) values (9, 'Amateur table tennis tournament', 'Guniushan', 'Lillian', '2022-04-13 04:15:04', 'Entry fee: 5$. It is mandatory to have sports footwear in the sports hall.', 8, 1);
insert into T_TOURNAMENT (id, name, city, street, date, description, max_players, organizer_id) values (10, 'Amateur table tennis tournament', 'Haguenau', 'Mcguire', '2022-01-25 06:20:19', 'Entry fee: 5$. It is mandatory to have sports footwear in the sports hall.', 8, 1);
insert into T_TOURNAMENT (id, name, city, street, date, description, max_players, organizer_id) values (11, 'Amateur table tennis tournament', 'Zhongnan', 'Sloan', '2022-09-01 22:33:28', 'Entry fee: 5$. It is mandatory to have sports footwear in the sports hall.', 8, 1);
insert into T_TOURNAMENT (id, name, city, street, date, description, max_players, organizer_id) values (12, 'Amateur table tennis tournament', 'Zhiletovo', 'Dunning', '2022-04-01 17:40:10', 'Entry fee: 5$. It is mandatory to have sports footwear in the sports hall.', 8, 1);
insert into T_TOURNAMENT (id, name, city, street, date, description, max_players, organizer_id) values (13, 'Amateur table tennis tournament', 'Gritsovskiy', 'Waywood', '2022-06-20 08:24:20', 'Entry fee: 5$. It is mandatory to have sports footwear in the sports hall.', 8, 1);
insert into T_TOURNAMENT (id, name, city, street, date, description, max_players, organizer_id) values (14, 'Amateur table tennis tournament', 'Oebai', 'Namekagon', '2022-04-14 16:35:57', 'Entry fee: 5$. It is mandatory to have sports footwear in the sports hall.', 8, 1);
insert into T_TOURNAMENT (id, name, city, street, date, description, max_players, organizer_id) values (15, 'Amateur table tennis tournament', 'Sergach', 'Village Green', '2022-09-16 07:53:42', 'Entry fee: 5$. It is mandatory to have sports footwear in the sports hall.', 8, 1);
insert into T_TOURNAMENT (id, name, city, street, date, description, max_players, organizer_id) values (16, 'Amateur table tennis tournament', 'Freiburg im Breisgau', 'Badeau', '2022-03-30 02:19:34', 'Entry fee: 5$. It is mandatory to have sports footwear in the sports hall.', 8, 1);
insert into T_TOURNAMENT (id, name, city, street, date, description, max_players, organizer_id) values (17, 'Amateur table tennis tournament', 'Greytown', 'Eagle Crest', '2022-01-07 05:21:09', 'Entry fee: 5$. It is mandatory to have sports footwear in the sports hall.', 8, 1);
insert into T_TOURNAMENT (id, name, city, street, date, description, max_players, organizer_id) values (18, 'Amateur table tennis tournament', 'Guaymango', 'Fulton', '2022-06-04 09:30:41', 'Entry fee: 5$. It is mandatory to have sports footwear in the sports hall.', 8, 1);
insert into T_TOURNAMENT (id, name, city, street, date, description, max_players, organizer_id) values (19, 'Amateur table tennis tournament', 'Zhangfeng', 'Petterle', '2022-07-07 08:58:39', 'Entry fee: 5$. It is mandatory to have sports footwear in the sports hall.', 8, 1);
insert into T_TOURNAMENT (id, name, city, street, date, description, max_players, organizer_id) values (20, 'Amateur table tennis tournament', 'Nykvarn', 'Warrior', '2022-09-13 04:17:40', 'Entry fee: 5$. It is mandatory to have sports footwear in the sports hall.', 8, 1);

-- T_USER_TOURNAMENT
insert into T_USER_TOURNAMENT (user_id, tournament_id) values (2, 13);
insert into T_USER_TOURNAMENT (user_id, tournament_id) values (2, 7);
insert into T_USER_TOURNAMENT (user_id, tournament_id) values (8, 8);
insert into T_USER_TOURNAMENT (user_id, tournament_id) values (1, 5);
insert into T_USER_TOURNAMENT (user_id, tournament_id) values (2, 14);
insert into T_USER_TOURNAMENT (user_id, tournament_id) values (6, 9);
insert into T_USER_TOURNAMENT (user_id, tournament_id) values (8, 20);
insert into T_USER_TOURNAMENT (user_id, tournament_id) values (9, 13);
insert into T_USER_TOURNAMENT (user_id, tournament_id) values (12, 6);
insert into T_USER_TOURNAMENT (user_id, tournament_id) values (20, 17);
insert into T_USER_TOURNAMENT (user_id, tournament_id) values (19, 13);
insert into T_USER_TOURNAMENT (user_id, tournament_id) values (20, 10);
insert into T_USER_TOURNAMENT (user_id, tournament_id) values (8, 17);
insert into T_USER_TOURNAMENT (user_id, tournament_id) values (10, 11);
insert into T_USER_TOURNAMENT (user_id, tournament_id) values (14, 13);
insert into T_USER_TOURNAMENT (user_id, tournament_id) values (1, 3);
insert into T_USER_TOURNAMENT (user_id, tournament_id) values (16, 17);
insert into T_USER_TOURNAMENT (user_id, tournament_id) values (18, 11);
insert into T_USER_TOURNAMENT (user_id, tournament_id) values (18, 4);
insert into T_USER_TOURNAMENT (user_id, tournament_id) values (2, 10);

-- T_ROLE
INSERT INTO T_ROLE(ID, name) VALUES (1, 'ROLE_ADMIN');
INSERT INTO T_ROLE(ID, name) VALUES (2, 'ROLE_USER');