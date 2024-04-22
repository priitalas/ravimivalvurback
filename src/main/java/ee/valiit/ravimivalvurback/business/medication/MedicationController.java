package ee.valiit.ravimivalvurback.business.medication;

import ee.valiit.ravimivalvurback.business.medication.dto.MedicationInfo;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class MedicationController {

    private MedicationService medicationService;


    @PostMapping("/medication")
    @Operation(summary = "Lisab andmebaasi uue ravimi")
    public void addNewMedication(@RequestBody @Valid MedicationInfo medicationInfo) {
        medicationService.addNewMedication(medicationInfo);
    }

    @GetMapping("/medications")
    @Operation(summary = "Leiab andmebaasist kõik ravimid, mille staatus on A (aktiivne)")
    public void getAllActiveMedications() {
        medicationService.getAllActiveMedications();
    }

}
