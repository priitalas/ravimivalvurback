package ee.valiit.ravimivalvurback.business.medication.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link ee.valiit.ravimivalvurback.domain.medication.Medication}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicationInfoExtended implements Serializable {
    private String medicationName;
    private String medicationNote;
    private String medicationDescription;
    private String medicationImageData;
}