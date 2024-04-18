package ee.valiit.ravimivalvurback.domain.medicationplan;

import ee.valiit.ravimivalvurback.business.medication.medicationplan.dto.MedicationPlanInfo;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface MedicationPlanMapper {



    @Mapping(source = "status", target = "medicationPlanStatus")
    @Mapping(source = "frequency", target = "frequency")
    @Mapping(source = "periodStart", target = "periodStart")
    @Mapping(source = "periodEnd", target = "periodEnd")
    @Mapping(source = "medication.name", target = "medicationName")
    @Mapping(source = "id", target = "medicationPlanId")
    MedicationPlanInfo toMedicationPlanInfo(MedicationPlan medicationPlan);

    List<MedicationPlanInfo> toMedicationPlanInfos(List<MedicationPlan> medicationPlan);

}