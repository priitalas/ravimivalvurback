package ee.valiit.ravimivalvurback.domain.user.contact;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.Nullable;

public interface ContactRepository extends JpaRepository<Contact, Integer> {

    @Query("""
            select c from Contact c
            where c.user.id = :id and c.firstName = :firstName and c.lastName = :lastName and c.email = :email""")
    Contact findUserByContact(Integer id, String firstName, String lastName, @Nullable String email);
}