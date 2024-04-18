package ee.valiit.ravimivalvurback.domain.medication;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface MedicationRepository extends JpaRepository<Medication, Integer> {

    @Query("select (count(m) > 0) from Medication m where m.name = :medicationName")
    boolean medicineAlreadyExists(String medicationName);

    @Query("select m from Medication m where m.id = :medicationId")
    Medication findMedicationBy(Integer medicationId);


}