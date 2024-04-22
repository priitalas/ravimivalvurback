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
public class PatientMedicationPlan implements Serializable {
    private Integer medicationPlanId;
    private Integer medicationId;
    private String medicationName;
    private String medicationImageData;
    @NotNull
    private BigDecimal quantity;
    private String medicationUnitName;
    private String medicationNote;
    private String timeSlotStatus;
}