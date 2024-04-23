package ee.valiit.ravimivalvurback.business.patient;

import ee.valiit.ravimivalvurback.domain.Status;
import ee.valiit.ravimivalvurback.domain.user.doctor.DoctorPatient;
import ee.valiit.ravimivalvurback.domain.user.doctor.DoctorPatientMapper;
import ee.valiit.ravimivalvurback.domain.user.doctor.DoctorPatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor

public class PatientService {


    public void findPatientPendingStatus(Integer patientId) {

    }
}





//    public void findPatientMedications(Integer patientId) {
//        medicationRepository.findMedicationBy(patientId);
//    }

