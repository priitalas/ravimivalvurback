package ee.valiit.ravimivalvurback.business.registration.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link ee.valiit.ravimivalvurback.domain.user.User}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactChangeRequest implements Serializable {
    private Integer userId;
    private String username;
    private String password;
    private Integer roleId;
    @NotNull
    @Size(max = 255)
    private String firstName;
    @NotNull
    @Size(max = 255)
    private String lastName;
    @NotNull
    @Size(max = 255)
    private String email;
}