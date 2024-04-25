package ee.valiit.ravimivalvurback.business.medication.medicationplan.dto;

import jakarta.validation.constraints.NotNull;
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
public class MedicationTimesInfo implements Serializable {
    private Integer timeslotId;
    @NotNull
    private LocalTime slotStart;
    @NotNull
    private LocalTime slotEnd;
    @NotNull
    private BigDecimal quantity;
}