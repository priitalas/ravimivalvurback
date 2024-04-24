package ee.valiit.ravimivalvurback.business.logbook;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class LogbookController {

    private LogbookService logbookService;
    @PostMapping("/logbook")
    @Operation(summary = "Lisab logiraamatusse patsiendi ravimi manustamise kande")
    public void logPatientTakesMedication(@RequestParam Integer medicationPlanId, @RequestParam Integer medicationTimeId) {
        logbookService.logPatientTakesMedication(medicationPlanId, medicationTimeId);
    }

}
