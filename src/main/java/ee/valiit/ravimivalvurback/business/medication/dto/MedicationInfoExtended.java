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
    @NotNull
    @Size(max = 255)
    private String name;
    @Size(max = 255)
    private String note;
    @NotNull
    @Size(max = 1000)
    private String description;
}