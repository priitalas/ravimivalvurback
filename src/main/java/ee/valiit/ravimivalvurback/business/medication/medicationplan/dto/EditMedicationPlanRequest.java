package ee.valiit.ravimivalvurback.business.medication.medicationplan.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link ee.valiit.ravimivalvurback.domain.medicationplan.MedicationPlan}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EditMedicationPlanRequest implements Serializable {
    private Integer medicationPlanId;
    @NotNull
    private LocalDate periodStart;
    @NotNull
    private LocalDate periodEnd;
}