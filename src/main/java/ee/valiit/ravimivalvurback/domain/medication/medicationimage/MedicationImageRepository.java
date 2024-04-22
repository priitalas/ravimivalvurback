package ee.valiit.ravimivalvurback.domain.medication.medicationimage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MedicationImageRepository extends JpaRepository<MedicationImage, Integer> {

    @Query("select m from MedicationImage m where m.medication.id = :medicationId")
    MedicationImage getMedicationImageBy(Integer medicationId);
}