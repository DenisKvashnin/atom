CREATE TABLE IF NOT EXISTS atom_city_dict
(
    id          bigint PRIMARY KEY,
    city        character varying,
    region_code bigint
);

CREATE SEQUENCE atom_city_dict_seq;

ALTER SEQUENCE atom_city_dict_seq OWNED BY atom_city_dict.id;

ALTER TABLE atom_city_dict
    ALTER COLUMN id SET DEFAULT nextval('atom_city_dict_seq'::regclass);

INSERT INTO atom_city_dict(city, region_code)
VALUES ('Ангарск', '83');
INSERT INTO atom_city_dict(city, region_code)
VALUES ('Балаково', '71');
INSERT INTO atom_city_dict(city, region_code)
VALUES ('Билибино', '45');
INSERT INTO atom_city_dict(city, region_code)
VALUES ('Волгодонск', '1');
INSERT INTO atom_city_dict(city, region_code)
VALUES ('Глазов', '28');
INSERT INTO atom_city_dict(city, region_code)
VALUES ('Десногорск', '37');
INSERT INTO atom_city_dict(city, region_code)
VALUES ('Димитровград', '84');
INSERT INTO atom_city_dict(city, region_code)
VALUES ('Дубна', '86');
INSERT INTO atom_city_dict(city, region_code)
VALUES ('Железногорск', '62');
INSERT INTO atom_city_dict(city, region_code)
VALUES ('Заречный', '40');
INSERT INTO atom_city_dict(city, region_code)
VALUES ('Зеленогорск', '62');
INSERT INTO atom_city_dict(city, region_code)
VALUES ('Ковров', '43');
INSERT INTO atom_city_dict(city, region_code)
VALUES ('Краснокаменск', '81');
INSERT INTO atom_city_dict(city, region_code)
VALUES ('Курчатов', '85');
INSERT INTO atom_city_dict(city, region_code)
VALUES ('Лесной', '40');
INSERT INTO atom_city_dict(city, region_code)
VALUES ('Нововоронеж', '20');
INSERT INTO atom_city_dict(city, region_code)
VALUES ('Новоуральск', '40');
INSERT INTO atom_city_dict(city, region_code)
VALUES ('Обнинск', '82');
INSERT INTO atom_city_dict(city, region_code)
VALUES ('Озерск', '21');
INSERT INTO atom_city_dict(city, region_code)
VALUES ('Певек', '45');
INSERT INTO atom_city_dict(city, region_code)
VALUES ('Полярные Зори', '80');
INSERT INTO atom_city_dict(city, region_code)
VALUES ('Саров', '56');
INSERT INTO atom_city_dict(city, region_code)
VALUES ('Северск', '58');
INSERT INTO atom_city_dict(city, region_code)
VALUES ('Снежинск', '21');
INSERT INTO atom_city_dict(city, region_code)
VALUES ('Сосновый Бор', '55');
INSERT INTO atom_city_dict(city, region_code)
VALUES ('Трехгорный', '21');
INSERT INTO atom_city_dict(city, region_code)
VALUES ('Удомля', '68');
INSERT INTO atom_city_dict(city, region_code)
VALUES ('Электросталь', '86');
