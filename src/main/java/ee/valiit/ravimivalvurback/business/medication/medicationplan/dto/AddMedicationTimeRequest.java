package ee.valiit.ravimivalvurback.business.medication.medicationplan.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalTime;

/**
 * DTO for {@link ee.valiit.ravimivalvurback.domain.medicationplan.MedicationTime}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddMedicationTimeRequest implements Serializable {
    private Integer medicationPlanId;
    private LocalTime slotStart;
    private LocalTime slotEnd;
    private BigDecimal quantity;
}