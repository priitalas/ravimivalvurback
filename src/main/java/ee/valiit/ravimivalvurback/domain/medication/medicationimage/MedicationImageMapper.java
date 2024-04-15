package ee.valiit.ravimivalvurback.domain.medication.medicationimage;

import ee.valiit.ravimivalvurback.business.medication.dto.MedicationInfo;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface MedicationImageMapper {
    @Mapping( expression = "java(StringConverter.stringToBytes(medicationInfo.getMedicationImage()))", target = "data")
    MedicationImage toMedicationImage(MedicationInfo medicationInfo);

    }