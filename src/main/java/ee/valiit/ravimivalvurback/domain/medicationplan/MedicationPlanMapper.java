package ee.valiit.ravimivalvurback.domain.medicationplan;

import ee.valiit.ravimivalvurback.business.medication.medicationplan.dto.MedicationPlanInfo;
import ee.valiit.ravimivalvurback.business.medication.medicationplan.dto.PatientMedicationPlan;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface MedicationPlanMapper {

    @Mapping(source = "id", target = "medicationPlanId")
    @Mapping(source = "medication.id", target = "medicationId")
    @Mapping(source = "medication.name", target = "medicationName")
    @Mapping(source = "medication.unit.name", target = "medicationUnitName")
    @Mapping(source = "medication.note", target = "medicationNote")
    PatientMedicationPlan toPatientMedicationPlan(MedicationPlan medicationPlan);


    List<PatientMedicationPlan> toPatientMedicationPlans(List<MedicationPlan> medicationPlans);


    @Mapping(source = "status", target = "medicationPlanStatus")
    @Mapping(source = "frequency", target = "frequency")
    @Mapping(source = "periodStart", target = "periodStart")
    @Mapping(source = "periodEnd", target = "periodEnd")
    @Mapping(source = "medication.name", target = "medicationName")
    @Mapping(source = "id", target = "medicationPlanId")
    MedicationPlanInfo toMedicationPlanInfo(MedicationPlan medicationPlan);

    List<MedicationPlanInfo> toMedicationPlanInfos(List<MedicationPlan> medicationPlan);


}