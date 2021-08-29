package ru.atom.hachaton.model.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("legal_org")
public class LegalOrganization {
    @Id
    private Long id;
    private String licensedProgramSupplementFk;
    private String licensedProgramEduLevelName;
    private String licenceProgramSysGuid;
    private String licensedProgramName;
    private String licensedProgramCode;
    private String licenseEduProgramType;
    private String licensedProgramQualName;
    private String supplementLicenseFK;
    private String supplementOrgName;
    private String supplementSysGuid;
    private String schoolGuid;
    private String statusName;
    private String schoolName;
    private String supplementNumber;
    private String lawAddress;
    private String shortName;
    private String numLicDoc;
    private String dateLicDoc;
    private String licenseSysGuid;
    private String licenseSchoolGuid;
    private String licenseStatusName;
    private String licenseOrgName;
    private String licenseDateEnd;
    private String licenseDateLicDoc;
    private String licenseSchoolName;
    private String licenseInn;
    private String licenseRegNum;
    private String licenseOgrn;
    private String licenseLawAddress;
    private String licenseShortName;
    private String licenseSchoolTypeName;
}
