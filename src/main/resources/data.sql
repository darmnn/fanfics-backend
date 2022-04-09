CREATE TABLE fandom
(
    id             INTEGER AUTO_INCREMENT PRIMARY KEY,
    name           VARCHAR(100) UNIQUE,
    createdAt      TIMESTAMP,
    updatedAt      TIMESTAMP
);

CREATE TABLE genre
(
    id               INTEGER AUTO_INCREMENT PRIMARY KEY,
    name             VARCHAR(100) UNIQUE,
    createdAt      TIMESTAMP,
    updatedAt      TIMESTAMP
);

CREATE TABLE category
(
    id               INTEGER AUTO_INCREMENT PRIMARY KEY,
    name             VARCHAR(100) UNIQUE,
    createdAt      TIMESTAMP,
    updatedAt      TIMESTAMP
);

CREATE TABLE tag
(
    id               INTEGER AUTO_INCREMENT PRIMARY KEY,
    name             VARCHAR(100) UNIQUE,
    createdAt      TIMESTAMP,
    updatedAt      TIMESTAMP
);

CREATE TABLE book
(
    id               INTEGER AUTO_INCREMENT PRIMARY KEY,
    name             VARCHAR(100) UNIQUE,
    description      VARCHAR(300),
    quant_of_ratings INT,
    rating INT,
    createdAt      TIMESTAMP,
    updatedAt      TIMESTAMP,
    fandom INTEGER REFERENCES fandom (id) ON DELETE CASCADE,
    category INTEGER REFERENCES category (id) ON DELETE CASCADE,
    genre INTEGER REFERENCES genre (id) ON DELETE CASCADE
);

CREATE TABLE chapter
(
    id               INTEGER AUTO_INCREMENT PRIMARY KEY,
    name             VARCHAR(100) UNIQUE,
    text      VARCHAR(400),
    number INT,
    createdAt      TIMESTAMP,
    updatedAt      TIMESTAMP,
    book INTEGER REFERENCES book (id) ON DELETE CASCADE
);

CREATE TABLE book_tag_map
(
    id               INTEGER AUTO_INCREMENT PRIMARY KEY,
    book INTEGER REFERENCES book (id) ON DELETE CASCADE,
    tag INTEGER REFERENCES tag (id) ON DELETE CASCADE,
    updatedAt      TIMESTAMP,
    createdAt      TIMESTAMP
);

insert into fandom(name) values('One direction');
insert into fandom(name) values('Naruto');
insert into fandom(name) values('Stranger things');
insert into fandom(name) values('BTS');

insert into category(name) values('Аниме и манга');
insert into category(name) values('Книги');
insert into category(name) values('Мульфильмы');
insert into category(name) values('Сериалы и фильмы');
insert into category(name) values('Знаменитости');

insert into tag(name) values('Вымышленные существа');
insert into tag(name) values('Магия');
insert into tag(name) values('Философия');
insert into tag(name) values('Социальные темы');
insert into tag(name) values('Смерть персонажа');

insert into genre(name) values('Драма');
insert into genre(name) values('Триллер');
insert into genre(name) values('Роман');
insert into genre(name) values('Фэнтези');
insert into genre(name) values('Ужасы');

insert into book(name, description, rating, fandom, category, genre) values('Ghostbuster 2.0', 'Вряд ли молодая девушка могла бы подумать, насколько её прошлое запутанное. Её состояние с каждым днем ухудшается, а призраки из прошлого все чаще посещают её.', 3, 1, 2, 3);
insert into book(name, description, rating, fandom, category, genre) values('Вселенная забытого бога', 'Жизнь его исчиляется множеством столетий, а богатства королей - ничто в сравнении с сокровищами в его владении.', 3, 1, 2, 3);
insert into book(name, description, rating, fandom, category, genre) values('Восход Теней', 'Больше века минуло со свержения Тёмного. Мир расколот междоусобицами, боги требуют всё больше жертв, возвращаются герои забытых сказок. ', 2, 2, 1, 1);
insert into book(name, description, rating, fandom, category, genre) values('Синеглазый офицер', 'Как могли бы развиваться отношения двух главных героев. В этой версии событий нет Варвары Синичкиной, Глеб Жеглов не убивал Левченко. Возможно, появится намек на дело Груздевой.', 1, 4, 2, 2);
insert into book(name, description, rating, fandom, category, genre) values('Эгеон', 'Лина с детства грезила морем и всегда была защитницей окружающей среды. Её главное увлечение — дайвинг и книги по морской биологии, а поступление в Институт естественных наук стало приоритетом в жизни.', 3, 1, 4, 3);

insert into book_tag_map(book, tag) values(1, 1);
insert into book_tag_map(book, tag) values(1, 2);
insert into book_tag_map(book, tag) values(1, 3);
insert into book_tag_map(book, tag) values(2, 4);
insert into book_tag_map(book, tag) values(2, 2);
insert into book_tag_map(book, tag) values(3, 1);
insert into book_tag_map(book, tag) values(3, 3);
insert into book_tag_map(book, tag) values(4, 2);
insert into book_tag_map(book, tag) values(4, 4);
insert into book_tag_map(book, tag) values(5, 5);

insert into chapter(number, name, text, book) values(1, 'First chapter', 'Я заглушил мотор арендованного автомобиля и начал всматриваться в лобовое стекло. Снова взглянув на потрепанную фотографию белого, только что отремонтированного особняка, совершенно не удивился.', 1);
insert into chapter(number, name, text, book) values(2, 'Second chapter', 'Старый трехэтажный особняк с башенкой наверху стоял в метрах 100 от моей машины. Окутанный плотным туманом, он казался больше привидением, чем реальной постройкой.', 1);
insert into chapter(number, name, text, book) values(1, 'Первая глава', 'Я неохотно вышел из автомобиля. Под ботинками захрустел гравий, разнося весть о моем прибытии по окрестностям.', 2);
insert into chapter(number, name, text, book) values(2, 'Вторая глава', 'Путь до дома пролегал через заросший дикими растениями двор. Полная луна освещала мощенную светлым камнем дорожку до темного крыльца.', 2);