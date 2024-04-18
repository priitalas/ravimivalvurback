package ee.valiit.ravimivalvurback.business.medication.medicationplan;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor

public class MedicationPlanController {
    private MedicationPlanService medicationPlanService;

    @GetMapping("/medication-plans/patient/{patientId}")
    public void findPatientMedicationPlans(@RequestParam Integer patientId) {
        medicationPlanService.findPatientMedicationPlans(patientId);
    }
}
