package ee.valiit.ravimivalvurback.business.medication.medicationplan.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * DTO for {@link ee.valiit.ravimivalvurback.domain.medicationplan.MedicationPlan}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewMedicationPlanInfo implements Serializable {
    private Integer patientId;
    private Integer medicationId;
    private Integer medicationUnitId;
    @NotNull
    private Integer frequency;
    @NotNull
    private BigDecimal quantity;
    @NotNull
    private LocalDate periodStart;
    @NotNull
    private LocalDate periodEnd;
}