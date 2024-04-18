package ee.valiit.ravimivalvurback.business.medication.medicationplan;

import ee.valiit.ravimivalvurback.domain.medicationplan.MedicationPlan;
import ee.valiit.ravimivalvurback.domain.medicationplan.MedicationPlanRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class MedicationPlanService {

    private final MedicationPlanRepository medicationPlanRepository;

    public List<MedicationPlan> findPatientMedicationPlans(Integer patientId) {
        List<MedicationPlan> medicationPlans = medicationPlanRepository.findMedicationPlansBy(patientId);
        return medicationPlans;
    }
}
