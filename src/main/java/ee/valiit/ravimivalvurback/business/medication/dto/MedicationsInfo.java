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
public class MedicationsInfo implements Serializable {
    private Integer medicationId;
    @NotNull
    @Size(max = 255)
    private String medicationName;
    private String unitName;

}