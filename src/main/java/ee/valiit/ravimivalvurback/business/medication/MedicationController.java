package ee.valiit.ravimivalvurback.business.medication;

import ee.valiit.ravimivalvurback.business.medication.dto.MedicationInfo;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class MedicationController {

    private MedicationService medicationService;


    @PostMapping("/medication")
    public void addNewMedication(@RequestBody @Valid MedicationInfo medicationInfo) {
        medicationService.addNewMedication(medicationInfo);
    }

}
