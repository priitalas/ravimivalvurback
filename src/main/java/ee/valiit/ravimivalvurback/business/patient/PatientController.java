package ee.valiit.ravimivalvurback.business.patient;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class PatientController {
    private PatientService patientService;

    @GetMapping("/patients")
    public void findPatients(@RequestParam Integer doctorId){
        patientService.findPatients(doctorId);
    }
}
