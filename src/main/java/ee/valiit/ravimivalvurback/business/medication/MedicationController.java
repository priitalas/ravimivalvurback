package ee.valiit.ravimivalvurback.business.medication;

import ee.valiit.ravimivalvurback.business.medication.dto.MedicationInfo;
import ee.valiit.ravimivalvurback.business.medication.dto.UnitInfo;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class MedicationController {

    private MedicationService medicationService;

    // todo: teeme hiljem
    @GetMapping("/medications/patient")
    public void findPatientMedications(@RequestParam Integer patientId) {
        medicationService.findPatientMedications(patientId);
    }

    @PostMapping("/medication")
    public void addNewMedication(@RequestBody @Valid MedicationInfo medicationInfo) {
        medicationService.addNewMedication(medicationInfo);
    }

    @GetMapping("/units")
    public List<UnitInfo> getUnits(){
       return medicationService.getUnits();
    }
}
