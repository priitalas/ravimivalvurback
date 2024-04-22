package ee.valiit.ravimivalvurback.business.patient;

import ee.valiit.ravimivalvurback.domain.medication.MedicationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@AllArgsConstructor

public class PatientService {

    private final MedicationRepository medicationRepository;

//    public void findPatientMedications(Integer patientId) {
//        medicationRepository.findMedicationBy(patientId);
//    }

}
