package ee.valiit.ravimivalvurback.business.medication;

import ee.valiit.ravimivalvurback.business.medication.dto.MedicationInfo;
import ee.valiit.ravimivalvurback.business.medication.dto.MedicationInfoExtended;
import ee.valiit.ravimivalvurback.business.medication.dto.MedicationsInfo;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class MedicationController {

    private MedicationService medicationService;


    @PostMapping("/medication")
    @Operation(summary = "Lisab andmebaasi uue ravimi")
    public Integer addNewMedication(@RequestBody @Valid MedicationInfo medicationInfo) {
        medicationService.addNewMedication(medicationInfo);
        return medicationService.addNewMedication(medicationInfo);
    }

    @GetMapping("/medications")
    @Operation(summary = "Leiab andmebaasist kõik ravimid, mille staatus on A (aktiivne)")
    public List<MedicationsInfo> getAllActiveMedications() {
        medicationService.getAllActiveMedications();
        return medicationService.getAllActiveMedications();
    }

//    @GetMapping("/medication/{medicationId}")
//    @Operation(summary = "Leiab andmebaasist medicationId järgi konkreetse ravimi laiendatud info koos pildiga")
//    public void getExtendedMedicationInfo(@PathVariable Integer medicationId) {
//        medicationService.getExtendedMedicationInfo();
//
//    }

//    public MedicationInfoExtended getExtendedMedicationInfo(@PathVariable Integer medicationId) {
//        return medicationService.getExtendedMedicationInfo(medicationId);
    }

