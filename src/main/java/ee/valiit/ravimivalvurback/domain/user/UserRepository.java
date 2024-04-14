package ee.valiit.ravimivalvurback.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {


    @Query("select u from User u where u.username = :username and u.password = :password and (u.status = 'A' or u.status = 'P')")
    Optional<User> findAuthorizedUser(String username, String password);



    @Query("select (count(u) > 0) from User u where u.username = :username")
    Boolean userNameExists(String username);

    @Query("select u from User u where u.id = :id and u.role.id = :roleId and u.role.name = :roleName")
    User findUserRole(Integer id, Integer roleId, String roleName);
}