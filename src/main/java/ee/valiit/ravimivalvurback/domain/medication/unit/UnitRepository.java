package ee.valiit.ravimivalvurback.domain.medication.unit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UnitRepository extends JpaRepository<Unit, Integer> {

    @Query("select (count(u) > 0) from Unit u where u.name = :unitName")
    boolean unitExists(String unitName);


}