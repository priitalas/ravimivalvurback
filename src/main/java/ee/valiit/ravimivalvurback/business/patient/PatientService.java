package ee.valiit.ravimivalvurback.business.patient;

import ee.valiit.ravimivalvurback.business.patient.dto.PatientDoctorInfo;
import ee.valiit.ravimivalvurback.domain.Status;
import ee.valiit.ravimivalvurback.domain.user.contact.Contact;
import ee.valiit.ravimivalvurback.domain.user.contact.ContactRepository;
import ee.valiit.ravimivalvurback.domain.user.doctor.DoctorPatient;
import ee.valiit.ravimivalvurback.domain.user.doctor.DoctorPatientMapper;
import ee.valiit.ravimivalvurback.domain.user.doctor.DoctorPatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor

public class PatientService {

    private final DoctorPatientRepository doctorPatientRepository;
    private final DoctorPatientMapper doctorPatientMapper;
    private final ContactRepository contactRepository;

    public PatientDoctorInfo getPatientDoctorRelationshipRequest(Integer patientId) {
        DoctorPatient doctorPatient = doctorPatientRepository.findPatientBy(patientId, Status.PENDING);
        PatientDoctorInfo patientDoctorInfo =  doctorPatientMapper.toPatientDoctorInfo(doctorPatient);
        Contact contact = contactRepository.getContactBy(doctorPatient.getDoctor().getId());
        patientDoctorInfo.setDoctorFirstName(contact.getFirstName());
        patientDoctorInfo.setDoctorLastName(contact.getLastName());
        return patientDoctorInfo;
    }

    public void patientAcceptsDoctorRelationshipRequest(Integer doctorPatientId) {
        // todo: implemeteeri teenus (Status "P" muuta status "A")

    }
}