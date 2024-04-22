package ee.valiit.ravimivalvurback.business.medication.medicationplan.dto;

import ee.valiit.ravimivalvurback.domain.medicationplan.MedicationPlan;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * DTO for {@link MedicationPlan}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicationPlanInfo implements Serializable {
    private Integer medicationPlanId;
    private String medicationPlanStatus;
    private String medicationName;
    private String medicationUnitName;
    @NotNull
    private Integer frequency;
    @NotNull
    private BigDecimal quantity;
    @NotNull
    private LocalDate periodStart;
    @NotNull
    private LocalDate periodEnd;

}
