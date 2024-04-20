package ee.valiit.ravimivalvurback.business.patient.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link ee.valiit.ravimivalvurback.domain.user.contact.Contact}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientNotInDoctorListInfo implements Serializable {
    private Integer patientId;
    @NotNull
    @Size(max = 255)
    private String firstName;
    @NotNull
    @Size(max = 255)
    private String lastName;
}