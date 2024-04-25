package ee.valiit.ravimivalvurback.domain.medicationplan;

import ee.valiit.ravimivalvurback.business.patient.dto.LogbookInfo;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface LogbookMapper {

    @Mapping(source = "medicationPlan.medication.name", target = "medicationName")
    @Mapping(source = "date", target = "date")
    @Mapping(source = "time", target = "time")
    @Mapping(source = "id", target = "patientLogbookId")
    LogbookInfo toLogbookInfo(Logbook logbook);

    List<Logbook> toLogbookInfos(List<Logbook> logbook);


}