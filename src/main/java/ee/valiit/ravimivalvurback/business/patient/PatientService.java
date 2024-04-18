package ee.valiit.ravimivalvurback.business.patient;

import ee.valiit.ravimivalvurback.business.patient.dto.DoctorPatientInfo;
import ee.valiit.ravimivalvurback.domain.user.contact.Contact;
import ee.valiit.ravimivalvurback.domain.user.contact.ContactMapper;
import ee.valiit.ravimivalvurback.domain.user.contact.ContactRepository;
import ee.valiit.ravimivalvurback.domain.user.doctor.DoctorPatient;
import ee.valiit.ravimivalvurback.domain.user.doctor.DoctorPatientMapper;
import ee.valiit.ravimivalvurback.domain.user.doctor.DoctorPatientRepository;
import ee.valiit.ravimivalvurback.infrastructure.validation.ValidationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PatientService {
    private DoctorPatientRepository doctorPatientRepository;
    private ContactRepository contactRepository;
    private DoctorPatientMapper doctorPatientMapper;
    private ContactMapper contactMapper;

    public List<DoctorPatientInfo> findPatients(Integer doctorId) {
        boolean noPatientsFound = doctorPatientRepository.noPatientsFound(doctorId);
        ValidationService.validateDoctorHasPatients(noPatientsFound);
        List<DoctorPatient> doctorPatients = doctorPatientRepository.findPatientsBy(doctorId, "A");

        List<Contact> contacts = contactRepository.findContactsBy(doctorPatients);
        List<DoctorPatientInfo> doctorPatientInfos = contactMapper.toDoctorPatientInfos(contacts);
        return doctorPatientInfos;
    }
}
