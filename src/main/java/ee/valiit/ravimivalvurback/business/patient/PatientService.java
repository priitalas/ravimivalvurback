package ee.valiit.ravimivalvurback.business.patient;

import ee.valiit.ravimivalvurback.domain.user.doctor.DoctorPatientRepository;
import ee.valiit.ravimivalvurback.infrastructure.validation.ValidationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PatientService {
    private DoctorPatientRepository doctorPatientRepository;
    public void findPatients(Integer doctorId) {
        boolean noPatientsFound = doctorPatientRepository.noPatientsFound(doctorId);
        ValidationService.validateDoctorHasPatients(noPatientsFound);
    }
}
