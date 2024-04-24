package ee.valiit.ravimivalvurback.business.patient;

import ee.valiit.ravimivalvurback.business.patient.dto.PatientDoctorInfo;
import ee.valiit.ravimivalvurback.domain.Status;
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

    public PatientDoctorInfo findPatientPendingStatus(Integer patientId) {
        DoctorPatient patientByPendingStatus = doctorPatientRepository.findPatientByPendingStatus(patientId, Status.PENDING);
        PatientDoctorInfo patientDoctorInfo = doctorPatientMapper.toPatientDoctorInfo(patientByPendingStatus);

        return patientDoctorInfo;
    }
}





//    public void findPatientMedications(Integer patientId) {
//        medicationRepository.findMedicationBy(patientId);
//    }

