CREATE TABLE IF NOT EXISTS outer_org_type
(
    id  bigint PRIMARY KEY,
    description character varying
);

INSERT INTO outer_org_type(id, description) VALUES (1, 'Дошкольные образовательные организации');
INSERT INTO outer_org_type(id, description) VALUES (2, 'Высшее образование');
INSERT INTO outer_org_type(id, description) VALUES (3, 'ДПО');
INSERT INTO outer_org_type(id, description) VALUES (4, 'Цифровая образовательная организация');
INSERT INTO outer_org_type(id, description) VALUES (5, 'Среднее профессиональное образование');
INSERT INTO outer_org_type(id, description) VALUES (6, 'Дополнительное образование детей');
INSERT INTO outer_org_type(id, description) VALUES (7, 'Общее образование');
