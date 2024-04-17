package ee.valiit.ravimivalvurback.business.medication.unit;

import ee.valiit.ravimivalvurback.business.medication.unit.dto.UnitInfo;
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
    public Integer addNewUnit(@RequestParam String unitName){
        return unitService.addNewUnit(unitName);
    }

}
