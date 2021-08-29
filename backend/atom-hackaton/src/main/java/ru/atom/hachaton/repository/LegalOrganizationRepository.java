package ru.atom.hachaton.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.atom.hachaton.model.dto.out.Program;
import ru.atom.hachaton.model.entity.LegalOrganization;

import java.util.List;

public interface LegalOrganizationRepository extends CrudRepository<LegalOrganization, Long> {

    @Query("SELECT * FROM legal_org lo " +
            "WHERE \n" +
            "  lo.license_inn = :inn AND \n" +
            "  UPPER(lo.license_status_name) = UPPER('Действует')")
    List<LegalOrganization> findByInn(@Param("inn") String inn);

    @Query("SELECT \n" +
            "\t lo.* \n" +
            "FROM legal_org lo \n" +
            "WHERE \n" +
            "  lo.supplement_license_fk = :supplementlicensefk \n" +
            " AND UPPER(lo.status_name) = UPPER('Действует')\n" +
            " AND supplement_number LIKE '1%'")
    List<LegalOrganization> finBySupplementLicenseFk(@Param("supplementlicensefk") String programSupplementFk);

    @Query(" SELECT \n" +
            "      lo.license_edu_program_type,\n" +
            "\t\tlo.licensed_program_code,\n" +
            "   lo.licensed_program_name,\n" +
            "   lo.licensed_program_qual_name\n" +
            "   \n" +
            "FROM legal_org lo \n" +
            "WHERE \n" +
            "  lo.licensed_program_supplement_fk = :supplement\n")
    List<Program> findLicensedProgramSupplementFk(@Param("supplement") String supplementLicenseFK);

    @Query("SELECT \n" +
            "   \n" +
            "   lo.license_edu_program_type,\n" +
            "   lo.licensed_program_code,\n" +
            "   lo.licensed_program_name,\n" +
            "   lo.licensed_program_qual_name" +
            "   \n" +
            "FROM legal_org lo \n" +
            "WHERE \n" +
            ":supplementsysguid = licensed_program_supplement_fk\n")
    List<Program> findProgramm(@Param("supplementsysguid") String supplementSysGuid);
}
