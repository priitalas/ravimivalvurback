package ee.valiit.ravimivalvurback.business.patient;

import ee.valiit.ravimivalvurback.business.patient.dto.PatientInfo;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class PatientController {

    private PatientService patientService;

    @GetMapping("/patient")
    public void findPatientMedications(@RequestParam Integer patientId) {
        List<PatientInfo> patientMedications= patientService.findPatientMedications(patientId);
        return patientMedications;
    }
}
