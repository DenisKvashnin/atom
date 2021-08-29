CREATE TABLE IF NOT EXISTS org_location(
    id bigint PRIMARY KEY,
    org_id bigint,
    lat real,
    lon real
);

CREATE SEQUENCE org_location_seq;

ALTER SEQUENCE org_location_seq OWNED BY org_location.id;

ALTER TABLE org_location
    ALTER COLUMN id SET DEFAULT nextval('org_location_seq'::regclass);