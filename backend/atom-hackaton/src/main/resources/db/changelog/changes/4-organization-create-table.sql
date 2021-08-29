CREATE TABLE IF NOT EXISTS organization
(
    id         bigint PRIMARY KEY,
    okved      character varying,
    okved_name character varying,
    inn        character varying,
    address    character varying,
    i_index    character varying,
    site       character varying,
    city       character varying,
    timezone   character varying,
    status     character varying
);

CREATE SEQUENCE organization_seq;

ALTER SEQUENCE organization_seq OWNED BY organization.id;

ALTER TABLE organization
    ALTER COLUMN id SET DEFAULT nextval('organization_seq'::regclass);