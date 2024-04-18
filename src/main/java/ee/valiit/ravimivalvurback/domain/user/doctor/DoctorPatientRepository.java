package ee.valiit.ravimivalvurback.domain.user.doctor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DoctorPatientRepository extends JpaRepository<DoctorPatient, Integer> {

    @Query("select d from DoctorPatient d where d.doctor.id = :doctorId and d.status = :status")
    List<DoctorPatient> findPatientsBy(Integer doctorId, String status);

}