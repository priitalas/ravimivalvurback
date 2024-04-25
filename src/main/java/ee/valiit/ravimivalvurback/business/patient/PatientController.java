package ee.valiit.ravimivalvurback.business.patient;

import ee.valiit.ravimivalvurback.business.medication.medicationplan.MedicationPlanService;
import ee.valiit.ravimivalvurback.business.medication.medicationplan.dto.MedicationPlanInfo;
import ee.valiit.ravimivalvurback.business.patient.dto.PatientDoctorInfo;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class PatientController {

    private MedicationPlanService medicationPlanService;
    private PatientService patientService;


    @GetMapping("/patient/medications")
    @Operation(summary = "Leiab patientId järgi andmed PatientView suure tabeli jaoks andmetabelitest medication_plan ja medication_time")
    public List<MedicationPlanInfo> findPatientMedicationPlans(@RequestParam Integer patientId) {
        List<MedicationPlanInfo> medicationPlans = medicationPlanService.findPatientMedicationPlans(patientId);
        return medicationPlans;
    }

    @GetMapping("/patient/doctor")
    @Operation(summary = "Kontrollib patientId järgi patsiendi staatust doctor_patient tabelis")
    public PatientDoctorInfo getPatientDoctorRelationshipRequest(@RequestParam Integer patientId) {
        return patientService.getPatientDoctorRelationshipRequest(patientId);
    }
    @PutMapping("/patient/doctor")
    @Operation(summary = "Patsient aksepteerib doctorPatientId abil arsti")
    public void patientDoctorRelationshipResponse(@RequestParam Integer doctorPatientId, @RequestParam Boolean hasAccepted) {
        patientService.patientDoctorRelationshipResponse(doctorPatientId, hasAccepted);
    }





//    public void findPatientMedications(@RequestParam Integer patientId) {
//        List<PatientMedicationInfo> patientMedicationInfos = patientService.findPatientMedications(patientId);
//        return patientMedicationInfos;

    }
//    @GetMapping("/patient")
//    public void findPatientMedications(@RequestParam Integer patientId) {
//        List<PatientInfo> patientMedications= patientService.findPatientMedications(patientId);
//        return patientMedications;
//    }

