package ee.valiit.ravimivalvurback.domain.medication.unit;

import ee.valiit.ravimivalvurback.business.medication.unit.dto.UnitInfo;
import ee.valiit.ravimivalvurback.business.medication.unit.dto.UnitRequest;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UnitMapper {

    @Mapping(source = "id", target = "unitId")
    @Mapping(source = "name", target = "unitName")
    UnitInfo toUnitInfo(Unit unit);

    List<UnitInfo> toUnitInfos(List<Unit> units);

    @Mapping(source = "unitName", target = "name")
    Unit toUnit(UnitRequest unitRequest);

}