CREATE TABLE IF NOT EXISTS  legal_org (
id bigint PRIMARY KEY,
licensed_program_supplement_fk character varying,
licensed_program_edu_level_name character varying,
licence_program_sys_guid character varying,
licensed_program_name character varying,
licensed_program_code character varying,
license_edu_program_type character varying,
licensed_program_qual_name character varying,
supplement_license_fK character varying,
supplement_org_name character varying,
supplement_sys_guid character varying,
school_guid character varying,
status_name character varying,
school_name character varying,
supplement_number character varying,
law_address character varying,
short_name character varying,
num_lic_doc character varying,
date_lic_doc character varying,
license_sys_guid character varying,
license_school_guid character varying,
license_status_name character varying,
license_org_name character varying,
license_date_end character varying,
license_date_lic_doc character varying,
license_school_name character varying,
license_inn character varying,
license_reg_num character varying,
license_ogrn character varying,
license_law_address character varying,
license_short_name character varying,
license_school_type_name character varying
);

CREATE SEQUENCE legal_org_seq;

ALTER SEQUENCE legal_org_seq OWNED BY legal_org.id;

ALTER TABLE legal_org
    ALTER COLUMN id SET DEFAULT nextval('legal_org_seq'::regclass);