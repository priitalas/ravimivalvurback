package ee.valiit.ravimivalvurback.domain.medication;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MedicationRepository extends JpaRepository<Medication, Integer> {


    @Query("select (count(m) > 0) from Medication m where m.name = :medicationName")
    boolean medicineAlreadyExists(String medicationName);
}