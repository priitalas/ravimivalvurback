package ee.valiit.ravimivalvurback.domain.medicationplan;

import ee.valiit.ravimivalvurback.business.medication.medicationplan.dto.MedicationPlanInfo;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface MedicationPlanMapper {


    @Mapping(source = "patient.id", target = "patientId")
    @Mapping(source = "status", target = "medicationPlanStatus")
    @Mapping(source = "medication.id", target = "medicationId")
    @Mapping(source = "medication.unit.name", target = "medicationUnitName")
    @Mapping(source = "medication.name", target = "medicationName")
    @Mapping(source = "medication.note", target = "medicationNote")
    @Mapping(source = "medication.description", target = "medicationDescription")
    @Mapping(source = "medication.status", target = "medicationStatus")
    @Mapping(source = "frequency", target = "frequency")
    @Mapping(source = "periodStart", target = "periodStart")
    @Mapping(source = "periodEnd", target = "periodEnd")

    MedicationPlanInfo toMedicationPlanInfo(MedicationPlan medicationPlan);



}