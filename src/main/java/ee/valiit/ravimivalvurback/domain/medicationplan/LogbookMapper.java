package ee.valiit.ravimivalvurback.domain.medicationplan;

import ee.valiit.ravimivalvurback.business.logbook.dto.LogbookInfo;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface LogbookMapper {

    @Mapping(source = "id", target = "patientLogbookId")
    @Mapping(source = "medicationPlan.medication.name", target = "medicationName")
    @Mapping(source = "date", target = "date")
    @Mapping(source = "time", target = "time")
    LogbookInfo toLogbookInfo(Logbook logbook);

    List<LogbookInfo> toLogbookInfos(List<Logbook> logbook);


}