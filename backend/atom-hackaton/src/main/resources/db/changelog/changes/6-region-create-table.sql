CREATE TABLE IF NOT EXISTS region
(
    id         bigint PRIMARY KEY,
    name_ru    character varying,
    name_eng   character varying,
    path_image character varying
);

CREATE SEQUENCE region_seq;

ALTER SEQUENCE region_seq OWNED BY region.id;

ALTER TABLE region
    ALTER COLUMN id SET DEFAULT nextval('region_seq'::regclass);

INSERT INTO region(name_ru, name_eng, path_image) VALUES ('Ростовская область','1.svg','Rostov');
INSERT INTO region(name_ru, name_eng, path_image) VALUES ('Республика Ингушетия','2.svg','Ingush');
INSERT INTO region(name_ru, name_eng, path_image) VALUES ('Архангельская область','3.svg','Arkhangel''sk');
INSERT INTO region(name_ru, name_eng, path_image) VALUES ('Чеченская республика','4.svg','Chechnya');
INSERT INTO region(name_ru, name_eng, path_image) VALUES ('Оренбургская область','5.svg','Orenburg');
INSERT INTO region(name_ru, name_eng, path_image) VALUES ('Сахалинская область','6.svg','Sakhalin');
INSERT INTO region(name_ru, name_eng, path_image) VALUES ('Орловская область','7.svg','Orel');
INSERT INTO region(name_ru, name_eng, path_image) VALUES ('Республика Марий Эл','8.svg','Mariy-El');
INSERT INTO region(name_ru, name_eng, path_image) VALUES ('Карачаево-Черкесская республика','9.svg','Karachay-Cherkess');
INSERT INTO region(name_ru, name_eng, path_image) VALUES ('Севастополь','10.svg','Sevastopol');
INSERT INTO region(name_ru, name_eng, path_image) VALUES ('Республика Башкортостан','11.svg','Bashkortostan');
INSERT INTO region(name_ru, name_eng, path_image) VALUES ('Костромская область','12.svg','Kostroma');
INSERT INTO region(name_ru, name_eng, path_image) VALUES ('Самарская область','13.svg','Samara');
INSERT INTO region(name_ru, name_eng, path_image) VALUES ('Чувашская республика','14.svg','Chuvash');
INSERT INTO region(name_ru, name_eng, path_image) VALUES ('Липецкая область','15.svg','Lipetsk');
INSERT INTO region(name_ru, name_eng, path_image) VALUES ('Алтайский край','16.svg','Altay');
INSERT INTO region(name_ru, name_eng, path_image) VALUES ('Республика Дагестан','17.svg','Dagestan');
INSERT INTO region(name_ru, name_eng, path_image) VALUES ('Белгородская область','18.svg','Belgorod');
INSERT INTO region(name_ru, name_eng, path_image) VALUES ('Кабардино-Балкарская республика','19.svg','Kabardin-Balkar');
INSERT INTO region(name_ru, name_eng, path_image) VALUES ('Воронежская область','20.svg','Voronezh');
INSERT INTO region(name_ru, name_eng, path_image) VALUES ('Челябинская область','21.svg','Chelyabinsk');
INSERT INTO region(name_ru, name_eng, path_image) VALUES ('Камчатский край','22.svg','Kamchatka');
INSERT INTO region(name_ru, name_eng, path_image) VALUES ('Кемеровская область','23.svg','Kemerovo');
INSERT INTO region(name_ru, name_eng, path_image) VALUES ('Республика Татарстан','24.svg','Tatarstan');
INSERT INTO region(name_ru, name_eng, path_image) VALUES ('Омская область','25.svg','Omsk');
INSERT INTO region(name_ru, name_eng, path_image) VALUES ('Краснодарский край','26.svg','Krasnodar');
INSERT INTO region(name_ru, name_eng, path_image) VALUES ('Новгородская область','27.svg','Novgorod');
INSERT INTO region(name_ru, name_eng, path_image) VALUES ('Удмуртская республика','28.svg','Udmurt');
INSERT INTO region(name_ru, name_eng, path_image) VALUES ('Приморский край','29.svg','Primor''ye');
INSERT INTO region(name_ru, name_eng, path_image) VALUES ('Республика Саха (Якутия)','30.svg','Sakha');
INSERT INTO region(name_ru, name_eng, path_image) VALUES ('Тюменская область','31.svg','Tyumen');
INSERT INTO region(name_ru, name_eng, path_image) VALUES ('Республика Алтай','32.svg','Gorno-Altay');
INSERT INTO region(name_ru, name_eng, path_image) VALUES ('Рязанская область','33.svg','Ryazan');
INSERT INTO region(name_ru, name_eng, path_image) VALUES ('Байконур','34.svg','');
INSERT INTO region(name_ru, name_eng, path_image) VALUES ('Магаданская область','35.svg','Maga Buryatdan');
INSERT INTO region(name_ru, name_eng, path_image) VALUES ('Республика Коми','36.svg','Komi');
INSERT INTO region(name_ru, name_eng, path_image) VALUES ('Смоленская область','37.svg','Smolensk');
INSERT INTO region(name_ru, name_eng, path_image) VALUES ('Республика Хакасия','38.svg','Khakass');
INSERT INTO region(name_ru, name_eng, path_image) VALUES ('Хабаровский край','39.svg','Khabarovsk');
INSERT INTO region(name_ru, name_eng, path_image) VALUES ('Свердловская область','40.svg','Sverdlovsk');
INSERT INTO region(name_ru, name_eng, path_image) VALUES ('Пензенская область','41.svg','Penza');
INSERT INTO region(name_ru, name_eng, path_image) VALUES ('Ямало-Ненецкий автономный округ','42.svg','Yamal-Nenets');
INSERT INTO region(name_ru, name_eng, path_image) VALUES ('Владимирская область','43.svg','Vladimir');
INSERT INTO region(name_ru, name_eng, path_image) VALUES ('Ненецкий автономный округ','44.svg','Nenets');
INSERT INTO region(name_ru, name_eng, path_image) VALUES ('Чукотский автономный округ','45.svg','Chukot');
INSERT INTO region(name_ru, name_eng, path_image) VALUES ('Новосибирская область','46.svg','Novosibirsk');
INSERT INTO region(name_ru, name_eng, path_image) VALUES ('Республика Тыва','47.svg','Tuva');
INSERT INTO region(name_ru, name_eng, path_image) VALUES ('Тульская область','48.svg','Tula');
INSERT INTO region(name_ru, name_eng, path_image) VALUES ('Брянская область','49.svg','Bryansk');
INSERT INTO region(name_ru, name_eng, path_image) VALUES ('Кировская область','50.svg','Kirov');
INSERT INTO region(name_ru, name_eng, path_image) VALUES ('Республика Бурятия','51.svg','Buryat');
INSERT INTO region(name_ru, name_eng, path_image) VALUES ('Ставропольский край','52.svg','Stavropol');
INSERT INTO region(name_ru, name_eng, path_image) VALUES ('Ярославская область','53.svg','Yaroslavl');
INSERT INTO region(name_ru, name_eng, path_image) VALUES ('Ивановская область','54.svg','Ivanovo');
INSERT INTO region(name_ru, name_eng, path_image) VALUES ('Ленинградская область','55.svg','Leningrad');
INSERT INTO region(name_ru, name_eng, path_image) VALUES ('Нижегородская область','56.svg','Nizhegorod');
INSERT INTO region(name_ru, name_eng, path_image) VALUES ('Республика Адыгея','57.svg','Adygey');
INSERT INTO region(name_ru, name_eng, path_image) VALUES ('Томская область','58.png','Tomsk');
INSERT INTO region(name_ru, name_eng, path_image) VALUES ('Республика Калмыкия','59.svg','Kalmyk');
INSERT INTO region(name_ru, name_eng, path_image) VALUES ('Республика Крым','60.svg','Crimea');
INSERT INTO region(name_ru, name_eng, path_image) VALUES ('Республика Северная Осетия - Алания','61.svg','North Ossetia');
INSERT INTO region(name_ru, name_eng, path_image) VALUES ('Красноярский край','62.svg','Krasnoyarsk');
INSERT INTO region(name_ru, name_eng, path_image) VALUES ('Пермский край','63.svg','Perm');
INSERT INTO region(name_ru, name_eng, path_image) VALUES ('Ханты-Мансийский автономный округ - Югра','64.svg','Khanty-Mansiy');
INSERT INTO region(name_ru, name_eng, path_image) VALUES ('Астраханская область','65.svg','Astrakhan');
INSERT INTO region(name_ru, name_eng, path_image) VALUES ('Республика Карелия','66.svg','Karelia');
INSERT INTO region(name_ru, name_eng, path_image) VALUES ('Калининградская область','67.svg','Kaliningrad');
INSERT INTO region(name_ru, name_eng, path_image) VALUES ('Тверская область','68.svg','Tver');
INSERT INTO region(name_ru, name_eng, path_image) VALUES ('Псковская область','69.svg','Pskov');
INSERT INTO region(name_ru, name_eng, path_image) VALUES ('Амурская область','70.svg','Amur');
INSERT INTO region(name_ru, name_eng, path_image) VALUES ('Саратовская область','71.svg','Saratov');
INSERT INTO region(name_ru, name_eng, path_image) VALUES ('Тамбовская область','72.svg','Tambov');
INSERT INTO region(name_ru, name_eng, path_image) VALUES ('Волгоградская область','73.svg','Volgograd');
INSERT INTO region(name_ru, name_eng, path_image) VALUES ('Вологодская область','74.svg','Vologda');
INSERT INTO region(name_ru, name_eng, path_image) VALUES ('Москва','75.svg','Moscow City');
INSERT INTO region(name_ru, name_eng, path_image) VALUES ('Санкт-Петербург','76.svg','City of St. Petersburg');
INSERT INTO region(name_ru, name_eng, path_image) VALUES ('Республика Мордовия','77.svg','Mordovia');
INSERT INTO region(name_ru, name_eng, path_image) VALUES ('Курганская область','78.svg','Kurgan');
INSERT INTO region(name_ru, name_eng, path_image) VALUES ('Еврейская автономная область','79.svg','Yevrey');
INSERT INTO region(name_ru, name_eng, path_image) VALUES ('Мурманская область','80.svg','Murmansk');
INSERT INTO region(name_ru, name_eng, path_image) VALUES ('Забайкальский край','81.svg','Zabaikalskiy Krai');
INSERT INTO region(name_ru, name_eng, path_image) VALUES ('Калужская область','82.svg','Kaluga');
INSERT INTO region(name_ru, name_eng, path_image) VALUES ('Иркутская область','83.svg','Irkutsk');
INSERT INTO region(name_ru, name_eng, path_image) VALUES ('Ульяновская область','84.svg','Ul''yanovsk');
INSERT INTO region(name_ru, name_eng, path_image) VALUES ('Курская область','85.svg','Kursk');
INSERT INTO region(name_ru, name_eng, path_image) VALUES ('Московская область','86.svg','Moskva');
