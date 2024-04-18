package ee.valiit.ravimivalvurback.domain.medicationplan;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MedicationPlanRepository extends JpaRepository<MedicationPlan, Integer> {

    @Query("select m from MedicationPlan m where m.patient.id = :patientId")
    List<MedicationPlan> findMedicationPlanBy(Integer patientId);
}