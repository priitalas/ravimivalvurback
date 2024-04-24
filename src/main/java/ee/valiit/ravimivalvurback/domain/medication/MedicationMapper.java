package ee.valiit.ravimivalvurback.domain.medication;

import ee.valiit.ravimivalvurback.business.medication.dto.MedicationInfo;
import ee.valiit.ravimivalvurback.business.medication.dto.MedicationsInfo;
import ee.valiit.ravimivalvurback.domain.Status;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface MedicationMapper {
    @Mapping(source="medicationName", target="name")
    @Mapping(source="description", target="description")
    @Mapping(source="note", target="note")
    @Mapping(constant = Status.ACTIVE, target = "status")
    Medication toMedication(MedicationInfo medicationInfo);

   @Mapping(source = "id", target = "medicationId")
   @Mapping(source = "name", target = "medicationName")
   @Mapping(source = "unit.name", target = "unitName")
   MedicationsInfo toMedicationsInfo(Medication medication);
   List<MedicationsInfo> toMedicationsInfos(List<Medication> medications);


//    @Mapping(source = "name", target = "medicationName")
//    @Mapping(source = "description", target = "description")
//    @Mapping(source = "note", target = "note")
//    MedicationInfo toMedicationInfo(Medication medication);



}