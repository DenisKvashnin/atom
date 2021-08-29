CREATE TABLE IF NOT EXISTS okved_2_outer_type
(
    id          bigint,
    okved_code  character varying,
    org_type_id bigint
);

CREATE SEQUENCE okved_2_outer_type_seq;

ALTER SEQUENCE okved_2_outer_type_seq OWNED BY okved_2_outer_type.id;

ALTER TABLE okved_2_outer_type
    ALTER COLUMN id SET DEFAULT nextval('okved_2_outer_type_seq'::regclass);

INSERT INTO okved_2_outer_type(okved_code, org_type_id)
VALUES ('85.11', 1);
INSERT INTO okved_2_outer_type(okved_code, org_type_id)
VALUES ('85.12', 7);
INSERT INTO okved_2_outer_type(okved_code, org_type_id)
VALUES ('85.13', 7);
INSERT INTO okved_2_outer_type(okved_code, org_type_id)
VALUES ('85.14', 7);
INSERT INTO okved_2_outer_type(okved_code, org_type_id)
VALUES ('85.21', 5);
INSERT INTO okved_2_outer_type(okved_code, org_type_id)
VALUES ('85.22', 2);
INSERT INTO okved_2_outer_type(okved_code, org_type_id)
VALUES ('85.22.1', 2);
INSERT INTO okved_2_outer_type(okved_code, org_type_id)
VALUES ('85.22.2', 2);
INSERT INTO okved_2_outer_type(okved_code, org_type_id)
VALUES ('85.22.3', 2);
INSERT INTO okved_2_outer_type(okved_code, org_type_id)
VALUES ('85.23', 2);
INSERT INTO okved_2_outer_type(okved_code, org_type_id)
VALUES ('85.3', 5);
INSERT INTO okved_2_outer_type(okved_code, org_type_id)
VALUES ('85.30', 5);
INSERT INTO okved_2_outer_type(okved_code, org_type_id)
VALUES ('85.4', 3);
INSERT INTO okved_2_outer_type(okved_code, org_type_id)
VALUES ('85.41', 3);
INSERT INTO okved_2_outer_type(okved_code, org_type_id)
VALUES ('85.41', 6);
INSERT INTO okved_2_outer_type(okved_code, org_type_id)
VALUES ('85.41.1', 3);
INSERT INTO okved_2_outer_type(okved_code, org_type_id)
VALUES ('85.41.1', 6);
INSERT INTO okved_2_outer_type(okved_code, org_type_id)
VALUES ('85.41.2', 3);
INSERT INTO okved_2_outer_type(okved_code, org_type_id)
VALUES ('85.41.9', 3);
INSERT INTO okved_2_outer_type(okved_code, org_type_id)
VALUES ('85.41.9', 6);
INSERT INTO okved_2_outer_type(okved_code, org_type_id)
VALUES ('85.41.91', 6);
INSERT INTO okved_2_outer_type(okved_code, org_type_id)
VALUES ('85.42', 3);
INSERT INTO okved_2_outer_type(okved_code, org_type_id)
VALUES ('85.42.1', 3);
INSERT INTO okved_2_outer_type(okved_code, org_type_id)
VALUES ('85.42.2', 3);
INSERT INTO okved_2_outer_type(okved_code, org_type_id)
VALUES ('85.42.9', 3);

