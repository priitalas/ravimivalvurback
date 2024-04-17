package ee.valiit.ravimivalvurback.domain.user.doctor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DoctorPatientRepository extends JpaRepository<DoctorPatient, Integer> {

    @Query("select d from DoctorPatient d where d.doctor.id = :doctorId")
    List<DoctorPatient> findPatientsBy(Integer doctorId);

    @Query("select (count(d) < 1) from DoctorPatient d where d.doctor.id = :doctorId")
    boolean noPatientsFound(Integer doctorId);

}