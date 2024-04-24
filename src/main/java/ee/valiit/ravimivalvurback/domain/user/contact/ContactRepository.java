package ee.valiit.ravimivalvurback.domain.user.contact;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, Integer> {


    @Query("select c from Contact c where c.user.id = :userId order by c.lastName")
    Contact findContactBy(Integer userId);

    @Query("select c from Contact c where c.user.role.name = :roleName order by c.lastName")
    List<Contact> findContactsByRole(String roleName);

    @Query("select c from Contact c where c.user.id = :userId")
    Contact getContactBy(Integer userId);


}