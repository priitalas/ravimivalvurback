package ee.valiit.ravimivalvurback.business.patient;

import ee.valiit.ravimivalvurback.business.patient.dto.LogbookInfo;
import ee.valiit.ravimivalvurback.business.patient.dto.PatientDoctorInfo;
import ee.valiit.ravimivalvurback.domain.Status;
import ee.valiit.ravimivalvurback.domain.medicationplan.Logbook;
import ee.valiit.ravimivalvurback.domain.medicationplan.LogbookMapper;
import ee.valiit.ravimivalvurback.domain.medicationplan.LogbookRepository;
import ee.valiit.ravimivalvurback.domain.user.contact.Contact;
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

    private final DoctorPatientRepository doctorPatientRepository;
    private final DoctorPatientMapper doctorPatientMapper;
    private final ContactRepository contactRepository;
    private final LogbookRepository logbookRepository;
    private final LogbookMapper logbookMapper;

    public PatientDoctorInfo getPatientDoctorRelationshipRequest(Integer patientId) {
        DoctorPatient doctorPatient = doctorPatientRepository.findPatientBy(patientId, Status.PENDING);
        PatientDoctorInfo patientDoctorInfo = doctorPatientMapper.toPatientDoctorInfo(doctorPatient);
        Contact contact = contactRepository.getContactBy(doctorPatient.getDoctor().getId());
        patientDoctorInfo.setDoctorFirstName(contact.getFirstName());
        patientDoctorInfo.setDoctorLastName(contact.getLastName());
        return patientDoctorInfo;
    }

    public void patientAcceptsDoctorRelationshipRequest(Integer doctorPatientId) {
        // todo: implemeteeri teenus (Status "P" muuta status "A")

    }

    public List<Logbook> getPatientMedicationLogbook(Integer patientId) {
       List<Logbook> logbook = logbookRepository.findLogbookBy(patientId);
       ValidationService.validatePatientHasTakenAnyMedications(logbook);
       return logbookMapper.toLogbookInfos(logbook);
    }
}