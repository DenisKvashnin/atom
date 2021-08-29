CREATE TABLE IF NOT EXISTS raex_dict
(
    id        bigint PRIMARY KEY,
    position  character varying,
    full_name character varying
);

CREATE SEQUENCE raex_dict_seq;

ALTER SEQUENCE raex_dict_seq OWNED BY raex_dict.id;

ALTER TABLE raex_dict
    ALTER COLUMN id SET DEFAULT nextval('raex_dict_seq'::regclass);

INSERT INTO raex_dict(position, full_name)
VALUES (1, 'Московский государственный университет имени М.В. Ломоносова');
INSERT INTO raex_dict(position, full_name)
VALUES (2, 'Московский физико-технический институт (национальный исследовательский университет)');
INSERT INTO raex_dict(position, full_name)
VALUES (3, 'Национальный исследовательский ядерный университет \"МИФИ\"');
INSERT INTO raex_dict(position, full_name)
VALUES (4, 'Санкт-Петербургский государственный университет');
INSERT INTO raex_dict(position, full_name)
VALUES (5, 'Национальный исследовательский университет \"Высшая школа экономики\"');
INSERT INTO raex_dict(position, full_name)
VALUES (6,
        'Московский государственный технический университет имени Н.Э. Баумана (национальный исследовательский университет)');
INSERT INTO raex_dict(position, full_name)
VALUES (7, 'МГИМО МИД России');
INSERT INTO raex_dict(position, full_name)
VALUES (8, 'Национальный исследовательский Томский политехнический университет');
INSERT INTO raex_dict(position, full_name)
VALUES (9, 'Санкт-Петербургский политехнический университет Петра Великого');
INSERT INTO raex_dict(position, full_name)
VALUES (10, 'Российская академия народного хозяйства и государственной службы при Президенте РФ');
INSERT INTO raex_dict(position, full_name)
VALUES (11, 'Новосибирский национальный исследовательский государственный университет');
INSERT INTO raex_dict(position, full_name)
VALUES (12, 'Уральский федеральный университет имени первого Президента России Б.Н. Ельцина');
INSERT INTO raex_dict(position, full_name)
VALUES (13, 'Финансовый университет при Правительстве РФ');
INSERT INTO raex_dict(position, full_name)
VALUES (14, 'Университет ИТМО');
INSERT INTO raex_dict(position, full_name)
VALUES (15, 'Российский экономический университет имени Г.В. Плеханова');
INSERT INTO raex_dict(position, full_name)
VALUES (16, 'Национальный исследовательский технологический университет «МИСиС»');
INSERT INTO raex_dict(position, full_name)
VALUES (17, 'Национальный исследовательский Томский государственный университет');
INSERT INTO raex_dict(position, full_name)
VALUES (18, 'Первый Московский государственный медицинский университет имени И.М. Сеченова Минздрава России');
INSERT INTO raex_dict(position, full_name)
VALUES (19, 'Российский университет дружбы народов');
INSERT INTO raex_dict(position, full_name)
VALUES (20, 'Казанский (Приволжский) федеральный университет');
INSERT INTO raex_dict(position, full_name)
VALUES (21, 'Московский авиационный институт (национальный исследовательский университет)');
INSERT INTO raex_dict(position, full_name)
VALUES (22, 'Российский национальный исследовательский медицинский университет имени Н.И. Пирогова Минздрава России');
INSERT INTO raex_dict(position, full_name)
VALUES (23, 'Сибирский федеральный университет');
INSERT INTO raex_dict(position, full_name)
VALUES (24, 'Национальный исследовательский университет \"МЭИ\"');
INSERT INTO raex_dict(position, full_name)
VALUES (25, 'Дальневосточный федеральный университет');
INSERT INTO raex_dict(position, full_name)
VALUES (26,
        'Российский государственный университет нефти и газа (национальный исследовательский университет) имени И.М. Губкина');
INSERT INTO raex_dict(position, full_name)
VALUES (27,
        'Первый Санкт-Петербургский государственный медицинский университет имени академика И.П. Павлова Минздрава России');
INSERT INTO raex_dict(position, full_name)
VALUES (28, 'Южный федеральный университет');
INSERT INTO raex_dict(position, full_name)
VALUES (29, 'Всероссийская академия внешней торговли Министерства экономического развития РФ');
INSERT INTO raex_dict(position, full_name)
VALUES (30, 'Московский государственный лингвистический университет');
INSERT INTO raex_dict(position, full_name)
VALUES (31, 'Национальный исследовательский Нижегородский государственный университет имени Н.И. Лобачевского');
INSERT INTO raex_dict(position, full_name)
VALUES (32, 'Московский государственный юридический университет имени О.Е. Кутафина (МГЮА)');
INSERT INTO raex_dict(position, full_name)
VALUES (33, 'Санкт-Петербургский горный университет');
INSERT INTO raex_dict(position, full_name)
VALUES (34, 'Национальный исследовательский Московский государственный строительный университет');
INSERT INTO raex_dict(position, full_name)
VALUES (35, 'Московский педагогический государственный университет');
INSERT INTO raex_dict(position, full_name)
VALUES (36, 'Санкт-Петербургский государственный экономический университет');
INSERT INTO raex_dict(position, full_name)
VALUES (37, 'Российский государственный педагогический университет имени А. И. Герцена');
INSERT INTO raex_dict(position, full_name)
VALUES (38, 'Белгородский государственный национальный исследовательский университет');
INSERT INTO raex_dict(position, full_name)
VALUES (39, 'Санкт-Петербургский государственный электротехнический университет \"ЛЭТИ\" имени В.И. Ульянова (Ленина)');
INSERT INTO raex_dict(position, full_name)
VALUES (40, 'Северо-Восточный федеральный университет имени М.К. Аммосова');
INSERT INTO raex_dict(position, full_name)
VALUES (41, 'Казанский государственный медицинский университет Минздрава России');
INSERT INTO raex_dict(position, full_name)
VALUES (42, 'Новосибирский государственный технический университет');
INSERT INTO raex_dict(position, full_name)
VALUES (43, 'Казанский национальный исследовательский технический университет имени А.Н. Туполева-КАИ');
INSERT INTO raex_dict(position, full_name)
VALUES (44, 'Московский государственный медико-стоматологический университет имени А.И. Евдокимова Минздрава России');
INSERT INTO raex_dict(position, full_name)
VALUES (45, 'Воронежский государственный университет');
INSERT INTO raex_dict(position, full_name)
VALUES (46, 'Самарский национальный исследовательский университет имени академика С.П. Королёва');
INSERT INTO raex_dict(position, full_name)
VALUES (47, 'Российский химико-технологический университет имени Д.И. Менделеева');
INSERT INTO raex_dict(position, full_name)
VALUES (48, 'Российский государственный гуманитарный университет');
INSERT INTO raex_dict(position, full_name)
VALUES (49, 'Алтайский государственный университет');
INSERT INTO raex_dict(position, full_name)
VALUES (50, 'Самарский государственный медицинский университет Минздрава России');
INSERT INTO raex_dict(position, full_name)
VALUES (51, 'Санкт-Петербургский государственный архитектурно-строительный университет');
INSERT INTO raex_dict(position, full_name)
VALUES (52, 'МИРЭА - Российский технологический университет');
INSERT INTO raex_dict(position, full_name)
VALUES (53, 'Пермский национальный исследовательский политехнический университет');
INSERT INTO raex_dict(position, full_name)
VALUES (54, 'Московский государственный технологический университет \"СТАНКИН\"');
INSERT INTO raex_dict(position, full_name)
VALUES (55, 'Уфимский государственный нефтяной технический университет');
INSERT INTO raex_dict(position, full_name)
VALUES (56, 'Российский государственный аграрный университет – МСХА имени К.А. Тимирязева');
INSERT INTO raex_dict(position, full_name)
VALUES (57, 'Сибирский государственный медицинский университет Минздрава России');
INSERT INTO raex_dict(position, full_name)
VALUES (58, 'Белгородский государственный технологический университет имени В.Г. Шухова');
INSERT INTO raex_dict(position, full_name)
VALUES (59, 'Ставропольский государственный аграрный университет');
INSERT INTO raex_dict(position, full_name)
VALUES (60, 'Томский государственный университет систем управления и радиоэлектроники (ТУСУР)');
INSERT INTO raex_dict(position, full_name)
VALUES (61, 'Южно-Уральский государственный университет (национальный исследовательский университет)');
INSERT INTO raex_dict(position, full_name)
VALUES (62, 'Государственный университет \"Дубна\"');
INSERT INTO raex_dict(position, full_name)
VALUES (63, 'Южно-Российский государственный политехнический университет (НПИ) имени М.И. Платова');
INSERT INTO raex_dict(position, full_name)
VALUES (64,
        'Северо-Западный государственный медицинский университет имени И.И. Мечникова Министерства здравоохранения РФ');
INSERT INTO raex_dict(position, full_name)
VALUES (65, 'Московский государственный областной университет');
INSERT INTO raex_dict(position, full_name)
VALUES (66, 'Санкт-Петербургский государственный педиатрический медицинский университет Минздрава России');
INSERT INTO raex_dict(position, full_name)
VALUES (67, 'Самарский государственный технический университет');
INSERT INTO raex_dict(position, full_name)
VALUES (68, 'Курский государственный медицинский университет Министерства здравоохранения РФ');
INSERT INTO raex_dict(position, full_name)
VALUES (69, 'Московский городской педагогический университет');
INSERT INTO raex_dict(position, full_name)
VALUES (70, 'Национальный исследовательский университет «МИЭТ»');
INSERT INTO raex_dict(position, full_name)
VALUES (71, 'Технологический университет имени дважды Героя Советского Союза, летчика-космонавта А.А. Леонова');
INSERT INTO raex_dict(position, full_name)
VALUES (72, 'Петрозаводский государственный университет');
INSERT INTO raex_dict(position, full_name)
VALUES (73, 'Донской государственный технический университет');
INSERT INTO raex_dict(position, full_name)
VALUES (74, 'Северо-Кавказский федеральный университет');
INSERT INTO raex_dict(position, full_name)
VALUES (75, 'Тюменский государственный университет');
INSERT INTO raex_dict(position, full_name)
VALUES (76, 'Волгоградский государственный университет');
INSERT INTO raex_dict(position, full_name)
VALUES (77, 'Балтийский федеральный университет имени Иммануила Канта');
INSERT INTO raex_dict(position, full_name)
VALUES (78, 'Томский государственный архитектурно-строительный университет');
INSERT INTO raex_dict(position, full_name)
VALUES (79,
        'Рязанский государственный медицинский университет имени академика И.П. Павлова Министерства здравоохранения РФ');
INSERT INTO raex_dict(position, full_name)
VALUES (80, 'Воронежский государственный медицинский университет имени Н.Н. Бурденко Минздрава России');
INSERT INTO raex_dict(position, full_name)
VALUES (81, 'Саратовский национальный исследовательский государственный университет имени Н.Г. Чернышевского');
INSERT INTO raex_dict(position, full_name)
VALUES (82, 'Национальный исследовательский Мордовский государственный университет имени Н.П. Огарёва');
INSERT INTO raex_dict(position, full_name)
VALUES (83, 'Казанский национальный исследовательский технологический университет');
INSERT INTO raex_dict(position, full_name)
VALUES (84, 'Уральский государственный медицинский университет Министерства здравоохранения РФ');
INSERT INTO raex_dict(position, full_name)
VALUES (85, 'Государственный университет управления');
INSERT INTO raex_dict(position, full_name)
VALUES (86, 'Северный (Арктический) федеральный университет имени М.В. Ломоносова');
INSERT INTO raex_dict(position, full_name)
VALUES (87, 'Курский государственный университет');
INSERT INTO raex_dict(position, full_name)
VALUES (88, 'Государственный гуманитарно-технологический университет');
INSERT INTO raex_dict(position, full_name)
VALUES (89, 'Тюменский индустриальный университет');
INSERT INTO raex_dict(position, full_name)
VALUES (90, 'Кабардино-Балкарский государственный университет имени Х.М. Бербекова');
INSERT INTO raex_dict(position, full_name)
VALUES (91, 'Башкирский государственный медицинский университет Минздрава России');
INSERT INTO raex_dict(position, full_name)
VALUES (92, 'Государственный социально-гуманитарный университет');
INSERT INTO raex_dict(position, full_name)
VALUES (93, 'Волгоградский государственный технический университет');
INSERT INTO raex_dict(position, full_name)
VALUES (94, 'Воронежский государственный технический университет');
INSERT INTO raex_dict(position, full_name)
VALUES (95, 'Тюменский государственный медицинский университет Минздрава России');
INSERT INTO raex_dict(position, full_name)
VALUES (96, 'Тихоокеанский государственный университет');
INSERT INTO raex_dict(position, full_name)
VALUES (97, 'Российский новый университет (РосНОУ)');
INSERT INTO raex_dict(position, full_name)
VALUES (98, 'Юго-Западный государственный университет');
INSERT INTO raex_dict(position, full_name)
VALUES (99, 'Московский политехнический университет');
INSERT INTO raex_dict(position, full_name)
VALUES (100, 'Алтайский государственный технический университет имени И.И. Ползунова');