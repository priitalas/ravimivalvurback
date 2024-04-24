package ee.valiit.ravimivalvurback.business.patient;

import ee.valiit.ravimivalvurback.business.patient.dto.PatientDoctorInfo;
import ee.valiit.ravimivalvurback.domain.Status;
import ee.valiit.ravimivalvurback.domain.user.contact.Contact;
import ee.valiit.ravimivalvurback.domain.user.contact.ContactMapper;
import ee.valiit.ravimivalvurback.domain.user.contact.ContactRepository;
import ee.valiit.ravimivalvurback.domain.user.doctor.DoctorPatient;
import ee.valiit.ravimivalvurback.domain.user.doctor.DoctorPatientMapper;
import ee.valiit.ravimivalvurback.domain.user.doctor.DoctorPatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class PatientService {

    private final DoctorPatientRepository doctorPatientRepository;
    private final DoctorPatientMapper doctorPatientMapper;
    private final ContactRepository contactRepository;
    private final ContactMapper contactMapper;


    public PatientDoctorInfo findPatientPendingStatus(Integer patientId) {
        DoctorPatient patientByPendingStatus = doctorPatientRepository.findPatientByPendingStatus(patientId, Status.PENDING);
       PatientDoctorInfo patientDoctorInfo = doctorPatientMapper.toPatientDoctorInfo(patientByPendingStatus);

        for (PatientDoctorInfo doctorInfo : patientDoctorInfo) {
            Contact contact = contactRepository.findDoctorBy(doctorInfo.getDoctorId());
            doctorInfo.setFirstName(contact.getFirstName());
            doctorInfo.setLastName(contact.getLastName());
        }
        return patientDoctorInfo;
    }
}





//    public void findPatientMedications(Integer patientId) {
//        medicationRepository.findMedicationBy(patientId);
//    }

