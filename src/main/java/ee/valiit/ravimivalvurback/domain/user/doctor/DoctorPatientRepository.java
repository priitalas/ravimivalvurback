package ee.valiit.ravimivalvurback.domain.user.doctor;

import ee.valiit.ravimivalvurback.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface DoctorPatientRepository extends JpaRepository<DoctorPatient, Integer> {

    @Query("select d from DoctorPatient d where d.doctor.id = :doctorId order by d.patient.status")
    List<DoctorPatient> findPatientsBy(Integer doctorId);

    @Query("select d.patient.id from DoctorPatient d where d.doctor.id = :doctorId")
    List<Integer> findPatientsIdBy(Integer doctorId);

    @Query("select d from DoctorPatient d where d.doctor.id = :doctorId and d.patient.id = :patientId")
    DoctorPatient findPatientBy(Integer doctorId, Integer patientId);

    @Transactional
    @Modifying
    @Query("delete from DoctorPatient d where d.doctor.id = :doctorId and d.patient.id = :patientId")
    void deleteFromTableBy(Integer doctorId, Integer patientId);


}