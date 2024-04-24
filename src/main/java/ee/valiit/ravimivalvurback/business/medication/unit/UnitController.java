package ee.valiit.ravimivalvurback.business.medication.unit;

import ee.valiit.ravimivalvurback.business.medication.unit.dto.UnitInfo;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class UnitController {

    private UnitService unitService;

    @GetMapping("/units")
    @Operation(summary = "Toob ära kõik andmebaasis olevad ravimite ühikud")
    public List<UnitInfo> getUnits() {
        return unitService.getUnits();
    }

    @PostMapping("/unit")
    @Operation(summary = "Lisab ühiku")
    public Integer addNewUnit(@RequestParam String unitName) {
        return unitService.addNewUnit(unitName);
    }

}
