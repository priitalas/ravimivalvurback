package ee.valiit.ravimivalvurback.domain.user.doctor;

import ee.valiit.ravimivalvurback.business.doctor.dto.DoctorPatientInfo;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface DoctorPatientMapper {
    @Mapping(source = "patient.id", target = "patientId")
    @Mapping(source = "status", target = "patientStatus")
    DoctorPatientInfo toDoctorPatientInfo(DoctorPatient doctorPatient);

    List<DoctorPatientInfo> toDoctorPatientInfos(List<DoctorPatient> doctorPatient);
}