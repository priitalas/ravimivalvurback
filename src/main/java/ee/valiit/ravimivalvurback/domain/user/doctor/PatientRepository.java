package ee.valiit.ravimivalvurback.domain.user.doctor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patients, Integer> {

    @Query("select d from Patients d where d.doctor.id = :doctorId and d.status = 'A'")
    List<Patients> findPatientsBy(Integer doctorId);

    @Query("select (count(d) < 1) from Patients d where d.doctor.id = :doctorId and d.status = 'A'")
    boolean noPatientsFound(Integer doctorId);
}