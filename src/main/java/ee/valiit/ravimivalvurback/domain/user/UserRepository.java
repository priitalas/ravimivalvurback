package ee.valiit.ravimivalvurback.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    // @Query("select u from User u where u.username = :usernamr and u.password = :password and u.status = :status")
    // Optional<User> findUserBy(String username, String password, String status);

    // @Query("select u from User u where u.username = :username and u.password = :password and u.status in ?3")
    // Optional<User> findByUsernameAndPasswordAndStatusIn(String username, String password, Collection<String> statuses);


    @Query("select u from User u where u.username = :username and u.password = :password and (u.status = 'A' or u.status = 'P')")
    Optional<User> findAuthorizedUser( String username, String password);
}