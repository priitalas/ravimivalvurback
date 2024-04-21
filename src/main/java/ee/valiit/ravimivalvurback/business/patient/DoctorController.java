package ee.valiit.ravimivalvurback.business.patient;

import ee.valiit.ravimivalvurback.business.patient.dto.PatientNotInDoctorListInfo;
import ee.valiit.ravimivalvurback.business.patient.dto.DoctorPatientInfo;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class DoctorController {
    private DoctorService doctorService;

    @GetMapping("doctor/patients")
    public List<DoctorPatientInfo> findPatientsInDoctorsList(@RequestParam Integer doctorId) {
        List<DoctorPatientInfo> patientsInDoctorsList = doctorService.findPatientsInDoctorsList(doctorId);
        return patientsInDoctorsList;
    }

    @GetMapping("/doctor/patients/newpatient")
    public List<PatientNotInDoctorListInfo> findPatientsNotInDoctorActiveList(@RequestParam Integer doctorId) {
        return doctorService.findPatientsNotInDoctorActiveList(doctorId);
    }

    @PostMapping("/doctor/patient")
    public void postNewPatientToDoctorList(@RequestParam Integer patientId, Integer doctorId){
        doctorService.postNewPatientToDoctorList(patientId, doctorId);
    }
}
