package ee.valiit.ravimivalvurback.business.doctor;

import ee.valiit.ravimivalvurback.business.doctor.dto.DoctorPatientInfo;
import ee.valiit.ravimivalvurback.business.patient.dto.PatientNotInDoctorListInfo;
import ee.valiit.ravimivalvurback.business.patient.dto.DoctorPatientInfo;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class DoctorController {
    private DoctorService doctorService;

    @GetMapping("doctor/patients")
    @Operation(summary = "Toob ära kõik arsti nimekirjas olevad patsiendid")
    public List<DoctorPatientInfo> findPatientsInDoctorsList(@RequestParam Integer doctorId) {
        List<DoctorPatientInfo> patientsInDoctorsList = doctorService.findPatientsInDoctorsList(doctorId);
        return patientsInDoctorsList;
    }

    @GetMapping("/doctor/patients/newpatient")
    @Operation(summary = "Toob ära andmebaasis olevad patsiendid, kes ei ole veel arsti nimekirjas")
    public List<PatientNotInDoctorListInfo> findPatientsNotInDoctorActiveList(@RequestParam Integer doctorId) {
        return doctorService.findPatientsNotInDoctorActiveList(doctorId);
    }

    @PostMapping("/doctor/patient")
    @Operation(summary = "Lisab patsiendi arsti nimekirja, märkides esialgu staatuseks 'pending'")
    public void postNewPatientToDoctorList(@RequestParam Integer patientId, Integer doctorId){
        doctorService.postNewPatientToDoctorList(patientId, doctorId);
    }

    @DeleteMapping("/doctor/patient")
    @Operation(summary = "Kustutab patsiendi arsti nimekirjast. Doctor-patient tabelist kustutatakse vastav rida")
    public void deletePatientFromDoctorList(@RequestParam Integer patientId, Integer doctorId){
        doctorService.deletePatientFromDoctorList(patientId, doctorId);

    }
}
