package ee.valiit.ravimivalvurback.domain.user.contact;

import ee.valiit.ravimivalvurback.business.doctor.dto.DoctorPatientInfo;
import ee.valiit.ravimivalvurback.business.patient.dto.PatientDoctorInfo;
import ee.valiit.ravimivalvurback.business.patient.dto.PatientNotInDoctorListInfo;
import ee.valiit.ravimivalvurback.business.user.dto.ContactInfo;
import ee.valiit.ravimivalvurback.business.registration.dto.RegistrationRequest;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ContactMapper {
    @Mapping(source = "firstName", target = "firstName")
    @Mapping(source = "lastName", target = "lastName")
    @Mapping(source = "email", target = "email")
    Contact toContact(RegistrationRequest registrationRequest);

    @Mapping(source = "firstName", target = "firstName")
    @Mapping(source = "lastName", target = "lastName")
    DoctorPatientInfo toDoctorPatientInfo(Contact contact);
    List<DoctorPatientInfo> toDoctorPatientInfos(List<Contact> contacts);

    @Mapping(source = "user.id", target = "patientId")
    @Mapping(source = "firstName", target = "firstName")
    @Mapping(source = "lastName", target = "lastName")
    PatientNotInDoctorListInfo toPatientsNotInDoctorActiveListInfo(Contact allPatients);
    List<PatientNotInDoctorListInfo> toAllPatientsInfos(List<Contact> allPatients);


    @Mapping(source = "user.id", target = "doctorPatientId")
    @Mapping(source = "firstName", target = "doctorFirstName")
    @Mapping(source = "lastName", target = "doctorLastName")
    PatientDoctorInfo toPatientDoctorInfo(Contact contact);

    @Mapping(source = "firstName", target = "firstName")
    @Mapping(source = "lastName", target = "lastName")
    @Mapping(source = "email", target = "email")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateContact(ContactInfo contactInfo, @MappingTarget Contact contact);

    @Mapping(source = "firstName", target = "firstName")
    @Mapping(source = "lastName", target = "lastName")
    @Mapping(source = "email", target = "email")
    ContactInfo toContactInfo(Contact contact);
}

