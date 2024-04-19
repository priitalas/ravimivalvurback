package ee.valiit.ravimivalvurback.domain.medicationplan;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalTime;
import java.util.Optional;

public interface MedicationTimeRepository extends JpaRepository<MedicationTime, Integer> {


    @Query("""
            select m from MedicationTime m
            where m.medicationPlan.id = :medicationPlanId and m.slotStart <= :periodStart and m.slotEnd >= :periodEnd""")
    Optional<MedicationTime> findOptionalMedicationTime(Integer medicationPlanId, LocalTime periodStart, LocalTime periodEnd);
}