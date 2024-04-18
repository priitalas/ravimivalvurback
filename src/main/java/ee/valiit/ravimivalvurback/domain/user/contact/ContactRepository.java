package ee.valiit.ravimivalvurback.domain.user.contact;

import ee.valiit.ravimivalvurback.domain.user.doctor.DoctorPatient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, Integer> {


    @Query("select c from Contact c where c.user.id = :userId")
    Contact findContactBy(Integer userId);
}