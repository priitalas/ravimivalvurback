package ee.valiit.ravimivalvurback.business.patient;

import ee.valiit.ravimivalvurback.business.patient.dto.DoctorPatientInfo;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class DoctorController {
    private DoctorService doctorService;

    @GetMapping("/patients")
    public List<DoctorPatientInfo> findActivePatients(@RequestParam Integer doctorId){
        List<DoctorPatientInfo> activePatients = doctorService.findActivePatients(doctorId);
        return activePatients;
    }
}
