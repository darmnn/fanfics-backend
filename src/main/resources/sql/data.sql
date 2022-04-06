insert into fandom(name) value('One direction');
insert into fandom(name) value('Naruto');
insert into fandom(name) value('Stranger things');
insert into fandom(name) value('BTS');

insert into category(name) value('Аниме и манга');
insert into category(name) value('Книги');
insert into category(name) value('Мульфильмы');
insert into category(name) value('Сериалы и фильмы');
insert into category(name) value('Знаменитости');

insert into tag(name) value('Вымышленные существа');
insert into tag(name) value('Магия');
insert into tag(name) value('Философия');
insert into tag(name) value('Социальные темы');
insert into tag(name) value('Смерть персонажа');

insert into genre(name) value('Драма');
insert into genre(name) value('Триллер');
insert into genre(name) value('Роман');
insert into genre(name) value('Фэнтези');
insert into genre(name) value('Ужасы');

insert into book(name, description, rating, fandom, category, genre) values('Ghostbuster 2.0', 'Вряд ли молодая девушка могла бы подумать, насколько её прошлое запутанное. Её состояние с каждым днем ухудшается, а призраки из прошлого все чаще посещают её.', 3, 1, 2, 3);
insert into book(name, description, rating, fandom, category, genre) values('Вселенная забытого бога', 'Жизнь его исчиляется множеством столетий, а богатства королей - ничто в сравнении с сокровищами в его владении.', 3, 1, 2, 3);
insert into book(name, description, rating, fandom, category, genre) values('Восход Теней', 'Больше века минуло со свержения Тёмного. Мир расколот междоусобицами, боги требуют всё больше жертв, возвращаются герои забытых сказок. ', 2, 2, 1, 1);
insert into book(name, description, rating, fandom, category, genre) values('Синеглазый офицер', 'Как могли бы развиваться отношения двух главных героев. В этой версии событий нет Варвары Синичкиной, Глеб Жеглов не убивал Левченко. Возможно, появится намек на дело Груздевой.', 1, 4, 2, 2);
insert into book(name, description, rating, fandom, category, genre) values('Эгеон', 'Лина с детства грезила морем и всегда была защитницей окружающей среды. Её главное увлечение — дайвинг и книги по морской биологии, а поступление в Институт естественных наук стало приоритетом в жизни.', 3, 1, 4, 3);

insert into book_tag_map(book_id, tag_id) value(1, 1);
insert into book_tag_map(book_id, tag_id) value(1, 2);
insert into book_tag_map(book_id, tag_id) value(1, 3);
insert into book_tag_map(book_id, tag_id) value(2, 4);
insert into book_tag_map(book_id, tag_id) value(2, 2);
insert into book_tag_map(book_id, tag_id) value(3, 1);
insert into book_tag_map(book_id, tag_id) value(3, 3);
insert into book_tag_map(book_id, tag_id) value(4, 2);
insert into book_tag_map(book_id, tag_id) value(4, 4);
insert into book_tag_map(book_id, tag_id) value(5, 5);

insert into chapter(number, name, text, book) value(1, 'First chapter', 'Я заглушил мотор арендованного автомобиля и начал всматриваться в лобовое стекло. Снова взглянув на потрепанную фотографию белого, только что отремонтированного особняка, совершенно не удивился.', 1);
insert into chapter(number, name, text, book) value(2, 'Second chapter', 'Старый трехэтажный особняк с башенкой наверху стоял в метрах 100 от моей машины. Окутанный плотным туманом, он казался больше привидением, чем реальной постройкой.', 1);
insert into chapter(number, name, text, book) value(1, 'Первая глава', 'Я неохотно вышел из автомобиля. Под ботинками захрустел гравий, разнося весть о моем прибытии по окрестностям.', 2);
insert into chapter(number, name, text, book) value(2, 'Вторая глава', 'Путь до дома пролегал через заросший дикими растениями двор. Полная луна освещала мощенную светлым камнем дорожку до темного крыльца.', 2);