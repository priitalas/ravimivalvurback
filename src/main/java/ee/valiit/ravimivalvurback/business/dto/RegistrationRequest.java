package ee.valiit.ravimivalvurback.business.dto;

import ee.valiit.ravimivalvurback.domain.user.Contact;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link Contact}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationRequest implements Serializable {
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String password;
    private Integer roleId;

}