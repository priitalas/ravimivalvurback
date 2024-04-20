package ee.valiit.ravimivalvurback.business.patient;

import ee.valiit.ravimivalvurback.business.patient.dto.DoctorPatientInfo;
import ee.valiit.ravimivalvurback.business.patient.dto.PatientNotInDoctorListInfo;
import ee.valiit.ravimivalvurback.domain.user.User;
import ee.valiit.ravimivalvurback.domain.user.contact.Contact;
import ee.valiit.ravimivalvurback.domain.user.contact.ContactRepository;
import ee.valiit.ravimivalvurback.domain.user.doctor.DoctorPatient;
import ee.valiit.ravimivalvurback.domain.user.doctor.DoctorPatientMapper;
import ee.valiit.ravimivalvurback.domain.user.doctor.DoctorPatientRepository;
import ee.valiit.ravimivalvurback.infrastructure.validation.ValidationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class DoctorService {
    private DoctorPatientRepository doctorPatientRepository;
    private ContactRepository contactRepository;
    private DoctorPatientMapper doctorPatientMapper;

    public List<DoctorPatientInfo> findActivePatients(Integer doctorId) {
        List<DoctorPatient> doctorPatients = doctorPatientRepository.findPatientsBy(doctorId, "A");
        ValidationService.validateDoctorHasPatients(doctorPatients);

        List<DoctorPatientInfo> doctorPatientInfos = doctorPatientMapper.toDoctorPatientInfos(doctorPatients);

        for (DoctorPatientInfo doctorPatientInfo : doctorPatientInfos) {
            Contact contact = contactRepository.findContactBy(doctorPatientInfo.getPatientId());
            doctorPatientInfo.setFirstName(contact.getFirstName());
            doctorPatientInfo.setLastName(contact.getLastName());
        }
        return doctorPatientInfos;
    }

    public List<PatientNotInDoctorListInfo> findPatientsNotInDoctorActiveList(Integer doctorId) {
        List<PatientNotInDoctorListInfo> patientNotInDoctorListInfos = new ArrayList<>();
        List<Contact> allPatients = contactRepository.findContactsByRole("patient");
        for (Contact patient : allPatients) {
            if (!doctorPatientRepository.findPatientsIdBy(doctorId).contains(patient.getUser().getId())) {
                PatientNotInDoctorListInfo patientNotInDoctorListInfo = new PatientNotInDoctorListInfo();
                patientNotInDoctorListInfo.setPatientId(patient.getUser().getId());
                patientNotInDoctorListInfo.setFirstName(patient.getFirstName());
                patientNotInDoctorListInfo.setLastName(patient.getLastName());
                patientNotInDoctorListInfos.add(patientNotInDoctorListInfo);
            }
        }
        ValidationService.validateDoctorHasNewPatientsToAdd(patientNotInDoctorListInfos);
        return patientNotInDoctorListInfos;
    }

    public void postNewPatientToDoctorList(Integer patientId, Integer doctorId) {
        DoctorPatient doctorPatient = new DoctorPatient();
        User doctor = new User();
        doctor.setId(doctorId);
        doctorPatient.setDoctor(doctor);
        User patient = new User();
        patient.setId(patientId);
        doctorPatient.setPatient(patient);
        doctorPatient.setStatus("P");
        doctorPatientRepository.save(doctorPatient);
    }
}