package ee.valiit.ravimivalvurback.business.patient;

import ee.valiit.ravimivalvurback.business.patient.dto.PatientDoctorInfo;
import ee.valiit.ravimivalvurback.domain.Status;
import ee.valiit.ravimivalvurback.domain.user.User;
import ee.valiit.ravimivalvurback.domain.user.UserMapper;
import ee.valiit.ravimivalvurback.domain.user.UserRepository;
import ee.valiit.ravimivalvurback.domain.user.contact.Contact;
import ee.valiit.ravimivalvurback.domain.user.contact.ContactRepository;
import ee.valiit.ravimivalvurback.domain.user.doctor.DoctorPatient;
import ee.valiit.ravimivalvurback.domain.user.doctor.DoctorPatientMapper;
import ee.valiit.ravimivalvurback.domain.user.doctor.DoctorPatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor

public class PatientService {

    private final DoctorPatientRepository doctorPatientRepository;
    private final DoctorPatientMapper doctorPatientMapper;
    private final ContactRepository contactRepository;
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public PatientDoctorInfo getPatientDoctorRelationshipRequest(Integer patientId) {
        DoctorPatient doctorPatient = doctorPatientRepository.findPatientBy(patientId, Status.PENDING);
        PatientDoctorInfo patientDoctorInfo = doctorPatientMapper.toPatientDoctorInfo(doctorPatient);
        Contact contact = contactRepository.getContactBy(doctorPatient.getDoctor().getId());
        patientDoctorInfo.setDoctorFirstName(contact.getFirstName());
        patientDoctorInfo.setDoctorLastName(contact.getLastName());
        return patientDoctorInfo;
    }

    @Transactional
    public void patientDoctorRelationshipResponse(Integer doctorPatientId, Boolean hasAccepted) {
        User user = userRepository.getReferenceById(doctorPatientId);
        user.setStatus(Status.ACTIVE);
        userRepository.save(user);
        DoctorPatient doctorPatient = doctorPatientRepository.getReferenceById(doctorPatientId);
        if (hasAccepted.booleanValue()) {
            doctorPatient.setStatus(Status.ACTIVE);
            doctorPatientRepository.save(doctorPatient);
        }else{
            doctorPatientRepository.delete(doctorPatient);
        }

        // todo: implemeteeri teenus
        // todo: otsi üles doctorPatientId abil üles doctor_patient rida kui objekt 'doctorPatient'
        // todo: 'doctorPatient' objekti küljes on ka olemas 'user' objekt
        // todo: muuda ära 'user' staatus "A"-ks
        // todo: salvesta userRepository abil ära 'user'
        //  kui hasAccepted on true, siis muuta ära 'doctorPatient' staatus "A"-ks
        // todo: salvesta doctorPatienRepository abil ära 'doctorPatient'
        // todo: else
        // todo: kustuta doctorPatienRepository abil ära 'doctorPatient'
        // todo: doctorPatienRepository.delete(doctorPatient)


    }




}