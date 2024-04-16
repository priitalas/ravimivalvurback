package ee.valiit.ravimivalvurback.domain.user.role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RoleRepository extends JpaRepository<Role, Integer> {

    @Query("select r from Role r where r.id = :id and r.name = :name")
    Role findUserRole(Integer id, String name);
}