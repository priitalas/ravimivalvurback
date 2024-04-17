package ee.valiit.ravimivalvurback.business.medication.unit;

import ee.valiit.ravimivalvurback.business.medication.unit.dto.UnitInfo;
import ee.valiit.ravimivalvurback.business.medication.unit.dto.UnitRequest;
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

    public void addNewUnit(UnitRequest unitRequest) {
        boolean unitExists = unitRepository.unitExists(unitRequest.getUnitName());
        ValidationService.validateUnitNameAvailable(unitExists);
        Unit unit = unitMapper.toUnit(unitRequest);
        unitRepository.save(unit);
    }
}
