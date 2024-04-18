package ee.valiit.ravimivalvurback.business.medication.medicationplan.dto;

import ee.valiit.ravimivalvurback.domain.medicationplan.MedicationPlan;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link MedicationPlan}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicationPlanInfo implements Serializable {
    private Integer patientId;
    private String medicationPlanStatus;
    private Integer medicationId;
    private String medicationUnitName;
    private String medicationName;
    private String medicationNote;
    private String medicationDescription;
    private String medicationStatus;
    @NotNull
    private Integer frequency;
    @NotNull
    private LocalDate periodStart;
    @NotNull
    private LocalDate periodEnd;
   // @NotNull
   // private String status;
}