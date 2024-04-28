package ee.valiit.ravimivalvurback.business.medication.medicationplan;

import ee.valiit.ravimivalvurback.business.medication.medicationplan.dto.*;
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

    @PostMapping("/medication-plan/patient/take-medication-logbook")
    @Operation(summary = "Lisab logiraamatusse patsiendi ravimi manustamise kande")
    public void logPatientTakesMedication(@RequestParam Integer medicationPlanId, @RequestParam Integer medicationTimeId) {
        medicationPlanService.logPatientTakesMedication(medicationPlanId, medicationTimeId);
    }


    @GetMapping("/medication-plans/patient/{patientId}")
    @Operation(summary = "Toob vastavalt patientId-le ära kõik sellele patsiendile määratud raviplaanid")
    public List<MedicationPlanInfo> findPatientMedicationPlans(@PathVariable Integer patientId) {
        List<MedicationPlanInfo> medicationPlans = medicationPlanService.findPatientMedicationPlans(patientId);
        return medicationPlans;
    }

    @PostMapping("/medication-plans/patient/")
    @Operation(summary = "Lisab patsiendile uue ravikuuri")
    public void addNewMedicationPlan(@RequestBody NewMedicationPlanInfo newMedicationPlanInfo) {
        medicationPlanService.addNewMedicationPlan(newMedicationPlanInfo);
    }

    @GetMapping("/medication-plans/patient/new-plans/")
    @Operation(summary = "Toob vastavalt patsiendiId-le ära ravikuurid, millele ei ole veel võtmise aegu sisestatud (frequency=0)")
    public List<AddedMedicationPlansInfo> findPatientMedicationPlansWithoutTimeslots(@RequestParam Integer patientId) {
        List<AddedMedicationPlansInfo> addedMedicationPlans = medicationPlanService.findPatientMedicationPlansWithoutTimeslots(patientId);
        return addedMedicationPlans;
    }

    @PostMapping("/medication-plans/patient/time-slots")
    @Operation(summary = "Lisab ravikuurile päevase võtmise korra")
    public void addMedicationPlanTimeSlot(@RequestBody AddMedicationTimeRequest addMedicationTimeRequest) {
        medicationPlanService.addMedicationPlanTimeSlot(addMedicationTimeRequest);
    }

    @GetMapping("/medication-plans/patient/time-slot")
    @Operation(summary = "Toob ära ravikuuri päevase võtmise ajad ja doosid")
    public List<MedicationTimesInfo> findMedicationPlanTimeslots(@RequestParam Integer medicationPlanId) {
        return medicationPlanService.findMedicationPlanTimeslots(medicationPlanId);
    }

    @PutMapping("/medication-plan")
    @Operation(summary = "Muudab ravikuuri (uued algus- ja lõpuajad ja staatus aktiivseks)")
    public void editMedicationPlan(@RequestBody EditMedicationPlanRequest editMedicationPlanRequest) {
        medicationPlanService.editMedicationPlan(editMedicationPlanRequest);
    }

    @DeleteMapping("/medication-plan")
    @Operation(summary = "kustutab patsiendi ravikuuri (muudab staatuse mitteaktiivseks")
    public void deactivateMedicationPlan(@RequestParam Integer medicationPlanId) {
        medicationPlanService.deactivateMedicationPlan(medicationPlanId);
    }


}
