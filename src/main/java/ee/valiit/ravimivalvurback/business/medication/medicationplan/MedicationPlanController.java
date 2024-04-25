package ee.valiit.ravimivalvurback.business.medication.medicationplan;

import ee.valiit.ravimivalvurback.business.medication.medicationplan.dto.MedicationPlanInfo;
import ee.valiit.ravimivalvurback.business.medication.medicationplan.dto.NewMedicationPlanInfo;
import ee.valiit.ravimivalvurback.business.medication.medicationplan.dto.PatientMedicationPlan;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class MedicationPlanController {
    private MedicationPlanService medicationPlanService;

    @GetMapping("/medication-plans/patient/to-take-now")
    @Operation(summary = "Toob vastavalt patientId-le ära need ravimiplaanid, mida peab teenuse käivitamise hetke aja järgi patisent manustama")
    public List<PatientMedicationPlan> findPatientMedicationsToTakeNow(@RequestParam Integer patientId) {
        List<PatientMedicationPlan> patientMedicationPlans = medicationPlanService.findPatientMedicationsToTakeNow(patientId);
        return patientMedicationPlans;
    }




    @GetMapping("/medication-plans/patient/{patientId}")
    @Operation(summary = "Toob vastavalt patientId-le ära kõik sellele patsiendile määratud raviplaanid")
    public List<MedicationPlanInfo> findPatientMedicationPlans(@PathVariable Integer patientId) {
        List<MedicationPlanInfo> medicationPlans = medicationPlanService.findPatientMedicationPlans(patientId);
        return medicationPlans;
    }



//    @PostMapping("/medication-plans/patient/")
//    @Operation(summary = "Lisab patsiendile uue ravikuuri")
//    public Integer addNewMedicationPlan(@RequestBody NewMedicationPlanInfo newMedicationPlanInfo) {
//        return medicationPlanService.addNewMedicationPlan(newMedicationPlanInfo);
//    }

    @GetMapping("/medication-plans/patient/time-slot")
    @Operation(summary = "Toob ära ravikuuri päevase võtmise ajad ja doosid")
    public List<MedicationTimesInfo> findMedicationPlanTimeslots(@RequestParam Integer medicationPlanId) {
        return medicationPlanService.findMedicationPlanTimeslots(medicationPlanId);
    }


}
