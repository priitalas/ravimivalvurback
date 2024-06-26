package ee.valiit.ravimivalvurback.domain.medicationplan;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

public interface MedicationTimeRepository extends JpaRepository<MedicationTime, Integer> {


    @Query("""
            select m from MedicationTime m
            where m.medicationPlan.id = :medicationPlanId and m.slotStart <= :periodStart and m.slotEnd >= :periodEnd""")
    Optional<MedicationTime> findOptionalMedicationTime(Integer medicationPlanId, LocalTime periodStart, LocalTime periodEnd);

    @Query("select m from MedicationTime m where m.medicationPlan.id = :medicationPlanId")
    List<MedicationTime> findTimeSlotsBy(Integer medicationPlanId);

    @Query("select count(m) from MedicationTime m where m.medicationPlan.id = :medicationPlanId")
    Integer countTimeslotsBy(Integer medicationPlanId);

    @Transactional
    @Modifying
    @Query("delete from MedicationTime m where m.id = :timeslotId")
    void deleteFromTableBy(Integer timeslotId);

}