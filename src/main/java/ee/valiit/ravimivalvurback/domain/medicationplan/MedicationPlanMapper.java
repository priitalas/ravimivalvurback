package ee.valiit.ravimivalvurback.domain.medicationplan;

import ee.valiit.ravimivalvurback.business.medication.medicationplan.dto.AddedMedicationPlansInfo;
import ee.valiit.ravimivalvurback.business.medication.medicationplan.dto.MedicationPlanInfo;
import ee.valiit.ravimivalvurback.business.medication.medicationplan.dto.NewMedicationPlanInfo;
import ee.valiit.ravimivalvurback.business.medication.medicationplan.dto.PatientMedicationPlan;
import ee.valiit.ravimivalvurback.domain.Status;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

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


    @Mapping(source="periodEnd", target ="periodEnd")
    @Mapping(source="periodStart", target ="periodStart")
    @Mapping(constant = Status.ACTIVE, target = "status")
    MedicationPlan toMedicationPlan(NewMedicationPlanInfo newMedicationPlanInfo);

    @Mapping(source = "id", target = "medicationPlanId")
    @Mapping(source = "medication.name", target = "medicationName")
    @Mapping(source = "periodStart", target = "periodStart")
    @Mapping(source = "periodEnd", target = "periodEnd")
    @Mapping(source = "frequency", target = "frequency")
    AddedMedicationPlansInfo toNewMedicationPlansInfo(MedicationPlan medicationPlan);
    List<AddedMedicationPlansInfo> toNewMedicationPlansInfos(List<MedicationPlan> medicationPlan);


}