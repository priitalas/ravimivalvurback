package ee.valiit.ravimivalvurback.domain.medication.unit;

import ee.valiit.ravimivalvurback.business.medication.dto.UnitInfo;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UnitMapper {

    @Mapping(source = "id", target = "unitId")
    @Mapping(source = "name", target = "unitName")
    UnitInfo toUnitInfo(Unit unit);

    List<UnitInfo> toUnitInfos(List<Unit> units);

}