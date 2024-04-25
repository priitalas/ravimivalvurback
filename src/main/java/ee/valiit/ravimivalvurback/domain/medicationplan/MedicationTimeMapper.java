package ee.valiit.ravimivalvurback.domain.medicationplan;

import ee.valiit.ravimivalvurback.business.medication.medicationplan.dto.AddMedicationTimeRequest;
import ee.valiit.ravimivalvurback.business.medication.medicationplan.dto.MedicationTimesInfo;
import org.mapstruct.*;

import java.util.List;
import java.util.Optional;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface MedicationTimeMapper {
    @Mapping(source="slotStart", target = "slotStart")
    @Mapping(source="slotEnd", target = "slotEnd")
    @Mapping(source="quantity", target = "quantity")
    MedicationTime toMedicationTime(AddMedicationTimeRequest addMedicationTimeRequest);

    @Mapping(source = "id", target = "timeslotId")
    @Mapping(source = "slotStart", target = "slotStart")
    @Mapping(source = "slotEnd", target = "slotEnd")
    @Mapping(source = "quantity", target = "quantity")
    MedicationTimesInfo toMedicationTimesInfo(MedicationTime medicationTimes);
    List<MedicationTimesInfo> toMedicationTimesInfos (List<MedicationTime> medicationTimes);

}