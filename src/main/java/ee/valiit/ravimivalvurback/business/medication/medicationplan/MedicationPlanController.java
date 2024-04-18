package ee.valiit.ravimivalvurback.business.medication.medicationplan;

import ee.valiit.ravimivalvurback.domain.medicationplan.MedicationPlan;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor

public class MedicationPlanController {
    private MedicationPlanService medicationPlanService;

    @GetMapping("/medication-plans/patient/{patientId}")
    public List<MedicationPlan> findPatientMedicationPlans(@RequestParam Integer patientId) {
        List<MedicationPlan> medicationPlans = medicationPlanService.findPatientMedicationPlans(patientId);
        return medicationPlans;


    }
}
