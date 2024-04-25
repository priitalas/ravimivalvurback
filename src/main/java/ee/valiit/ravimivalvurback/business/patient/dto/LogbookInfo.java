package ee.valiit.ravimivalvurback.business.patient.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * DTO for {@link ee.valiit.ravimivalvurback.domain.medicationplan.Logbook}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LogbookInfo implements Serializable {
    private Integer patientLogbookId;
    private String medicationName;
    private LocalDate date;
    private LocalTime time;
}