CREATE INDEX idx_organization_name ON organization(name);
CREATE INDEX idx_organization_address ON organization(UPPER(replace(address, ' ', '')));
