package ee.valiit.ravimivalvurback.business.medication.unit;

import ee.valiit.ravimivalvurback.business.medication.unit.dto.UnitInfo;
import ee.valiit.ravimivalvurback.domain.medication.unit.Unit;
import ee.valiit.ravimivalvurback.domain.medication.unit.UnitMapper;
import ee.valiit.ravimivalvurback.domain.medication.unit.UnitRepository;
import ee.valiit.ravimivalvurback.infrastructure.validation.ValidationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UnitService {

    private final UnitRepository unitRepository;
    private final UnitMapper unitMapper;
    public List<UnitInfo> getUnits() {
        List<Unit> units = unitRepository.findAll();
        return unitMapper.toUnitInfos(units);
    }

    public void addNewUnit(String unitName) {
        boolean unitExists = unitRepository.unitExists(unitName);
        ValidationService.validateUnitNameAvailable(unitExists);
        Unit unit = new Unit();
        unit.setName(unitName);
        unitRepository.save(unit);
    }
}
