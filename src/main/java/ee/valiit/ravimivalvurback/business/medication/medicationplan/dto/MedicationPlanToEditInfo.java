package ee.valiit.ravimivalvurback.business.medication.medicationplan.dto;

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
public class MedicationPlanToEditInfo implements Serializable {
    private String medicationName;
    private LocalDate periodStart;
    private LocalDate periodEnd;
}