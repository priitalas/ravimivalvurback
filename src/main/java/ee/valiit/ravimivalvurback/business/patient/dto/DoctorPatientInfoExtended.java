package ee.valiit.ravimivalvurback.business.patient.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link ee.valiit.ravimivalvurback.domain.user.doctor.DoctorPatient}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorPatientInfoExtended implements Serializable {
    @NotNull
    private String status;
}