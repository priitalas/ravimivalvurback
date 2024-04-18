package ee.valiit.ravimivalvurback.business.medication.medicationPlan;

import ee.valiit.ravimivalvurback.business.medication.medicationplan.dto.MedicationPlanInfo;
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
    public List<MedicationPlanInfo> findPatientMedicationPlans(@RequestParam Integer patientId) {
        List<MedicationPlanInfo> medicationPlans = medicationPlanService.findPatientMedicationPlans(patientId);
        return medicationPlans;


    }
}
