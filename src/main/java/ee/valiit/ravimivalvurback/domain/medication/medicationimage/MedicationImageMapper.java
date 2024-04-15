package ee.valiit.ravimivalvurback.domain.medication.medicationimage;

import ee.valiit.ravimivalvurback.business.medication.dto.MedicationInfo;
import ee.valiit.ravimivalvurback.util.StringConverter;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, imports = {StringConverter.class})
public interface MedicationImageMapper {
    @Mapping( expression = "java(StringConverter.stringToBytes(medicationInfo.getMedicationImage()))", target = "data")
    MedicationImage toMedicationImage(MedicationInfo medicationInfo);

    }