package ee.valiit.ravimivalvurback.domain.medication;

import ee.valiit.ravimivalvurback.business.medication.dto.MedicationInfo;
import ee.valiit.ravimivalvurback.domain.Status;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface MedicationMapper {
    @Mapping(source="medicationName", target="name")
    @Mapping(source="description", target="description")
    @Mapping(source="note", target="note")
    @Mapping(constant = Status.ACTIVE, target = "status")
    Medication toMedication(MedicationInfo medicationInfo);

}