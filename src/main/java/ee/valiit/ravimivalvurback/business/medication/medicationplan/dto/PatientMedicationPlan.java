package ee.valiit.ravimivalvurback.business.medication.medicationplan.dto;

import ee.valiit.ravimivalvurback.domain.medicationplan.MedicationPlan;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

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
    private String medicationUnitName;
    private String medicationNote;
    private Boolean itsTimeToTakeMedication;
    private Integer medicationTimeId;
    private BigDecimal quantity;
    private String medicationImageData;
}