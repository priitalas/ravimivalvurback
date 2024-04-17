package ee.valiit.ravimivalvurback.domain.user.doctor;

import ee.valiit.ravimivalvurback.business.patient.dto.DoctorPatientInfo;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface PatientMapper {
    @Mapping(source = "patient", target = "patientId")
    DoctorPatientInfo toDoctorPatientInfo(Patients patients);

    List<DoctorPatientInfo> toDoctorPatientInfos(List<Patients> patients);
}