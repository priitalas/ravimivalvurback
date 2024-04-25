package ee.valiit.ravimivalvurback.business.patient;

import ee.valiit.ravimivalvurback.business.medication.medicationplan.MedicationPlanService;
import ee.valiit.ravimivalvurback.business.medication.medicationplan.dto.MedicationPlanInfo;
import ee.valiit.ravimivalvurback.business.patient.dto.PatientDoctorInfo;
import ee.valiit.ravimivalvurback.domain.medicationplan.Logbook;
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

    private PatientService patientService;


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




}


