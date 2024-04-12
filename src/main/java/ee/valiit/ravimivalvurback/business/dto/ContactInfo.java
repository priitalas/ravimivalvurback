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
public class ContactInfo implements Serializable {
    private Integer userId;
    @NotNull
    @Size(max = 255)
    private String firstName;
    private String lastName;
    private String email;
}