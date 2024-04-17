package ee.valiit.ravimivalvurback.domain.user.contact;

import ee.valiit.ravimivalvurback.domain.user.doctor.Patients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, Integer> {

    @Query("select c from Contact c where c.user.id = :patientId")
    List<Contact> findContactsBy(List<Patients> patientId);
}