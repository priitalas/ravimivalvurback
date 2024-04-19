package ee.valiit.ravimivalvurback.domain.medicationplan;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

public interface LogbookRepository extends JpaRepository<Logbook, Integer> {

    @Query("""
            select (count(l) > 0) from Logbook l
            where l.medicationPlan.id = :medicationPlanId and l.medicationTime.id = :medicationTimeId and l.date = :date""")
    boolean medicationTimeInLogbookExists(Integer medicationPlanId, Integer medicationTimeId, LocalDate date);
}