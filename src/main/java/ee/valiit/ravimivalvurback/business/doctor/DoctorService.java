package ee.valiit.ravimivalvurback.business.doctor;

import ee.valiit.ravimivalvurback.business.doctor.dto.DoctorPatientInfo;
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
public class DoctorService {
    private DoctorPatientRepository doctorPatientRepository;
    private ContactRepository contactRepository;
    private DoctorPatientMapper doctorPatientMapper;
    private ContactMapper contactMapper;

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
}
