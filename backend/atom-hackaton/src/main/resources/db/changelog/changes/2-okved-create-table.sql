CREATE TABLE IF NOT EXISTS okved(
    code character varying PRIMARY KEY,
    name character varying
);

INSERT INTO okved(code, name) VALUES ('85.1',	'Образование общее');
INSERT INTO okved(code, name) VALUES ('85.11', 'Образование дошкольное');
INSERT INTO okved(code, name) VALUES ('85.12', 'Образование начальное общее');
INSERT INTO okved(code, name) VALUES ('85.13', 'Образование основное общее');
INSERT INTO okved(code, name) VALUES ('85.14', 'Образование среднее общее');
INSERT INTO okved(code, name) VALUES ('85.2',	'Образование профессиональное');
INSERT INTO okved(code, name) VALUES ('85.21', 'Образование профессиональное среднее');
INSERT INTO okved(code, name) VALUES ('85.22', 'Образование высшее');
INSERT INTO okved(code, name) VALUES ('85.22.1', 'Образование высшее - бакалавриат');
INSERT INTO okved(code, name) VALUES ('85.22.2', 'Образование высшее - специалитет');
INSERT INTO okved(code, name) VALUES ('85.22.3', 'Образование высшее - магистратура');
INSERT INTO okved(code, name) VALUES ('85.23', 'Подготовка кадров высшей квалификации');
INSERT INTO okved(code, name) VALUES ('85.3', 'Обучение профессиональное');
INSERT INTO okved(code, name) VALUES ('85.30', 'Обучение профессиональное');
INSERT INTO okved(code, name) VALUES ('85.4',	'Образование дополнительное');
INSERT INTO okved(code, name) VALUES ('85.41', 'Образование дополнительное детей и взрослых');
INSERT INTO okved(code, name) VALUES ('85.41.1', 'Образование в области спорта и отдыха');
INSERT INTO okved(code, name) VALUES ('85.41.2', 'Образование в области культуры');
INSERT INTO okved(code, name) VALUES ('85.41.9', 'Образование дополнительное детей и взрослых прочее, не включенное в другие группировки');
INSERT INTO okved(code, name) VALUES ('85.41.91',	'Деятельность по организации отдыха детей и их оздоровления');
INSERT INTO okved(code, name) VALUES ('85.42', 'Образование профессиональное дополнительное');
INSERT INTO okved(code, name) VALUES ('85.42.1', 'Деятельность школ подготовки водителей автотранспортных средств');
INSERT INTO okved(code, name) VALUES ('85.42.2', 'Деятельность школ обучения вождению воздушных и плавательных судов, без выдачи коммерческих сертификатов и лицензий');
INSERT INTO okved(code, name) VALUES ('85.42.9', 'Деятельность по дополнительному профессиональному образованию прочая, не включенная в другие группировки');
