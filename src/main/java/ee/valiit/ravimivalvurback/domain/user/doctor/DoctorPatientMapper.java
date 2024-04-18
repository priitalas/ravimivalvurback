package ee.valiit.ravimivalvurback.domain.user.doctor;

import ee.valiit.ravimivalvurback.business.patient.dto.DoctorPatientInfo;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface DoctorPatientMapper {
    @Mapping(source = "patient", target = "patientId")
    DoctorPatientInfo toDoctorPatientInfo(DoctorPatient doctorPatient);

    List<DoctorPatientInfo> toDoctorPatientInfos(List<DoctorPatient> patients);
}