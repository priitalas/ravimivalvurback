package ee.valiit.ravimivalvurback.business.patient.dto;

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
public class PatientInfo implements Serializable {
    private Integer roleId;

}