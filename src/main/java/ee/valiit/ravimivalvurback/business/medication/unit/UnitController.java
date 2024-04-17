package ee.valiit.ravimivalvurback.business.medication.unit;

import ee.valiit.ravimivalvurback.business.medication.unit.dto.UnitInfo;
import ee.valiit.ravimivalvurback.business.medication.unit.dto.UnitRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class UnitController {

    private UnitService unitService;
    @GetMapping("/units")
    public List<UnitInfo> getUnits(){
        return unitService.getUnits();
    }

    @PostMapping("/units")
    public void addNewUnit(@RequestBody UnitRequest unitRequest){
    unitService.addNewUnit(unitRequest);
    }
}
