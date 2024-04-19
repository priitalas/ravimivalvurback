package ee.valiit.ravimivalvurback.business.medication.medicationplan;

import ee.valiit.ravimivalvurback.business.medication.medicationplan.dto.DoctorPatientMedicationPlan;
import ee.valiit.ravimivalvurback.business.medication.medicationplan.dto.PatientMedicationPlan;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor

public class MedicationPlanController {
    private MedicationPlanService medicationPlanService;

    @GetMapping("/medication-plans/doctor/patient")
    public List<DoctorPatientMedicationPlan> findDoctorPatientMedicationPlans(@RequestParam Integer patientId) {
        List<DoctorPatientMedicationPlan> medicationPlans = medicationPlanService.findDoctorPatientMedicationPlans(patientId);
        return medicationPlans;
    }
    @GetMapping("/medication-plans/patient")
    public List<PatientMedicationPlan> findPatientMedicationPlans(@RequestParam Integer patientId) {
        List<PatientMedicationPlan> patientMedicationPlans = medicationPlanService.findPatientMedicationPlans(patientId);
        return patientMedicationPlans;
    }


}
