package ee.valiit.ravimivalvurback.business.medication.medicationplan;

import ee.valiit.ravimivalvurback.business.medication.medicationplan.dto.MedicationPlanInfo;
import ee.valiit.ravimivalvurback.business.medication.medicationplan.dto.PatientMedicationPlan;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor

public class MedicationPlanController {
    private MedicationPlanService medicationPlanService;

    @GetMapping("/medication-plans/patient")
    public List<PatientMedicationPlan> findTodaysPatientMedicationPlans(@RequestParam Integer patientId) {
        List<PatientMedicationPlan> patientMedicationPlans = medicationPlanService.findTodaysPatientMedicationPlans(patientId);
        return patientMedicationPlans;
    }

    @GetMapping("/medication-plans/patient/{patientId}")
    @Operation(summary = "Toob vastavalt patientId-le ära kõik sellele patsiendile määratud raviplaanid")
    public List<MedicationPlanInfo> findPatientMedicationPlans(@RequestParam Integer patientId) {
        List<MedicationPlanInfo> medicationPlans = medicationPlanService.findPatientMedicationPlans(patientId);
        return medicationPlans;
    }
}
