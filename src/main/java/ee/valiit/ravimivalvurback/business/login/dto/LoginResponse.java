package ee.valiit.ravimivalvurback.business.login.dto;

import ee.valiit.ravimivalvurback.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link User}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse implements Serializable {
    private Integer userId;
    private String roleName;
    private String firstName;
    private String lastName;
    private String userStatus;
}