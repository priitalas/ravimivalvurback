package ee.valiit.ravimivalvurback.business.patient.dto;

import ee.valiit.ravimivalvurback.domain.user.doctor.Patients;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link Patients}
 */
@Value
public class DoctorPatientInfo implements Serializable {
    Integer patientId;
    String firstName;
    String lastName;
}