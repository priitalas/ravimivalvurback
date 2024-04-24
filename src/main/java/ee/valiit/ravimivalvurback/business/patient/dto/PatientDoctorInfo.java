package ee.valiit.ravimivalvurback.business.patient.dto;

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
public class PatientDoctorInfo implements Serializable {
    private Integer doctorPatientId;
    private String doctorFirstName;
    private String doctorLastName;
}