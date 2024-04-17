package ee.valiit.ravimivalvurback.business.medication.unit;

import ee.valiit.ravimivalvurback.business.medication.unit.dto.UnitInfo;
import ee.valiit.ravimivalvurback.business.medication.unit.dto.UnitRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class UnitController {

    private UnitService unitService;
    @GetMapping("/units")
    public List<UnitInfo> getUnits(){
        return unitService.getUnits();
    }

    @PostMapping("/unit")
    public void addNewUnit(@RequestParam String unitName){
    unitService.addNewUnit(unitName);
    }
}
