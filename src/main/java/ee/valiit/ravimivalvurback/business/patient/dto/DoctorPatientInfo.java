package ee.valiit.ravimivalvurback.business.patient.dto;

import ee.valiit.ravimivalvurback.domain.user.doctor.DoctorPatient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link DoctorPatient}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorPatientInfo implements Serializable {
    private Integer patientId;
    private String firstName;
    private String lastName;
}