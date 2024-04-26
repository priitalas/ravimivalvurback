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
        return medicationService.addNewMedication(medicationInfo);
    }

    @GetMapping("/medications")
    @Operation(summary = "Leiab andmebaasist kõik ravimid, mille staatus on A (aktiivne)")
    public List<MedicationsInfo> getAllActiveMedications() {
        return medicationService.getAllActiveMedications();
    }

    @GetMapping("/medication/{medicationId}")
    @Operation(summary = "Toob andmebaasidest ravimi ID järgi ravimi laiendatud info koos pildiga")
    public MedicationInfoExtended getMedicationExtendedInfo(@PathVariable Integer medicationId) {
        MedicationInfoExtended medicationInfoExtended = medicationService.getMedicationExtendedInfo(medicationId);
        return medicationInfoExtended;
    }
}

