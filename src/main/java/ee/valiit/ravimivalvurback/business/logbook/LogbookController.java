package ee.valiit.ravimivalvurback.business.logbook;

import ee.valiit.ravimivalvurback.business.logbook.dto.LogbookInfo;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class LogbookController {

    private LogbookService logbookService;
    @PostMapping("/logbook")
    @Operation(summary = "Lisab logiraamatusse patsiendi ravimi manustamise kande")
    public void logPatientTakesMedication(@RequestParam Integer medicationPlanId, @RequestParam Integer medicationTimeId) {
        logbookService.logPatientTakesMedication(medicationPlanId, medicationTimeId);
    }
    @GetMapping("/logbook/patient")
    @Operation(summary = "Toob patientId järgi ära patsiendi ravimivõtmise logi")
    public List<LogbookInfo> getPatientMedicationLogbook(@RequestParam Integer patientId) {
        return logbookService.getPatientMedicationLogbook(patientId);
    }
}
