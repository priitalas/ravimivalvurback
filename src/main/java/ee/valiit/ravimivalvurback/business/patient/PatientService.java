package ee.valiit.ravimivalvurback.business.patient;

import ee.valiit.ravimivalvurback.business.patient.dto.DoctorPatientInfo;
import ee.valiit.ravimivalvurback.domain.user.contact.Contact;
import ee.valiit.ravimivalvurback.domain.user.contact.ContactMapper;
import ee.valiit.ravimivalvurback.domain.user.contact.ContactRepository;
import ee.valiit.ravimivalvurback.domain.user.doctor.Patients;
import ee.valiit.ravimivalvurback.domain.user.doctor.PatientMapper;
import ee.valiit.ravimivalvurback.domain.user.doctor.PatientRepository;
import ee.valiit.ravimivalvurback.infrastructure.validation.ValidationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PatientService {
    private PatientRepository patientRepository;
    private ContactRepository contactRepository;
    private PatientMapper patientMapper;
    private ContactMapper contactMapper;

    public List<DoctorPatientInfo> findPatients(Integer doctorId) {
        boolean noPatientsFound = patientRepository.noPatientsFound(doctorId);
        ValidationService.validateDoctorHasPatients(noPatientsFound);
        List<Patients> patients = patientRepository.findPatientsBy(doctorId);
        List<Contact> contacts = contactRepository.findContactsBy(patients);
        List<DoctorPatientInfo> doctorPatientInfos = contactMapper.toDoctorPatientInfos(contacts);
        return doctorPatientInfos;
    }
}
