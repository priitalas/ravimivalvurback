package ee.valiit.ravimivalvurback.business.medication.medicationPlan;

import ee.valiit.ravimivalvurback.domain.medicationplan.MedicationPlanRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MedicationPlanService {

    private final MedicationPlanRepository medicationPlanRepository;

    public void findPatientMedicationPlan(Integer patientId) {
    }
}
